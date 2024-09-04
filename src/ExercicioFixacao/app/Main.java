package ExercicioFixacao.app;

import ExercicioFixacao.entities.Client;
import ExercicioFixacao.entities.Order;
import ExercicioFixacao.entities.OrderItem;
import ExercicioFixacao.entities.Product;
import ExercicioFixacao.entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Birth date (DD/MM/YYYY): ");
        String dateString = sc.nextLine();
        LocalDate dateClient = LocalDate.parse(dateString, dtf);
        Client client = new Client(name, email, dateClient);
        System.out.println("Enter order date:");
        System.out.println("Status: ");
        String status = sc.nextLine();
        System.out.println("How many items to this order? ");
        int n = sc.nextInt();

        Order order = new Order(LocalDateTime.now(), client, OrderStatus.valueOf(status));

        for(int i = 0; i < n; i++){
            System.out.println("Enter #" + (i + 1) + " item data:");
            System.out.println("Product name: ");
            String productName = sc.next();
            System.out.println("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.println("Quantity: ");
            int quantity = sc.nextInt();
            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(quantity, product, product.getPrice());
            order.addItem(orderItem);
        }


        System.out.println("ORDER SUMMARY: ");
        System.out.println("Order Moment: " + order.getMoment());
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client: " + client);
        System.out.println("Order items: ");
        for(OrderItem item : order.getOrderItems()){
            System.out.println(item);
        }
        System.out.println("Total price: " + order.total());

    }
}
