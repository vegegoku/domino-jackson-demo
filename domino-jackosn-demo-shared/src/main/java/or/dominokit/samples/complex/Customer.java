package or.dominokit.samples.complex;

import org.dominokit.jacksonapt.annotation.JSONMapper;

import java.io.Serializable;
import java.util.List;

@JSONMapper
public class Customer implements Serializable {

    private static final long serialVersionUID = 6835192601898364280L;
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Address> addresses;
    private List<Order> historyOrders;
    private List<Order> onGoingOrders;
    private String notes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Order> getHistoryOrders() {
        return historyOrders;
    }

    public void setHistoryOrders(List<Order> historyOrders) {
        this.historyOrders = historyOrders;
    }

    public List<Order> getOnGoingOrders() {
        return onGoingOrders;
    }

    public void setOnGoingOrders(List<Order> onGoingOrders) {
        this.onGoingOrders = onGoingOrders;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Customer[" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", addresses=" + addresses +
                ", historyOrders=" + historyOrders +
                ", onGoingOrders=" + onGoingOrders +
                ", notes='" + notes + '\'' +
                ']';
    }
}