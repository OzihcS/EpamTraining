package ua.nure.piontkovskyi.Practice10.task4;

import ua.nure.piontkovskyi.Practice10.task4.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        String errorMsg = null;

        if (login == null || login.equals("")) {
            errorMsg = "User Login can't be null or empty";
        }
        if (password == null || password.equals("")) {
            errorMsg = "Password can't be null or empty";
        }
        if (errorMsg != null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            request.setAttribute("errorMsg", errorMsg);
            rd.include(request, response);
        } else {
            DBManager dbManager = DBManager.getInstance();
            User user;
            user = dbManager.getUserByLoginAndPassword(login, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("PRINCIPAL", user);
                session.setAttribute("User", user);
                response.sendRedirect("home.jsp");
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
                errorMsg = "No user found with given login " + login;
                request.setAttribute("errorMsg", errorMsg);
                rd.include(request, response);
            }
        }
    }
}
