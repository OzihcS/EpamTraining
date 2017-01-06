package ua.nure.piontkovskyi.Practice10.task6;

import ua.nure.piontkovskyi.Practice10.task4.DBManager;
import ua.nure.piontkovskyi.Practice10.task4.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Rename")
public class Rename extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String newName = request.getParameter("newName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        DBManager db = DBManager.getInstance();
        User user = db.getUserByLoginAndPassword(login, password);
        user.setName(newName);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/task4.jsp");
        if (db.renameUser(user)) {
            request.setAttribute("infoMsg", "User renamed");
        } else {
            request.setAttribute("infoMsg", "Can't rename user!");
        }
        rd.include(request, response);
    }
}
