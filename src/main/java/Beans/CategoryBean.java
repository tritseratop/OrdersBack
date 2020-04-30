package Beans;

import CrudServices.CrudInterface;
import Entities.Category;
import Entities.Product;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CategoryBean {
    @Inject
    private CrudInterface crudService;

    public void save(Category category) {
        crudService.save(category);
    }

    public Category find(int id) {
        return (Category)crudService.find(Category.class, id);
    }

    public void remove(int id) {
        crudService.remove(Category.class, id);
    }

    public Category change(Category category) {
         return (Category)crudService.change(category);
    }

    public Class getCategoryClass() {
        return Category.class;
    }

    public List getAll() {
        return crudService.getAll("Category.findAll", Category.class);
    }

}
