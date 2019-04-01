package main;

import com.procourier.model.Address;
import com.procourier.model.Buyer;
import com.procourier.model.Courier;
import com.procourier.model.Order;
import com.procourier.model.OrderLine;
import com.procourier.model.Product;
import com.procourier.model.Seller;
import service.OrderService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        org.h2.tools.Server.createWebServer("-webPort", "10500").start();
        OrderService orderService = OrderService.getInstance();

        //prima comanda
        Product phone = new Product(1000L, "Huawei P30", "New phone", 270L);
        Product laptop = new Product(1500L, "Sony Vayo", "Old laptop ", 1700L);
        Address emagAddress = new Address("Bucuresti", "Bucuresti", "Soseaua Virtutii", "20A");
        Address johnAddress = new Address("Dolj", "Craiova", "Ecaterina Teodoroiu", "11");
        Address proCourierAddress = new Address("Timis", "Timisoara", "AI Cuza", "86");
        Buyer john = new Buyer("John", johnAddress);
        Seller emag = new Seller("Emag", emagAddress);
        OrderLine olPhone = new OrderLine(phone, 10L);
        OrderLine olLaptop = new OrderLine(laptop, 7L);
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(olPhone);
        orderLines.add(olLaptop);
        Courier courier = new Courier("ProCourier", proCourierAddress, 9L, 13L);
        Order order = new Order(emag, john, courier, orderLines );
        orderService.addOrder(order);
        System.out.println("Order delivered successfully");


        //a doua comanda
        Product phone2 = new Product(1000L, "Samsung S10", "New phone", 270L);
        Product laptop2 = new Product(1500L, "Asus", "Old laptop ", 1700L);
        Address emagAddress2 = new Address("Iasi", "Iasi", "Soseaua Nordului", "5A");
        Address ionAddress2 = new Address("Dolj", "Craiova", "Ecaterina Teodoroiu", "11");
        Address proCourierAddress2 = new Address("Timis", "Timisoara", "AI Cuza", "86");
        Buyer john2 = new Buyer("Ion", ionAddress2);
        Seller emag2 = new Seller("Emag2", emagAddress2);
        OrderLine olPhone2 = new OrderLine(phone2, 20L);
        OrderLine olLaptop2 = new OrderLine(laptop2, 2L);
        List<OrderLine> orderLines2 = new ArrayList<>();
        orderLines2.add(olPhone2);
        orderLines2.add(olLaptop2);
        Courier courier2 = new Courier("ProCourier", proCourierAddress2, 9L, 13L);
        Order order2 = new Order(emag2, john2, courier2, orderLines2 );
        orderService.addOrder(order2);
        System.out.println("Order delivered successfully");

    }
}
