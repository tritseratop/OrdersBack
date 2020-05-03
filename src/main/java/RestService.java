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

    @POST
    @Path("/order")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON) // "application/json"
    public Orders addOrder(Orders order) {
        return ordersBean.acceptOrder(order);
    }

    @POST
    @Path("/findByCategory")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON) // "application/json"
    public List<Product> findByCategory(Category category) {
        return (List<Product>)productBean.findByCategory(category);
    }

    @POST
    @Path("/client")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Client addClient(Client client) {
        clientBean.save(client);
        return clientBean.find(client.getId());
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteOrder(@PathParam("id") String id) {
        ordersBean.delete(Integer.parseInt(id));
    }

}
