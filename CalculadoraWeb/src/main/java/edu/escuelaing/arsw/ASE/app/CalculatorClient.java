package edu.escuelaing.arsw.ASE.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CalculatorClient {

    private static final String BASE_URL = "http://localhost:8080/api/calculator/";

    public static void main(String[] args) throws Exception {
        System.out.println("Add: " + sendRequest("add?operand=5"));
        System.out.println("Subtract: " + sendRequest("subtract?operand=2"));
        System.out.println("Multiply: " + sendRequest("multiply?operand=3"));
        System.out.println("Divide: " + sendRequest("divide?operand=4"));
        System.out.println("Clear: " + sendRequest("clear"));
    }

    private static String sendRequest(String endpoint) throws Exception {
        URL url = new URL(BASE_URL + endpoint);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content.toString();
        } else {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }
    }
}
