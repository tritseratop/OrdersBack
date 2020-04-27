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

    public void save(Orders orders) {
        crudService.save(orders);

    }

    public Orders find(Class type, int id) {
        return (Orders)crudService.find(type, id);
    }

    public void remove(Class type, int id) {
        crudService.remove(type, id);
    }

    public Orders change(Orders orders) {
        return (Orders)crudService.change(orders);
    }

    public Class getOrdersClass() {
        return Orders.class;
    }

    public Orders acceptOrder(Orders order) {
        int orderNumber = order.getOrderNumber();
        int productId = order.getOrderProduct().getId();
        Product product = productBean.find(Product.class, productId);
        product.setProductNumber(product.getProductNumber()-orderNumber);
        productBean.change(product);
        crudService.save(order);
        return order;
    }

    public void delete (int id) {
        Orders order = (Orders)crudService.find(Orders.class, id);
        int orderNumber = order.getOrderNumber();
        int productId = order.getOrderProduct().getId();
        Product product = productBean.find(Product.class, productId);
        product.setProductNumber(product.getProductNumber()+orderNumber);
        productBean.change(product);
        crudService.remove(Orders.class, id);
    }

    /*public Orders changeOrder(Orders order) {

    }*/

}
