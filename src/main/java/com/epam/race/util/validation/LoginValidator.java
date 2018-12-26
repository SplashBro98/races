package com.epam.race.util.validation;

public class LoginValidator {
    private static final String LOGIN_REGEX = "[a-zA-Z0-9А-Яа-я_`-]{4,30}";
    private static final String PASSWORD_REGEX = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9!@#$%^&*a-zA-ZА-Яа-я]{6,50}";

    public boolean checkLogInInfo(String login, String password){
        return login.matches(LOGIN_REGEX) && password.matches(PASSWORD_REGEX);
    }
}
