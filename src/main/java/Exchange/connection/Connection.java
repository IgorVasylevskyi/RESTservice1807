package Exchange.connection;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Connection {

    public static HttpURLConnection connection;
    public static double USD;
    public static double GBP;
    public static Date date;


    public static void connection() throws IOException, JSONException, ParseException {

        BufferedReader reader;
        String line;
        StringBuffer responseText = new StringBuffer();

        //URL url = new URL("https://api.exchangeratesapi.io/latest?symbols=USD,GBP");
        URL url1 = new URL("https://api.exchangerate-api.com/v4/latest/eur");
        connection = (HttpURLConnection) url1.openConnection();

        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int status = connection.getResponseCode();

        if (status > 299) {
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            while ((line = reader.readLine()) != null) {
                responseText.append(line);
            }
            reader.close();
        } else {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                responseText.append(line);
            }
            reader.close();
        }

        parse(responseText.toString());

        connection.disconnect();
    }

    public static String parse(String responseText) throws JSONException, ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");

        JSONObject rate = new JSONObject(responseText);
        JSONObject currencies = rate.getJSONObject("rates");

        for (int i = 0; i < currencies.length(); i++) {
            USD = currencies.getDouble("USD");
            GBP = currencies.getDouble("GBP");
        }

        String datePost = rate.getString("date");
        date = dateFormat.parse(datePost);


//        System.out.println("Rates to EUR for date: " + dateFormat2.format(date));
//        System.out.println("USD: " + USD);
//        System.out.println("GBP: " + GBP);

        return null;
    }
}
