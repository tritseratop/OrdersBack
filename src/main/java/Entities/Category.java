package Entities;

import javax.persistence.*;

@Entity
@Table(name = "Category")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category {
    @Id
    //@GeneratedValue
    private int id;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    /*@OneToMany(mappedBy = "productCategory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(name = "PRODUCT_ID")
    private Set<Product> products;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /*public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }*/

    public Category() {}

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    /*    public Category create(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        return category;
    }*/

    /*public String toString() {
        String string = " ";
        for (Product product: products
             ) {
            string = string + " " + product;
        }
        return  "ID: " + id +
                "\nCategory name: " + categoryName +
                "\nConnected products: " + string;
    }*/
}
