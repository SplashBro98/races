package com.epam.race.util.validation;

import com.epam.race.service.ServiceException;
import com.epam.race.entity.user.User;
import com.epam.race.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class SignUpValidator {
    private static final String LOGIN_REGEX = "[a-zA-Z0-9А-Яа-я_`-]{4,30}";
    private static final String NAME_REGEX = "[A-Za-zА-Яа-я -]{1,30}";
    private static final String SURNAME_REGEX = "[A-Za-zА-Яа-я -]{1,30}";
    private static final String PASSWORD_REGEX = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9!@#$%^&*a-zA-ZА-Яа-я]{6,50}";


    public boolean checkLoginIsCorrect(String login) {
        return login.matches(LOGIN_REGEX);
    }

    public boolean checkLoginIsPresent(String login) throws ServiceException {

        List<User> users = new UserService().findAllUsers();
        List<String> loginList = new ArrayList<>();
        users.forEach(u -> loginList.add(u.getLogin()));
        return loginList.contains(login);
    }

    public boolean checkPassword(String password) {
        return password.matches(PASSWORD_REGEX);
    }

    public boolean checkEmail(String email) throws ServiceException {
        return true;
    }

    public boolean checkPasswordMatch(String password, String confirmedPassword){
        return password.equals(confirmedPassword);
    }

    public boolean checkName(String name){
        return name.matches(NAME_REGEX);
    }

    public boolean checkSurname(String surname){
        return surname.matches(SURNAME_REGEX);
    }
}
