package Beans;

import CrudServices.CrudInterface;
import Entities.Product;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProductBean {
    @Inject
    private CrudInterface crudService;

    public void save(Product product) {
        crudService.save(product);
    }

    public Product find(Class type, int id) {
        return (Product)crudService.find(type, id);
    }

    public void remove(Class type, int id) {
        crudService.remove(type, id);
    }

    public Product change(Product product) {
        return (Product)crudService.change(product);
    }

    public Class getProductClass() {
        return Product.class;
    }

}
