package com.epam.race.entity;

import java.math.BigDecimal;

public class UserBet extends Bet {
    private String userLogin;
    private BigDecimal sum;

    public UserBet() {
    }

    public UserBet(String userLogin, BigDecimal sum) {
        this.userLogin = userLogin;
        this.sum = sum;
    }

    public UserBet(int betId, int raceId, String describe, double coeff, String userLogin, BigDecimal sum) {
        super(betId, raceId, describe, coeff);
        this.userLogin = userLogin;
        this.sum = sum;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
