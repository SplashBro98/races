package task.epam.race.command.impl.auth;

import task.epam.race.command.Command;
import task.epam.race.servlet.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        req.getSession().invalidate();
        return ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_LOGIN_PAGE);
    }
}
