package task.epam.race.command;

import task.epam.race.command.impl.*;
import task.epam.race.command.impl.page.ToAddHorseCommand;
import task.epam.race.command.impl.page.ToDeleteHorseCommand;
import task.epam.race.command.impl.page.ToLoginCommand;
import task.epam.race.command.impl.page.ToSignUpCommand;

import java.util.EnumMap;

public enum CommandMap {
    INSTANCE;

    private EnumMap<CommandType, Command> commandMap = new EnumMap<>(CommandType.class);

    CommandMap(){
        commandMap.put(CommandType.LOGIN, new LoginCommand());
        commandMap.put(CommandType.ERROR, new NoCommand());
        commandMap.put(CommandType.TO_SIGN_UP, new ToSignUpCommand());
        commandMap.put(CommandType.TO_ADD_HORSE, new ToAddHorseCommand());
        commandMap.put(CommandType.TO_LOGIN, new ToLoginCommand());
        commandMap.put(CommandType.SIGN_UP, new SignUpCommand());
        commandMap.put(CommandType.ADD_HORSE, new AddHorseCommand());
        commandMap.put(CommandType.DELETE_HORSE, new DeleteHorseCommand());
        commandMap.put(CommandType.TO_DELETE_HORSE, new ToDeleteHorseCommand());
        commandMap.put(CommandType.SELECT_HORSE, new SelectHorseCommand());
        commandMap.put(CommandType.SELECT_RACE, new SelectRaceCommand());
    }
    public Command getCommand(CommandType type){
        Command result = commandMap.get(type);
        if(result == null){
            result = new NoCommand();
        }
        return result;
    }

    public void addCommand(CommandType type, Command command){
        commandMap.put(type, command);
    }

}
