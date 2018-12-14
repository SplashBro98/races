package task.epam.race.entity;

import java.math.BigDecimal;

public class UserBet extends Bet {
    private String userLogin;
    private BigDecimal sum;


    public UserBet(String userLogin, BigDecimal sum) {
        this.userLogin = userLogin;
        this.sum = sum;
    }

    public UserBet(int betId, Race race, String describe, double coeff, String userLogin, BigDecimal sum) {
        super(betId, race, describe, coeff);
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
