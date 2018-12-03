package task.epam.race.command;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public enum ActionFactory {
    INSTANCE;
    private static Logger logger = LogManager.getLogger(ActionFactory.class);



    public Command getCommand(HttpServletRequest req){
        String commandName = req.getParameter("command");
        CommandType commandType = CommandType.valueOf(commandName.replace(' ','_').
                toUpperCase());
        Command result = CommandMap.INSTANCE.getCommand(commandType);
        logger.log(Level.INFO,"CommandClass: " + result.getClass());
        return result;
    }
}
