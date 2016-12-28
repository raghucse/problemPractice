package test;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

/**
 * Created by raghu on 12/24/2016.
 */
public class httpRequest {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        try {
            URL url = new URL("http://api.fixer.io/latest?base=USD");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String strTemp = "";
            while (null != (strTemp = br.readLine())) {
                s.append(strTemp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        JSONParser parser = new JSONParser();
        JSONObject j= null;
        JSONObject rate = null;
        try {
            j = (JSONObject)parser.parse(s.toString());
            rate = (JSONObject)j.get("rates");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String inrValue= String.valueOf(rate.get("INR"));
        System.out.println(inrValue);

        long a[] = new long[5];

    }
}
