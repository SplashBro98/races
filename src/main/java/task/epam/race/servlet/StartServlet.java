package task.epam.race.servlet;

import task.epam.race.entity.Horse;
import task.epam.race.pool.ConnectionPool;
import task.epam.race.pool.ProxyConnection;
import task.epam.race.repository.HorseRepository;
import task.epam.race.specification.AllHorsesSpecification;
import task.epam.race.util.LocaleInstaller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

@WebServlet("/start")
public class StartServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String url = properties.getProperty("db.url");
            String password = properties.getProperty("db.password");
            String name = properties.getProperty("db.username");
            String driverClassName = properties.getProperty("db.classname");

            Class.forName(driverClassName);
            ConnectionPool.getInstance().addConnection(new ProxyConnection(DriverManager.getConnection(url, name,password)));

        }catch (IOException | ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

    }

    Locale locale = new Locale("en","EN");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("en_button") != null){
            locale = new Locale("en", "EN");
        }
        else if(req.getParameter("ru_button") != null){
            locale = new Locale("ru", "RU");
        }
        else if(req.getParameter("de_button") != null){
            locale = new Locale("de", "DE");
        }
        LocaleInstaller installer = new LocaleInstaller();
        installer.installLocale(req, locale);

        try {
            List<Horse> horses = HorseRepository.INSTANCE.query(new AllHorsesSpecification());
            req.setAttribute("horses", horses);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/jsp/start.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Process(req, resp);
    }

    protected void Process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        int years = Integer.parseInt(req.getParameter("age"));
        int wins = Integer.parseInt(req.getParameter("wins"));
        Horse horse = new Horse(name, years, wins);
        try {
            HorseRepository.INSTANCE.add(horse);
            doGet(req,resp);

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}