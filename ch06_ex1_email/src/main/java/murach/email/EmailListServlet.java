/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.email;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import murach.business.User;
import murach.data.UserDB;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author ASUS
 */
public class EmailListServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(EmailListServlet.class.getName());
    @Override
    protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
                      throws ServletException, IOException {

        String url = "/index.jsp";
    
        // get current action
        String action = request.getParameter("action");
        System.out.println("Check Action: "+ action);
        logger.log(Level.INFO, "Action parameter: {0}", action);
        
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.jsp";    // the "join" page
        } 
        else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            
            User user = new User(firstName, lastName, email);
            
            // validate the parameter
            
            String message;
            if(firstName == null || lastName == null || email == null
                    || firstName.isEmpty() || lastName.isEmpty() || 
                    email.isEmpty()){
                message = "Please fill out all three text boxes.";
                url = "/index.jsp";
            }
            else {
                message = "";
                url = "/thanks.jsp";
                UserDB.insert(user);
            }
            
            request.setAttribute("user", user);
            request.setAttribute("message", message);
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
     }

}
