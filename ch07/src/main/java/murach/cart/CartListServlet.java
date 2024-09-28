/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.cart;
import murach.business.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import murach.business.Items;
import murach.business.Product;

/**
 *
 * @author ASUS
 */
public class CartListServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";
        // get current action
        String action = request.getParameter("action");
        if(action == null){
            action = "join"; // default action
        }
        // perform action and set URL to appropriate page
        if(action.equals("join")){
            url = "/index.jsp"; // the "join page 
        }
        if(action.equals("add")){
            // get parameters from the request
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String productId = request.getParameter("id");
            
            Product pro = new Product(name, price, productId);
            
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            
            if(cart == null){
                cart = new Cart();
                cart.addProduct(cart, pro, 1);
            }
            
            else {
                cart.handleId(cart, pro, productId);
            }

            session.setAttribute("cart", cart);
            url = "/yourCart.jsp";
            
        }
        if(action.equals("update")){
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            String productId = request.getParameter("productId");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            cart.updateCart(cart, productId, quantity);
            
            session.setAttribute("cart", cart);
            url = "/yourCart.jsp";
        }
        if(action.equals("remove")){
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            String productId = request.getParameter("productId");
            cart.removeCart(cart, productId);
            session.setAttribute("cart", cart);
            url = "/yourCart.jsp";
        }
        if(action.equals("checkout"))
        {
            url = "/checkout.jsp";
        }
        getServletContext()
              .getRequestDispatcher(url)
              .forward(request, response);
    }
    
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
