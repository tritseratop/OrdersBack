package Beans;

import CrudServices.CrudInterface;
import Entities.Client;
import Entities.Producer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ClientBean {
    @Inject
    private CrudInterface crudService;
    @EJB
    private ProducerBean producerBean;

    public void save(Client client) {
        crudService.save(client);
        Producer producer = new Producer();
        producer.setId(4);
        producer.setProducerName("Xiaomi");
        producerBean.save(producer);
    }

    public Client find(Class type, int id) {
        return (Client)crudService.find(type, id);
    }

    public void remove(Class type, int id) {
        crudService.remove(type, id);
    }

    public Client change(Client client) {
        return (Client)crudService.change(client);
    }

    public Class getClientClass() {
        return Client.class;
    }

}
