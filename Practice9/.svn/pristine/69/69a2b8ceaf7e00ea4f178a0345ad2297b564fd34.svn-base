package ua.nure.piontkovskyi.Practice9.task1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Calc")
public class Calc extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer x = Integer.parseInt(request.getParameter("x"));
        Integer y = Integer.parseInt(request.getParameter("y"));
        String operation = request.getParameter("operation");
        request.setAttribute("x", x);
        request.setAttribute("y", y);
        request.setAttribute("operation", operation);
        request.setAttribute("result", Calculator.calculate(x, y, operation));
        request.getRequestDispatcher("calc-result.jsp").forward(request, response);
    }
}
