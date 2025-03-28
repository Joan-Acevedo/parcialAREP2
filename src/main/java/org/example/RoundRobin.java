package org.example;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.coyote.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class RoundRobin {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final List<String> DOMINIOS = Arrays.asList("localhost:8080", "localhost:8080");
    private static int servicioActual = 0;

    public static JSONPObject getCommponent(Request req) throws IOException {

        URL obj = getURL(req);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        StringBuilder response = new StringBuilder();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");

        return null; //response en Json
    }

    private static URL getURL(Request req) throws MalformedURLException {
        System.out.println("Servicio actual: " + servicioActual);
        String dominioActual = DOMINIOS.get(servicioActual);
        String value = req.getPathParameter("value");
        String operation = req.getPathParameter("operation");
        servicioActual = (servicioActual + 1) % DOMINIOS.size();
        return new URL("http://amazon" + dominioActual + operation + "?value" + value);
    }
}
