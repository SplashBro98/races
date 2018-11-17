package task.epam.race.servlet;

import task.epam.race.command.*;

import javax.servlet.http.HttpServletRequest;
import java.util.EnumMap;
import java.util.Optional;

public enum RequestHelper {
    INSTANCE;

    private EnumMap<CommandType, Command> commandMap = new EnumMap<CommandType, Command>(CommandType.class);

    RequestHelper() {
        commandMap.put(CommandType.LOGIN, new LoginCommand());
        commandMap.put(CommandType.RETURN, new ReturnCommand());
        commandMap.put(CommandType.ERROR, new NoCommand());
    }

    public Command getCommand(HttpServletRequest req){
        Command result = commandMap.get(CommandType.valueOf(req.getParameter("command").replace(' ','_').
                toUpperCase()));
        if(result == null){
            result = new NoCommand();
        }
        return result;
    }

    public void addCommand(CommandType type, Command command) {
        commandMap.put(type, command);
    }
}
