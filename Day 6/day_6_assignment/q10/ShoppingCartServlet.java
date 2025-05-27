import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class ShoppingCartServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String item = req.getParameter("item");
        
        HttpSession session = req.getSession();
        
       
        List<String> cart = (List<String>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        
        if (item != null && !item.trim().isEmpty()) {
            cart.add(item);
        }
        
       
        session.setAttribute("cart", cart);
        
        resp.setContentType("text/html");
        resp.getWriter().println("<h2>Shopping Cart</h2>");
        resp.getWriter().println("<ul>");
        for (String cartItem : cart) {
            resp.getWriter().println("<li>" + cartItem + "</li>");
        }
        resp.getWriter().println("</ul>");
        resp.getWriter().println("<a href='cart.html'>Add more items</a>");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
