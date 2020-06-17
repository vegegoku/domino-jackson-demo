package or.dominokit.samples;

import or.dominokit.samples.complex.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {


    public static void main(String[] args) {
        Customer customer = new Customer();

        customer.setId(1);
        customer.setFirstName("Ahmad");
        customer.setLastName("Bawaneh");
        customer.setEmail("akabme@gmail.com");

        Address address1 = new Address();
        address1.setId(1);
        address1.setCity("Amman");
        address1.setCountry("Jordan");
        address1.setPostalCode("1234");
        address1.setStreetAddress("AlRabieh - Abdullah ben rawha street");

        Address address2 = new Address();
        address2.setId(2);
        address2.setCity("Irbid");
        address2.setCountry("Jordan");
        address2.setPostalCode("1233");
        address2.setStreetAddress("Hareema - Hreema street");

        List<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);

        customer.setAddresses(addresses);

        Order order1 = new Order();
        order1.setId(1);
        order1.setDistention(address1);
        order1.setDescription("order abc 1");
        order1.setPaymentType(PaymentType.VISA);
        order1.setStatus(OrderStatus.DELIVERED);
        order1.setItems(createItems(3));

        Order order2 = new Order();
        order2.setId(2);
        order2.setDistention(address1);
        order2.setDescription("order abc 2");
        order2.setPaymentType(PaymentType.VISA);
        order2.setStatus(OrderStatus.DELIVERED);
        order2.setItems(createItems(4));

        Order order3 = new Order();
        order3.setId(3);
        order3.setDistention(address2);
        order3.setDescription("order abc 3");
        order3.setPaymentType(PaymentType.CASH_ON_DELIVERY);
        order3.setStatus(OrderStatus.DELIVERED);
        order3.setItems(createItems(2));

        Order order4 = new Order();
        order4.setId(4);
        order4.setDistention(address1);
        order4.setDescription("order abc 4");
        order4.setPaymentType(PaymentType.CASH_ON_DELIVERY);
        order4.setStatus(OrderStatus.SHIPPED);
        order4.setItems(createItems(6));

        List<Order> historyOrders = new ArrayList<>();
        historyOrders.add(order1);
        historyOrders.add(order2);
        historyOrders.add(order3);

        customer.setHistoryOrders(historyOrders);

        List<Order> onGoingOrders = new ArrayList<>();
        onGoingOrders.add(order4);

        customer.setOnGoingOrders(onGoingOrders);

        customer.setNotes("Gold customer");

        System.out.println(Customer_MapperImpl.INSTANCE.write(customer));
    }

    private static List<Item> createItems(int count) {

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Item item = new Item();
            item.setId(UUID.randomUUID().toString());
            item.setName("ITEM-" + i);
            item.setDescription("Item description " + i);
            item.setAvailableQuantity((int) ((Math.random() * (100))));
            item.setPrice(new BigDecimal((int) ((Math.random() * (1000 + 1) + 1))));
            items.add(item);
        }
        return items;
    }
}
