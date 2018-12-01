package task.epam.race.command.impl.page;

import task.epam.race.command.Command;
import task.epam.race.servlet.ConfigurationManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ToSignUpCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        return ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_SIGN_UP_PAGE);
    }
}
