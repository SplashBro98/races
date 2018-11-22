package task.epam.race.command.impl;


import task.epam.race.command.Command;
import task.epam.race.entity.Horse;
import task.epam.race.entity.User;
import task.epam.race.entity.UserType;
import task.epam.race.repository.HorseRepository;
import task.epam.race.repository.UserRepository;
import task.epam.race.servlet.ConfigurationManager;
import task.epam.race.specification.SQLSpecification;
import task.epam.race.specification.horse.SelectAllHorsesSpecification;
import task.epam.race.specification.user.InsertUserSpecification;
import task.epam.race.util.encryption.Encryption;
import task.epam.race.util.validation.SignUpValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class SignUpCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) throws ServletException, IOException {

        User user = new User();
        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setLogin(req.getParameter("login"));
        user.setEmail(req.getParameter("email"));

        String encryptedPassword = Encryption.encrypt(req.getParameter("password"));
        user.setPassword(encryptedPassword);
        user.setUserType(UserType.valueOf(req.getParameter("userType").replace(' ','_').toUpperCase()));

        String page;
        try {
            SignUpValidator validator = new SignUpValidator();
            if(validator.checkLogin(user.getLogin())) {
                new UserRepository().add(user);
                List<Horse> horses = new HorseRepository().query(new SelectAllHorsesSpecification());
                req.setAttribute("horses", horses);
                page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_MAIN_PAGE);
            }else {
                req.setAttribute("incorrect_login","User with this login is already exists");
                page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_SIGN_UP_PAGE);
            }
        }catch (SQLException e){
            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
