package com.epam.race.entity.user;

import com.epam.race.entity.common.Bet;

import java.math.BigDecimal;
import java.util.Objects;

public class UserBet extends Bet {
    private String userLogin;
    private BigDecimal sum;
    private boolean isSuccessful;

    public UserBet() {
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

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserBet userBet = (UserBet) o;
        return isSuccessful == userBet.isSuccessful &&
                userLogin.equals(userBet.userLogin) &&
                sum.equals(userBet.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userLogin, sum, isSuccessful);
    }

    @Override
    public String toString() {
        return "UserBet{" +
                "userLogin='" + userLogin + '\'' +
                ", sum=" + sum +
                ", isSuccessful=" + isSuccessful +
                '}';
    }
}
