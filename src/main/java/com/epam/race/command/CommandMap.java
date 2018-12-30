package com.epam.race.command;

import com.epam.race.command.impl.*;
import com.epam.race.command.impl.page.*;
import com.epam.race.command.impl.LogInCommand;
import com.epam.race.command.impl.SignUpCommand;

import java.util.EnumMap;

public enum CommandMap {
    INSTANCE;

    private EnumMap<CommandType, Command> commandMap = new EnumMap<>(CommandType.class);

    CommandMap(){
        commandMap.put(CommandType.LOG_IN, new LogInCommand());
        commandMap.put(CommandType.ERROR, new NoCommand());
        commandMap.put(CommandType.TO_SIGN_UP, new ToSignUpCommand());
        commandMap.put(CommandType.TO_ADD_HORSE, new ToAddHorseCommand());
        commandMap.put(CommandType.TO_LOG_IN, new ToLogInCommand());
        commandMap.put(CommandType.SIGN_UP, new SignUpCommand());
        //commandMap.put(CommandType.ADD_HORSE, new AddHorseCommand());
        //commandMap.put(CommandType.DELETE_HORSE, new DeleteHorseCommand());
        commandMap.put(CommandType.TO_DELETE_HORSE, new ToDeleteHorseCommand());
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
        commandMap.put(CommandType.TO_ENTER_SUM, new ToEnterSumCommand());
        commandMap.put(CommandType.ENTER_SUM, new EnterSumCommand());
        commandMap.put(CommandType.TO_HOLD_RACE, new ToHoldRaceCommand());
        commandMap.put(CommandType.HOLD_RACE, new HoldRaceCommand());
        commandMap.put(CommandType.TO_ADD_PAYMENT, new ToAddPaymentCommand());
        commandMap.put(CommandType.ADD_PAYMENT, new AddPaymentCommand());
        commandMap.put(CommandType.TO_TOP_UP_BALANCE, new ToTopUpBalanceCommand());
        commandMap.put(CommandType.TOP_UP_BALANCE, new TopUpBalanceCommand());
        commandMap.put(CommandType.TO_ADD_ADMIN, new ToAddAdminCommand());
        commandMap.put(CommandType.TO_ADD_BOOKMAKER, new ToAddBookmakerCommand());
        commandMap.put(CommandType.ADD_ADMIN, new AddAdminCommand());
        commandMap.put(CommandType.ADD_BOOKMAKER, new AddBookmakerCommand());
        commandMap.put(CommandType.TO_EDIT_BET, new ToEditBetCommand());
        commandMap.put(CommandType.EDIT_BET, new EditBetCommand());
        commandMap.put(CommandType.TO_EDIT_PROFILE, new ToEditProfileCommand());
        commandMap.put(CommandType.EDIT_PROFILE, new EditProfileCommand());
        commandMap.put(CommandType.TO_RACE_RESULTS, new ToRaceResultsCommand());
        commandMap.put(CommandType.TO_USER_LIST, new ToUserListCommand());
        commandMap.put(CommandType.TO_USER_BETS, new ToUserBetsCommand());
        commandMap.put(CommandType.BLOCK_USER, new BlockUserCommand());
        commandMap.put(CommandType.UNLOCK_USER, new UnlockUserCommand());
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
