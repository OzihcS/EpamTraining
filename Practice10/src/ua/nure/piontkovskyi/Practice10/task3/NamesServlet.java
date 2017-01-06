package ua.nure.piontkovskyi.Practice10.task3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Part3")
public class NamesServlet extends HttpServlet {
    static List<String> names = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("remove")) {
            HttpSession session = request.getSession(true);
            session.removeAttribute("names");
        }
        RequestDispatcher view = request.getRequestDispatcher("task3.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String name = request.getParameter("name");
        names = (List<String>) session.getAttribute("names");

        if (names == null) {
            names = new ArrayList<>();
        }
        names.add(name);
        session.setAttribute("names", names);
        response.sendRedirect("task3.jsp?id=" + (names.size() - 1));
    }
}
