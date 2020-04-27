import Beans.CategoryBean;
import Beans.ClientBean;
import Beans.OrdersBean;
import Beans.ProductBean;
import Entities.Orders;
import Entities.Product;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/order")
public class RestService {

    @EJB
    CategoryBean categoryBean;
    @EJB
    ClientBean clientBean;
    @EJB
    OrdersBean ordersBean;
    @EJB
    ProductBean productBean;

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") String id) {
        Product product = new Product();
        product = productBean.find(Product.class, Integer.parseInt(id));
        return product;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON) // "application/json"
    public Orders addOrder(Orders order) {
        return ordersBean.acceptOrder(order);
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteOrder(@PathParam("id") String id) {
        ordersBean.delete(Integer.parseInt(id));
        return "Your order has been removed";
    }

    @GET
    @Path("/example")
    @Produces(MediaType.TEXT_HTML)
    public String example() {
        return "Hello, world!";
    }

    /*@PUT
    @Path
    @Consumes(MediaType.APPLICATION_JSON) // "application/json"
    public String changeOrder(Orders order) {
        return productBean.find(productBean.getProductClass(), Integer.parseInt(id)).toString();
    }*/

}
