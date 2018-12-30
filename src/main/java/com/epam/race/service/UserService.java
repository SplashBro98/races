package com.epam.race.service;

import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.repository.impl.UserRepository;
import com.epam.race.database.specification.user.*;
import com.epam.race.entity.User;
import com.epam.race.database.specification.SQLSpecification;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class UserService {

    public Optional<User> findUser(String login, String password) throws ServiceException {
        try {
            SQLSpecification specification = new SelectUserByLoginAndPasswordSpecification(login, password);
            List<User> users = UserRepository.getInstance().query(specification);
            if (users.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(users.get(0));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public void addUser(User user) throws ServiceException {
        try {
            UserRepository.getInstance().add(user);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public User findUserByLogin(String login) throws ServiceException {
        try {
            return UserRepository.getInstance().query(new SelectUserByLoginSpecification(login)).get(0);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public void blockUser(String login) throws ServiceException {
        try{
            SQLSpecification sqlSpecification = new BlockUserSpecification(login);
            UserRepository.getInstance().update(sqlSpecification);
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public void unlockUser(String login) throws ServiceException {
        try{
            SQLSpecification sqlSpecification = new UnlockUserSpecification(login);
            UserRepository.getInstance().update(sqlSpecification);
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public List<User> findAllUsers() throws ServiceException {
        try {
            return UserRepository.getInstance().query(new SelectAllUsersSpecification());
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public BigDecimal findUserAmount(String login) throws ServiceException {
        return findUserByLogin(login).getAmount();
    }

    public void updateUserAmount(String login, BigDecimal amount) throws ServiceException {
        try {
            UserRepository.getInstance().update(new UpdateAmountSpecification(amount, login));
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public void updateUser(User user) throws ServiceException {
        try{
            SQLSpecification updateSpecification = new UpdateUserSpecification(user);
            UserRepository.getInstance().update(updateSpecification);
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

}
