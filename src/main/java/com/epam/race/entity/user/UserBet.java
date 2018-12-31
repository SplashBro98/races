package com.epam.race.entity.user;

import com.epam.race.entity.common.Bet;
import com.epam.race.entity.common.Horse;
import com.epam.race.entity.common.Race;

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

    public UserBet(int betId, Race race, Horse horse, double coeff, String userLogin, BigDecimal sum) {
        super(betId, race, horse, coeff);
        this.userLogin = userLogin;
        this.sum = sum;
    }

    public UserBet(int betId, String userLogin, BigDecimal sum, double coeff){
        this.setBetId(betId);
        this.userLogin = userLogin;
        this.sum = sum;
        this.setCoeff(coeff);
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
