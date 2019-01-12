package com.epam.race.util.validation;

public class LoginValidator {
    private static final String LOGIN_REGEX = "[a-zA-Z0-9А-Яа-я_`-]{4,40}";
    private static final String PASSWORD_REGEX = "(?=.*[0-9])(?=.*[a-z])[0-9!@#$%^&*a-zA-ZА-Яа-я]{6,50}";

    public boolean checkLogInInfo(String login, String password){
        return login.matches(LOGIN_REGEX) && password.matches(PASSWORD_REGEX);
    }

    public boolean isCorrectLogin(String login){
        return login.matches(LOGIN_REGEX);
    }

    public boolean isCorrectPassword(String password){
        return password.matches(PASSWORD_REGEX);
    }
}
