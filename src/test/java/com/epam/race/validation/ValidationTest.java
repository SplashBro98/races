package com.epam.race.validation;


import com.epam.race.util.validation.BetValidator;
import com.epam.race.util.validation.LoginValidator;
import com.epam.race.util.validation.PaymentValidator;
import com.epam.race.util.validation.RaceValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidationTest {

    private LoginValidator loginValidator;
    private PaymentValidator paymentValidator;
    private BetValidator betValidator;
    private RaceValidator raceValidator;

    @BeforeClass
    public void setUp() {
        loginValidator = new LoginValidator();
        paymentValidator = new PaymentValidator();
        betValidator = new BetValidator();
        raceValidator = new RaceValidator();
    }


    @DataProvider(name = "login")
    public Object[][] dataForCheckLogin() {
        return new Object[][]{
                {"Ivan_Oneil", true},
                {"Иван`Мозолюк", true},
                {"dr kd", false},
                {"f", false},
                {"Ivan__Oneiiiidasdasd", true},
                {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", true},
                {"Кракозябра", true},
        };
    }


    @Test(dataProvider = "login")
    public void checkLoginTest(String login, boolean expected) {
        boolean actual = loginValidator.isCorrectLogin(login);

        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "password")
    public Object[][] dataForCheckPassword() {
        return new Object[][]{
                {"Va12341251235", true},
                {"stephgonnasteph", false},
                {"2Admin", true},
                {"96emudes", false},
                {"Qwerty007", true},

        };
    }

    @Test(dataProvider = "password")
    public void checkPasswordTest(String password, boolean expected) {

        boolean actual = loginValidator.isCorrectPassword(password);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "date")
    public Object[][] dataForCheckDate() {
        return new Object[][]{
                {"1963-04-21", true},
                {"19000-13-21", false},
                {"1963-00-21", false},
        };
    }

    @Test(dataProvider = "date")
    public void checkDateTest(String date, boolean expected) {

        boolean actual = raceValidator.checkDate(date);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void checkPaymentIdTest() {

        boolean actual = paymentValidator.isCorrectPaymentId("22-655-001");

        Assert.assertTrue(actual);

    }

    @Test
    public void checkSumTest() {

        String sum = "1.62";
        boolean actual = paymentValidator.isCorrectSum(sum);
        Assert.assertTrue(actual);
    }


}
