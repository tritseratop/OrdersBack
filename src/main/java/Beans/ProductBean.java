package Beans;

import CrudServices.CrudInterface;
import Entities.Category;
import Entities.Product;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductBean {
    @PersistenceContext(unitName = "orders-unit")
    EntityManager entityManager;

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

    public List findByCategory(Category category) {
        return entityManager.createNamedQuery("Products.findByCategory", Product.class).setParameter("productCategory", category).getResultList();
    }
}
