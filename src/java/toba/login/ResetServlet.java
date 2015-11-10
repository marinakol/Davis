package toba.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ResetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passwordOld = request.getParameter("passwordOld");
        String passwordNew = request.getParameter("passwordNew");

        try {
            HttpSession session = request.getSession();
            String cpass = (String) session.getAttribute("password");
            String uname = (String) session.getAttribute("username");

            if (passwordOld == null || passwordOld.isEmpty() || passwordNew == null || passwordNew.isEmpty()) {
                request.setAttribute("msg", "All fields are required");
                getServletContext().getRequestDispatcher("/password_reset.jsp").forward(request, response);

            } else if (!cpass.equals(passwordOld)) {
                request.setAttribute("msg", "Old password is not valid");
                getServletContext().getRequestDispatcher("/password_reset.jsp").forward(request, response);
            } else {

                session.setAttribute("password", passwordNew);
                getServletContext().getRequestDispatcher("/account_activity.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
