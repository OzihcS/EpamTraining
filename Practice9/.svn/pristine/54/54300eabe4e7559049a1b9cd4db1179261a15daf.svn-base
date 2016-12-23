package ua.nure.piontkovskyi.Practice9.task2;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        Object names = servletContext.getAttribute("names");

        request.setAttribute("names", names);
        request.getRequestDispatcher("vote.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String select = req.getParameter("select");

        if (Vote.alreadyVoted(userName)) {
            req.getRequestDispatcher("error.html").forward(req, resp);
            return;
        }
        Vote.vote(userName, select);
        int footballCounter = Vote.getFootballCounter();
        int basketballCounter = Vote.getBasketballCounter();
        int biathlonCounter = Vote.getBiathlonCounter();
        HashMap<String, String> map = (HashMap<String, String>) Vote.getMap();

        req.setAttribute("userName", userName);
        req.setAttribute("select", select);
        req.setAttribute("footballCounter", footballCounter);
        req.setAttribute("basketballCounter", basketballCounter);
        req.setAttribute("biathlonCounter", biathlonCounter);
        req.setAttribute("map", map);

        req.getRequestDispatcher("vote-result.jsp").forward(req, resp);
    }
}