package Beans;

import CrudServices.CrudInterface;
import Entities.Product;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ProductBean {
    @Inject
    private CrudInterface crudService;

    public void save(Product product) {
        crudService.save(product);
    }

    public Product find(int id) {
        return (Product)crudService.find(Product.class, id);
    }

    public void remove(int id) {
        crudService.remove(Product.class, id);
    }

    public Product change(Product product) {
        return (Product)crudService.change(product);
    }

    public Class getProductClass() {
        return Product.class;
    }

    public List getAll() {
        return crudService.getAll("Products.findAll", Product.class);
    }
}
