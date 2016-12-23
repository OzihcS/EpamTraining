package ua.nure.piontkovskyi.Practice9.task2;

import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        List<String> names = Arrays.asList(sc.getInitParameter("names").split(" "));
        sc.setAttribute("names", names);
    }

    public void contextDestroyed(ServletContextEvent sce) {/* no op */}
}
