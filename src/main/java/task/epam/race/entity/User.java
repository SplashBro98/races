package task.epam.race.entity;

import java.math.BigDecimal;

public class User {
    private long userId;
    private String login;
    private String password;
    private BigDecimal account;

    public User(long userId, String login, String password, BigDecimal account) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.account = account;
    }
}
