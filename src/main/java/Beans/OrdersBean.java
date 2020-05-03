package Beans;

import CrudServices.CrudInterface;
import Entities.Orders;
import Entities.Product;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class OrdersBean {
    @Inject
    private CrudInterface crudService;

    @EJB
    private ProductBean productBean;
    @EJB
    private ClientBean clientBean;

    public void save(Orders orders) {
        crudService.save(orders);

    }

    public Orders find(int id) {
        return (Orders)crudService.find(Orders.class, id);
    }

    public void remove(int id) {
        crudService.remove(Orders.class, id);
    }

    public Orders change(Orders orders) {
        return (Orders)crudService.change(orders);
    }

    public Class getOrdersClass() {
        return Orders.class;
    }

    public Orders acceptOrder(Orders order) {
        //clientBean.save(order.getOrderClient());
        int orderNumber = order.getOrderNumber();
        int productId = order.getOrderProduct().getId();
        Product product = productBean.find(productId);
        product.setProductNumber(product.getProductNumber()-orderNumber);
        productBean.change(product);
        crudService.save(order);
        return order;
    }

    public void delete (int id) {
        Orders order = (Orders)crudService.find(Orders.class, id);
        int orderNumber = order.getOrderNumber();
        int productId = order.getOrderProduct().getId();
        Product product = productBean.find(productId);
        product.setProductNumber(product.getProductNumber()+orderNumber);
        productBean.change(product);
        crudService.remove(Orders.class, id);
    }

    /*public Orders changeOrder(Orders order) {

    }*/

}
