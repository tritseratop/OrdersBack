package Beans;

import CrudServices.CrudInterface;
import Entities.Client;
import Entities.Producer;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProducerBean {
    @Inject
    private CrudInterface crudService;

    public void save(Producer producer) {
        crudService.save(producer);
    }

    public Producer find(Class type, int id) {
        return (Producer)crudService.find(type, id);
    }

    public void remove(Class type, int id) {
        crudService.remove(type, id);
    }

    public Producer change(Producer producer) {
        return (Producer)crudService.change(producer);
    }

    public Class getProducerClass() {
        return Producer.class;
    }

}
