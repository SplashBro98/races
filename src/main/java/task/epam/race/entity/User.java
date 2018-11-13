package task.epam.race.entity;

import java.math.BigDecimal;

public class User implements Entity{
    private long userId;
    private String name;
    private String surname;
    private String login;
    private String password;
    private int userType;
    private BigDecimal account;

    public User(long userId, String name, String surname, String login, String password, BigDecimal account) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.account = account;
    }

    public User(long userId, String name, String surname, String login, String password, int userType, BigDecimal account) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.userType = userType;
        this.account = account;
    }

    public User(long userId, String name, String surname, String login, String password) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public User(String name, String surname, String login, String password, int userType, BigDecimal account) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.userType = userType;
        this.account = account;
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

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public long getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
