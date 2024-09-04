package ExercicioFixacao.entities;

public class OrderItem {
    private final Integer quantity;
    private final Double price;

    private Product product = new Product();

    public OrderItem(Integer quantity, Product product, Double price) {
        this.quantity = quantity;
        this.product = product;
        this.price = price;
    }

    public double subTotal(){
        return quantity * price;
    }

    @Override
    public String toString() {
        return product.getName() + ", " + "$" + price + ", Quantity: " + quantity + ", Subtotal: $" + subTotal();
    }
}
