package com.epam.race.database.specification.payment;

public final class SqlPaymentConstant {
    //language=sql
    static final String SQL_PAYMENTS_SELECT_ALL = "SELECT * from payments";

    //language=sql
    static final String SQL_PAYMENTS_INSERT = "insert into payments" +
            " (payment_id, amount) VALUES (?,?) ";

    //language=sql
    static final String SQL_PAYMENTS_DELETE = "delete from payments where payment_id = ?";

    //language=sql
    static final String SQL_PAYMENTS_SELECT_BY_ID = "select * from payments where payment_id = ?";
}
