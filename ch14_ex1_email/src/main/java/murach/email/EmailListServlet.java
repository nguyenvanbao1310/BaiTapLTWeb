/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.email;

import jakarta.mail.MessagingException;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import murach.business.User;
import murach.data.UserDB;
import murach.util.MailUtilLocal;

/**
 *
 * @author ASUS
 */
public class EmailListServlet extends HttpServlet {

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
            UserDB.insert(user);
            request.setAttribute("user", user);
            String to = email;
            String from = "email_list@murach.com";
            String subject = "Welcome to our email list";
            String body = "Dear" + firstName + ", \n\n"
                    +"Thanks for joining our email list."
                    +"We'll make sure to send"
                    +"You announcements about new products"
                    +"and promotions. \n"
                    +"Have a great day and thanks again! \n\n"
                    +"Kelly Slivkoff\n"
                    +"Mike Murach & Associates";
            boolean isBodyHTML = false;
            try {
                MailUtilLocal.sendMail(to, from, subject, body, isBodyHTML);
                String sucessMessage = "Email đã được gửi thành công đến " + to + ".";
                request.setAttribute("successMessage",sucessMessage );
            } catch (MessagingException e){
                String errorMessage
                        = "ERROR: Unable to send email. "
                        +"Check Tomcat logs for details. <br>"
                        +"NOTE: You may need to configure your system "
                        +"as described in chapter 14.<br>"
                        +"ERROR MESSAGE: "+ e.getMessage();
                request.setAttribute("errorMessage", errorMessage);
                this.log(
                        "Unable to send email. \n"
                        +"Here is the email you tried to send: \n"
                        +"=====================================\n"
                        +"TO: "+email + "\n"
                        +"FROM: "+from + "\n"
                        +"SUBJECT: "+subject +"\n\n"
                        + body + "\n\n");
            }
            url = "/thanks.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
     }

}
