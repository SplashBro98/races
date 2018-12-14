package task.epam.race.command.impl.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task.epam.race.command.Command;
import task.epam.race.command.PageManager;
import task.epam.race.command.impl.ProfileCommand;
import task.epam.race.entity.Bet;
import task.epam.race.entity.User;
import task.epam.race.exception.RepositoryException;
import task.epam.race.service.BetService;
import task.epam.race.service.UserService;
import task.epam.race.util.constant.StringAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ToProfileCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToProfileCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;
        try{
            String login = req.getSession().getAttribute(StringAttributes.LOGIN).toString();
            User user = new UserService().findUserByLogin(login);
            req.setAttribute("user",user);
//            List<Bet> userBets = new BetService().findUserBets(login);
//            req.setAttribute("bets",userBets);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_USER_PROFILE_PAGE);
        }catch (RepositoryException e){
            logger.error("problem with database", e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
