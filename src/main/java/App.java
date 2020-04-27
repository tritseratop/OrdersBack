/*
import Beans.CategoryBean;
import Beans.ProducerBean;
import Beans.ProductBean;
import Entities.Category;
import Entities.Producer;
import Entities.Product;

import javax.ejb.EJB;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class App extends HttpServlet {
//    private static EntityManagerFactory entityManagerFactory =
//            Persistence.createEntityManagerFactory("orders-unit");

    @EJB
    CategoryBean categoryBean;
    @EJB
    ProducerBean producerBean;
    @EJB
    ProductBean productBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = new Category();
        category.setCategoryName("Mobile");
        categoryBean.saveCategory(category);

*/
/*        Producer producer = new Producer();
        producer.setProducerCountry("Russia");
        producer.setProducerName("Huawei");
        producerBean.saveProducer(producer);*//*


*/
/*        Product product = new Product();
        product.setProductName("Huawei P20");
        product.setProductProducer(producerBean.findProducer(3));
        productBean.saveProduct(product);
        PrintWriter pw = response.getWriter();
        pw.println(producerBean.findProducer(3).toString());*//*


    }
}
*/
