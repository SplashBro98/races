package com.epam.race.entity.user;

import com.epam.race.entity.Entity;
import java.math.BigDecimal;
import java.util.Objects;

public class User implements Entity {
    private int userId;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;
    private UserType userType;
    private BigDecimal amount;
    private boolean isLocked;

    public User() {
        this.isLocked = false;
    }

    public User(int userId, String name, String surname, String login,
                String password, String email, UserType userType) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.email = email;
        this.userType = userType;
        this.isLocked = false;
    }

    public User(String name, String surname, String login,
                String password, String email, UserType userType, BigDecimal amount) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.email = email;
        this.userType = userType;
        this.amount = amount;
        this.isLocked = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean getIsLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) &&
                surname.equals(user.surname) &&
                login.equals(user.login) &&
                password.equals(user.password) &&
                email.equals(user.email) &&
                userType == user.userType &&
                amount.equals(user.amount);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, surname, login, password, email, userType, amount);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                ", amount=" + amount +
                '}';
    }
}
