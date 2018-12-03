package task.epam.race.command.impl.page;

import task.epam.race.command.Command;
import task.epam.race.command.PageManager;

import javax.servlet.http.HttpServletRequest;

public class ToLoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest req){
        return PageManager.INSTANCE.getProperty(PageManager.PATH_LOGIN_PAGE);
    }
}
