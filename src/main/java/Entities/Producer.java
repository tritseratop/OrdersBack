package Entities;

import javax.persistence.*;

@Entity
public class Producer {
    @Id
    //@GeneratedValue
    int id;
    @Column(name = "PRODUCER_NAME")
    String producerName;
    @Column(name = "PRODUCER_COUNTRY")
    String producerCountry;

    /*@OneToMany(mappedBy = "productProducer", cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true)
    @Column(name = "PRODUCT_ID")
    private Set<Product> products;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }*/

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getProducerCountry() {
        return producerCountry;
    }

    public void setProducerCountry(String producerCountry) {
        this.producerCountry = producerCountry;
    }

    /*public String toString() {
        String string = " ";
        for (Product product: products
             ) {
            string = string + " " + product.getId();
        }
        return  "ID: " + id +
                "\nProducer name: " + producerName +
                "\nProducer country: " + producerCountry +
                "\nConnected products: " + string;
    }*/

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", producerName='" + producerName + '\'' +
                ", producerCountry='" + producerCountry + '\'' +
                '}';
    }

    public Producer() {
    }
}
