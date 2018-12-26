package com.epam.race.command;

import com.epam.race.command.impl.*;
import com.epam.race.command.impl.page.*;
import com.epam.race.command.impl.*;
import com.epam.race.command.impl.LogInCommand;
import com.epam.race.command.impl.SignUpCommand;
import com.epam.race.command.impl.page.*;

import java.util.EnumMap;

public enum CommandMap {
    INSTANCE;

    private EnumMap<CommandType, Command> commandMap = new EnumMap<>(CommandType.class);

    CommandMap(){
        commandMap.put(CommandType.LOG_IN, new LogInCommand());
        commandMap.put(CommandType.ERROR, new NoCommand());
        commandMap.put(CommandType.TO_SIGN_UP, new ToSignUpCommand());
        commandMap.put(CommandType.TO_ADD_HORSE, new ToAddHorseCommand());
        commandMap.put(CommandType.TO_LOG_IN, new ToLoginCommand());
        commandMap.put(CommandType.SIGN_UP, new SignUpCommand());
        //commandMap.put(CommandType.ADD_HORSE, new AddHorseCommand());
        //commandMap.put(CommandType.DELETE_HORSE, new DeleteHorseCommand());
        commandMap.put(CommandType.TO_DELETE_HORSE, new ToDeleteHorseCommand());
        //commandMap.put(CommandType.SELECT_HORSE, new SelectHorseCommand());
        commandMap.put(CommandType.SELECT_RACE, new SelectRaceCommand());
        commandMap.put(CommandType.ADD_RACE, new AddRaceCommand());
        commandMap.put(CommandType.TO_ADD_RACE, new ToAddRaceCommand());
        commandMap.put(CommandType.LOG_OUT, new LogOutCommand());
        commandMap.put(CommandType.TO_PROFILE, new ToProfileCommand());
        commandMap.put(CommandType.PROFILE, new ProfileCommand());
        commandMap.put(CommandType.CHANGE_LANGUAGE, new ChangeLanguageCommand());
        commandMap.put(CommandType.TO_MAIN, new ToMainCommand());
        commandMap.put(CommandType.TO_ADD_BET, new ToAddBetCommand());
        commandMap.put(CommandType.ADD_BET, new AddBetCommand());
        commandMap.put(CommandType.PAGINATION, new PaginationCommand());
        commandMap.put(CommandType.SELECT_RACE_HORSES, new SelectRaceHorsesCommand());
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
