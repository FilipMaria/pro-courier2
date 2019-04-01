package main;

import com.procourier.model.Order;
import http.GetOrderByIdClient;
import http.GetOrders;

public class Main {
    public static void main(String[] args) {
        GetOrderByIdClient client = new GetOrderByIdClient();
        Order order = client.getOrder(1L);
        System.out.println(order);

       /* GetOrders client = new GetOrders();
        var order = client.getOrder();
        System.out.println(order);
        */
    }
}
