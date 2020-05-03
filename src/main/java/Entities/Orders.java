package Entities;

import javax.persistence.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinColumn(name = "ORDER_CLIENT", referencedColumnName = "ID")
    private Client orderClient;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "ORDER_PRODUCT", referencedColumnName = "ID")
    private Product orderProduct;

    @Column(name = "ORDER_NUMBER")
    private int orderNumber;

    @Column(name = "ORDER_PRICE")
    private int orderPrice;

    @Column(name = "ORDER_STATUS")
    private int orderStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(Product orderProduct) {
        this.orderProduct = orderProduct;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Client getOrderClient() {
        return orderClient;
    }

    public void setOrderClient(Client orderClient) {
        this.orderClient = orderClient;
    }

    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderClient=" + orderClient +
                ", orderProduct=" + orderProduct +
                ", orderNumber=" + orderNumber +
                ", orderPrice=" + orderPrice +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
