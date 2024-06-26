package edu.escuelaing.arsw.ASE.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    int count = 0;
    double result = 0.0;

    @GetMapping("/prueba")
    public String loadIndex() {
        return "prueba";
    }

    @GetMapping("/calculator")
    public String showCalculator() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam String number1, Model model) {
        double result1 = 0.0;
        count = 0;
        String operation = getOperation(number1);

        try {
            if (!starting(number1)) {
                result1 = performOperation(number1, operation);
            } else {
                result1 = performOperationWithPreviousResult(number1, operation);
            }
            this.result = result1;
        } catch (Exception e) {
            model.addAttribute("error", "Invalid input or operation");
            result1 = 0.0;
        }

        model.addAttribute("result", result1);
        return "calculator";
    }

    @PostMapping("/case")
    public String cases(@RequestParam String number1, @RequestParam String operation, Model model) {
        count++;
        if (count > 1) {
            model.addAttribute("number1", number1);
            return "calculator";
        }
        switch (operation) {
            case "+":
                model.addAttribute("number1", number1 + "+");
                break;
            case "-":
                model.addAttribute("number1", number1 + "-");
                break;
            case "*":
                model.addAttribute("number1", number1 + "*");
                break;
            case "/":
                model.addAttribute("number1", number1 + "/");
                break;
        }
        model.addAttribute("result", result);
        return "calculator";
    }

    @PostMapping("/clear")
    public String clear(Model model) {
        model.addAttribute("result", 0);
        model.addAttribute("number1", "");
        count = 0;
        result = 0.0;
        return "calculator";
    }

    private double performOperation(String number1, String operation) {
        String[] parts = number1.split(operation);
        double num1 = Double.parseDouble(parts[0]);
        double num2 = Double.parseDouble(parts[1]);

        switch (operation) {
            case "\\+":
                return num1 + num2;
            case "\\-":
                return num1 - num2;
            case "\\*":
                return num1 * num2;
            case "\\/":
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }

    private double performOperationWithPreviousResult(String number1, String operation) {
        double num2 = Double.parseDouble(number1.split(operation)[1]);

        switch (operation) {
            case "\\+":
                return result + num2;
            case "\\-":
                return result - num2;
            case "\\*":
                return result * num2;
            case "\\/":
                return result / num2;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }

    private String getOperation(String op) {
        if (op.contains("+")) {
            return "\\+";
        } else if (op.contains("-")) {
            return "\\-";
        } else if (op.contains("*")) {
            return "\\*";
        } else if (op.contains("/")) {
            return "\\/";
        } else {
            throw new IllegalArgumentException("No valid operation found");
        }
    }

    private boolean starting(String op) {
        return op.startsWith("+") || op.startsWith("-") || op.startsWith("*") || op.startsWith("/");
    }
}
