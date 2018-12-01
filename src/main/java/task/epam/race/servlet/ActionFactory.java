package task.epam.race.servlet;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task.epam.race.command.*;

import javax.servlet.http.HttpServletRequest;
import java.util.EnumMap;

public enum ActionFactory {
    INSTANCE;
    private static Logger logger = LogManager.getLogger(ActionFactory.class);



    public Command getCommand(HttpServletRequest req){
        Command result = CommandMap.INSTANCE.getCommand(CommandType.valueOf(req.getParameter("command").replace(' ','_').
                toUpperCase()));
        logger.log(Level.INFO,"CommandClass: " + result.getClass());
        return result;
    }
}
