package cs1302.api;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Represents an API application.
 */
public class StockInfo {

    private static final Gson GSON = new Gson();
    private static final String API_KEY = "clj21tpr01qsgccbq250clj21tpr01qsgccbq25g";

    /**
     * Returns the full name of the stock.
     *
     * @param stock the stock symbol
     * @return the full name of the stock
     */
    public String getStockName(String stock) {
        String fullName = "";
        try {
            String url = "https://finnhub.io/api/v1/stock/profile2?symbol="
                + stock + "&token=" + API_KEY;
            String jsonResponse = getResponse(url);
            StockProfile stockProfile = GSON.fromJson(jsonResponse, StockProfile.class);
            fullName = stockProfile.getName();
        } catch (Exception e) {
            e.printStackTrace();
        } // try
        return fullName;
    } // getStockName

    /**
     * Returns the last trade of the stock.
     *
     * @param url the url to get the stock name from
     * @return the last trade of the stock
     */
    private static String getResponse(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request,
                 HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                return String.valueOf(response.statusCode());
            } // if
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        } // try
    } // getResponse
} // stockInfoGetter
