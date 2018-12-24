package com.epam.race.service;

import com.epam.race.exception.RepositoryException;
import com.epam.race.exception.ServiceException;
import com.epam.race.repository.UserRepository;
import com.epam.race.specification.user.SelectAllUsersSpecification;
import com.epam.race.util.validation.SignUpValidator;
import com.epam.race.entity.User;
import com.epam.race.specification.SQLSpecification;
import com.epam.race.specification.user.SelectUserByLoginAndPasswordSpecification;
import com.epam.race.specification.user.SelectUserByLoginSpecification;

import java.util.List;
import java.util.Optional;

public class UserService {

    public Optional<User> findUser(String login, String password) throws ServiceException {

        //TODO когда и где помещать в req все аттрибуты, которые нужны для страницы
        try {
            SQLSpecification specification = new SelectUserByLoginAndPasswordSpecification(login, password);
            List<User> users = UserRepository.getInstance().query(specification);
            if (users.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(users.get(0));
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public boolean addUser(User user) throws ServiceException {
        try {
            SignUpValidator validator = new SignUpValidator();
            boolean result = false;
            if (validator.checkLoginIsPresent(user.getLogin())) {
                UserRepository.getInstance().add(user);
                result = true;
            }
            return result;
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public User findUserByLogin(String login) throws ServiceException {
        try {
            return UserRepository.getInstance().query(new SelectUserByLoginSpecification(login)).get(0);
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public List<User> findAllUsers() throws ServiceException {
        try{
            return UserRepository.getInstance().query(new SelectAllUsersSpecification());
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

}
