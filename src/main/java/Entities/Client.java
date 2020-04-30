package Entities;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "CLIENT_ADDRESS")
    private  String clientAddress;

    @Column(name = "CLIENT_MOBILE")
    private String clientMobile;

    @Column(name = "CLIENT_EMAIL")
    private String clientEmail;

    /*@OneToMany(mappedBy = "orderClient", cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true)
    @Column(name = "ORDERS_ID")
    private Set<Orders> orders;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientMobile() {
        return clientMobile;
    }

    public void setClientMobile(String clientMobile) {
        this.clientMobile = clientMobile;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    /*public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }*/

    public Client() {
    }

    @Override
    public String toString() {
        /*String string = " ";
        for (Orders order: orders
        ) {
            string = string + " " + order.getId();
        }*/
        return "Client{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientMobile='" + clientMobile + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                //", orders=" + string +
                '}';
    }
}
