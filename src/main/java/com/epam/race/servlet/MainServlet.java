package com.epam.race.servlet;

import com.epam.race.command.ActionFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.race.command.Command;
import com.epam.race.pool.ConnectionPool;
import com.epam.race.util.constant.StringConstant;

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

        logger.log(Level.INFO, "Command: " + req.getParameter(StringConstant.COMMAND));
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
