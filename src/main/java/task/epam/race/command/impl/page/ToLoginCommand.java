package task.epam.race.command.impl.page;

import task.epam.race.command.Command;
import task.epam.race.servlet.ConfigurationManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ToLoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) throws ServletException, IOException {
        return ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_LOGIN_PAGE);
    }
}
