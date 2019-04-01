package http;

import com.google.gson.Gson;
import com.procourier.model.Order;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetOrders {
    private Gson gson = new Gson();
    private HttpClient httpClient;

    public GetOrders(){
        httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
    }

    public Order getOrder(){
        final HttpRequest request= HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8082/orders/"))
                .build();

        try {
            final HttpResponse response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return gson.fromJson(response.body().toString(), Order.class);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }


}
