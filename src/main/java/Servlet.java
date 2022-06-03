import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet (name = "Servlet", urlPatterns = "/servlet")
public class Servlet extends HttpServlet {
    int random;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().printf("<html><body>");
        List<Product> productList = new ArrayList<Product>();
        for (int i = 0; i < 10; i++){
            random = (int) (Math.random() * 100);
            productList.add(new Product(i, "title" + i, random));
        }

        for (Product product: productList){
            response.getWriter().printf("<p>" + product + "</p>");
        }
        response.getWriter().printf("</body></html>");

    }

    @Override
    public void init() throws ServletException {

    }
}
