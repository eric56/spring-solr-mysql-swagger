package com.koin.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RequestUtil {

    public String sendRequestGET(String url) throws IOException {

        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            return EntityUtils.toString(response.getEntity());

        }

    }

}
