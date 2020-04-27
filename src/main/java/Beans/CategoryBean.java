package Beans;

import CrudServices.CrudInterface;
import Entities.Category;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CategoryBean {
    @Inject
    private CrudInterface crudService;

    public void save(Category category) {
        crudService.save(category);
    }

    public Category find(Class type, int id) {
        return (Category)crudService.find(type, id);
    }

    public void remove(Class type, int id) {
        crudService.remove(type, id);
    }

    public Category change(Category category) {
         return (Category)crudService.change(category);
    }

    public Class getCategoryClass() {
        return Category.class;
    }

}
