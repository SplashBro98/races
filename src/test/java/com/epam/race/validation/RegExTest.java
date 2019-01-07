package com.epam.race.validation;


import com.epam.race.util.validation.PaymentValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegExTest {


    @DataProvider(name = "login")
    public Object[][] dataForCheckLogin(){
        return new Object[][]{
                {"Ivan_Oneil",true},
                {"Иван`Мозолюк",true},
                {"dr kd",false},
                {"f",false},
                {"Ivan__Oneiiiidasdasd",true},
                {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",false},
                {"Кракозябра",true},
        };
    }


    @Test(dataProvider = "login")
    public void checkLoginTest(String login, boolean expected){
        String regex = "[a-zA-Z0-9А-Яа-я_`]{4,30}";
        boolean actual = login.matches(regex);

        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "password")
    public Object[][] dataForCheckPassword(){
        return new Object[][]{
                {"Va02908902",true},
                {"stephgonnasteph",false},
                {"2Admin",true},
                {"96emudes",false},
                {"Qwerty007",true},

        };
    }

    @Test(dataProvider = "password")
    public void checkPasswordTest(String password, boolean expected){
        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9!@#$%^&*a-zA-ZА-Яа-я]{6,}";

        boolean actual = password.matches(regex);

        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "date")
    public Object[][] dataForCheckDate(){
        return new Object[][]{
                {"1963-04-21",true},

        };
    }

    @Test(dataProvider = "date")
    public void checkDateTest(String password, boolean expected){

        String regex = "\\d\\d\\d\\d-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])";
        boolean actual = password.matches(regex);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void checkPaymentIdTest(){
        String regex = "^\\d\\d-\\d\\d\\d-\\d\\d\\d$";

        PaymentValidator validator = new PaymentValidator();
        boolean actual = validator.isCorrectPaymentId("22-655-001");

        Assert.assertTrue(actual);

    }

    @Test
    public void checkSumTest(){
        String regex = "^[0-9]*([.,][0-9]{2})?$";


       String sum = "1.62";

        Assert.assertTrue(sum.matches(regex));

    }


}
