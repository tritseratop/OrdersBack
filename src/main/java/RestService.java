import Beans.CategoryBean;
import Beans.ClientBean;
import Beans.OrdersBean;
import Beans.ProductBean;
import Entities.Category;
import Entities.Client;
import Entities.Orders;
import Entities.Product;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestScoped
@Path("/")
public class RestService {

    CorsFilter corsFilter;

    @EJB
    CategoryBean categoryBean;
    @EJB
    ClientBean clientBean;
    @EJB
    OrdersBean ordersBean;
    @EJB
    ProductBean productBean;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") String id) {
        Product product = new Product();
        product = productBean.find(Integer.parseInt(id));
        return product;
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProduct() {
        return (List<Product>)productBean.getAll();
    }

    @GET
    @Path("/category")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getAllCategories() {
        return (List<Category>)categoryBean.getAll();
    }

    @PUT
    @Path("/order")
    @Consumes(MediaType.APPLICATION_JSON) // "application/json"
    public Orders addOrder(Orders order) {
        return ordersBean.acceptOrder(order);
    }

    @PUT
    @Path("/client")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addClient(Client client) {
        clientBean.save(client);
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteOrder(@PathParam("id") String id) {
        ordersBean.delete(Integer.parseInt(id));
        return "Your order has been removed";
    }

    /*@GET
    @Path("/put")
    @Consumes(MediaType.APPLICATION_JSON) // "application/json"
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrderTrial() {
        Orders order = new Orders();
        Client client = new Client();
        Product product = new Product();
        product = productBean.find(2);
        client = clientBean.find(1);
        order.setOrderStatus(0);
        order.setOrderPrice(2000);
        order.setOrderNumber(1);
        order.setOrderClient(client);
        order.setOrderProduct(product);
        ordersBean.acceptOrder(order);
        return Response.ok(order)
                .build();
    }*/

    /*@PUT
    @Path
    @Consumes(MediaType.APPLICATION_JSON) // "application/json"
    public String changeOrder(Orders order) {
        return productBean.find(productBean.getProductClass(), Integer.parseInt(id)).toString();
    }*/

}
