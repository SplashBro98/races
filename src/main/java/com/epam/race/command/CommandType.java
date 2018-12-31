package com.epam.race.command;

public enum CommandType {
    LOG_IN,
    ERROR,
    TO_LOG_IN,
    TO_SIGN_UP,
    SIGN_UP,
    ADD_HORSE,
    TO_ADD_HORSE,
    DELETE_HORSE,
    TO_DELETE_HORSE,
    SELECT_RACE,
    ADD_RACE,
    TO_ADD_RACE,
    LOG_OUT,
    TO_PROFILE,
    CHANGE_LANGUAGE,
    TO_MAIN,
    ADD_BET,
    TO_ADD_BET,
    PAGINATION,
    SELECT_RACE_HORSES,
    TO_ENTER_SUM,
    ENTER_SUM,
    TO_HOLD_RACE,
    HOLD_RACE,
    TO_ADD_PAYMENT,
    ADD_PAYMENT,
    TO_TOP_UP_BALANCE,
    TOP_UP_BALANCE,
    TO_ADD_ADMIN,
    ADD_ADMIN,
    TO_ADD_BOOKMAKER,
    ADD_BOOKMAKER,
    TO_EDIT_BET,
    EDIT_BET,
    TO_EDIT_PROFILE,
    EDIT_PROFILE,
    TO_RACE_RESULTS,
    TO_USER_LIST,
    TO_USER_BETS,
    BLOCK_USER,
    UNLOCK_USER
}
