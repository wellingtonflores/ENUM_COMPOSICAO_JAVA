package ExercicioFixacao.entities;

import ExercicioFixacao.entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final LocalDateTime moment;
    private final OrderStatus status;

    private final List<OrderItem> orderItems = new ArrayList<>();
    private Client client = new Client();

    public Order(LocalDateTime moment, Client client, OrderStatus status) {
        this.moment = moment;
        this.client = client;
        this.status = status;
    }

    public String getMoment() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return moment.format(dtf);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addItem(OrderItem item){
        orderItems.add(item);
    }

    public void removeItem(OrderItem item){
        orderItems.remove(item);
    }

    public double total(){
        double soma = 0;
        for(OrderItem oi : orderItems){
            soma+=oi.subTotal();
        }
        return soma;
    }


}
