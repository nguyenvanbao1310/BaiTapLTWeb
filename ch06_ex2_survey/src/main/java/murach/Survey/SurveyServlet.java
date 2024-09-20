/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.Survey;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import murach.User.User;

/**
 *
 * @author ASUS
 */
public class SurveyServlet extends HttpServlet {

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
         String url = "/index.html";
        // get current action
        String action = request.getParameter("action");
        if(action == null){
            action = "join"; // default action
        }
        // perform action and set URL to appropriate page
        if(action.equals("join")){
            url = "/index.html"; // the "join page 
        }
        else if(action.equals("add")){
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String radio = request.getParameter("heardFrom");
            String check = request.getParameter("yes");
            String option = request.getParameter("contact");
            
            
            User user = new User();
            user.setFirstName(firstName);
            user.setlastName(lastName);
            user.setEmail(email);
            user.setRadio(radio);
            user.setCheck(check);
            user.setOption(option);
            request.setAttribute("user", user);
            
            url = "/survey.jsp";
            
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
