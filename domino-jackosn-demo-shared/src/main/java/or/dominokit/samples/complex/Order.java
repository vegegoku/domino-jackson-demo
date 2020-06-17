package or.dominokit.samples.complex;

import java.util.List;

public class Order {

    private long id;
    private Address distention;
    private String description;
    private PaymentType paymentType;
    private OrderStatus status;
    private List<Item> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getDistention() {
        return distention;
    }

    public void setDistention(Address distention) {
        this.distention = distention;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order[" +
                "id=" + id +
                ", distention=" + distention +
                ", description='" + description + '\'' +
                ", paymentType=" + paymentType +
                ", status=" + status +
                ", items=" + items +
                ']';
    }
}