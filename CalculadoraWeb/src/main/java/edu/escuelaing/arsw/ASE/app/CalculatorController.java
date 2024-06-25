package edu.escuelaing.arsw.ASE.app;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private double currentValue = 0.0;

    @GetMapping("/add")
    public double add(@RequestParam double operand) {
        currentValue += operand;
        return currentValue;
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double operand) {
        currentValue -= operand;
        return currentValue;
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double operand) {
        currentValue *= operand;
        return currentValue;
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double operand) {
        if (operand != 0) {
            currentValue /= operand;
        } else {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return currentValue;
    }

    @GetMapping("/clear")
    public double clear() {
        currentValue = 0.0;
        return currentValue;
    }
}
