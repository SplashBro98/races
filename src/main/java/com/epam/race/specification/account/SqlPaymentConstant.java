package com.epam.race.specification.account;

public final class SqlPaymentConstant {
    //language=sql
    public static final String SQL_PAYMENTS_SELECT_ALL = "SELECT * from payments";

    //language=sql
    public static final String SQL_PAYMENTS_INSERT = "insert into payments (amount) VALUES" +
            "(?) ";
}
