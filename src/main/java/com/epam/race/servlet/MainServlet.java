package com.epam.race.servlet;

import com.epam.race.command.ActionFactory;
import com.epam.race.command.PageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.race.command.Command;
import com.epam.race.pool.ConnectionPool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static Logger logger = LogManager.getLogger(MainServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Router router;
        Command command = ActionFactory.INSTANCE.getCommand(req);

        router = command.execute(req);
        if (router.getPage() != null) {
            logger.log(Level.INFO, "Page: " + router.getPage());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(router.getPage());
            switch (router.getMoveType()) {
                case FORWARD:
                    requestDispatcher.forward(req, resp);
                    break;
                case REDIRECT:
                    String page = req.getContextPath() + router.getPage();
                    resp.sendRedirect(page);
                    break;
                default:
                    throw new ServletException("Unknown router type");
            }
        } else {
            String page = PageManager.INSTANCE.getProperty(PageManager.PATH_LOGIN_PAGE);
            resp.sendRedirect(req.getContextPath() + page);
        }
    }

    @Override
    public void destroy() {
        ConnectionPool.getInstance().closePool();
    }
}
