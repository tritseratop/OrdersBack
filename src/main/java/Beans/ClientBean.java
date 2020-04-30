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

    public void save(Client client) {
        crudService.save(client);
    }

    public Client find(int id) {
        return (Client)crudService.find(Client.class, id);
    }

    public void remove(int id) {
        crudService.remove(Client.class, id);
    }

    public Client change(Client client) {
        return (Client)crudService.change(client);
    }

    public Class getClientClass() {
        return Client.class;
    }

}
