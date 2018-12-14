package task.epam.race.servlet;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task.epam.race.command.ActionFactory;
import task.epam.race.command.Command;
import task.epam.race.pool.ConnectionPool;
import task.epam.race.pool.ProxyConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static Logger logger = LogManager.getLogger(MainServlet.class);



    //TODO checkbox and sql-запросы
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        trustTheProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        trustTheProcess(req, resp);
    }

    private void trustTheProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.log(Level.INFO, "Command: " + req.getParameter("command"));
        Command command = ActionFactory.INSTANCE.getCommand(req);
        String page = command.execute(req);

        logger.log(Level.INFO, "Page: " + page);

        getServletContext().getRequestDispatcher(page).forward(req, resp);


    }

    @Override
    public void destroy() {
        ConnectionPool.getInstance().close();
    }
}
