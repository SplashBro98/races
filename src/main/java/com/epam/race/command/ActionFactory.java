package com.epam.race.command;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.race.util.StringConstant;

import javax.servlet.http.HttpServletRequest;

public enum ActionFactory {
    INSTANCE;
    public static final char SPACE_CHAR = ' ';
    private static Logger logger = LogManager.getLogger(ActionFactory.class);



    public Command getCommand(HttpServletRequest req){
        String commandName = req.getParameter(StringConstant.COMMAND);
        CommandType commandType = CommandType.valueOf(commandName.replace(SPACE_CHAR,'_').
                toUpperCase());
        Command result = CommandMap.INSTANCE.getCommand(commandType);
        logger.log(Level.INFO,"CommandClass: " + result.getClass());
        return result;
    }
}
