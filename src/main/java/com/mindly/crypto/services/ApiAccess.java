package com.mindly.crypto.services;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStreamReader;

public class ApiAccess {


    final static String postEndpoint = "https://api.bitfinex.com/v2/calc/fx";

    public double convertToEur(String currency) throws IOException {


        if (currency.equals("Bitcoin")) {
            currency = "BTC";
        } else if (currency.equals("Ethereum")) {
            currency = "ETH";
        } else if (currency.equals("Ripple")) {
            currency = "XRP";
        }

        String inputJson = "{\"ccy1\":\"" + currency + "\",\"ccy2\":\"EUR\"}";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(postEndpoint);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        StringEntity entity = new StringEntity(inputJson);
        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);

        JsonParser jsonParser = new JsonParser();
        JsonElement content = jsonParser.parse(new InputStreamReader((response.getEntity().getContent())));
        return content.getAsDouble();
    }
}


