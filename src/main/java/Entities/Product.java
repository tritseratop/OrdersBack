package Entities;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue
    int id;
    @Column(name = "PRODUCT_CODE")
    @GeneratedValue
    int productCode;
    @Column(name = "PRODUCT_NAME")
    String productName;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_PRODUCER", referencedColumnName = "ID")
    private Producer productProducer;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_CATEGORY", referencedColumnName = "ID")
    private Category productCategory;

    @Column(name = "PRODUCT_NUMBER")
    private int productNumber;

    @Column(name = "PRODUCT_PRICE")
    private int productPrice;

//    @ManyToMany

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Producer getProductProducer() {
        return productProducer;
    }

    public void setProductProducer(Producer productProducer) {
        this.productProducer = productProducer;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productCode=" + productCode +
                ", productName='" + productName + '\'' +
                ", productProducer=" + productProducer +
                ", productCategory=" + productCategory +
                ", productNumber=" + productNumber +
                ", productPrice=" + productPrice +
                '}';
    }
}
