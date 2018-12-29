package com.epam.race.entity;

import java.math.BigDecimal;

public class Payment implements Entity {
    private int paymentId;
    private BigDecimal sum;

    public Payment() {
    }

    public Payment(BigDecimal sum) {
        this.sum = sum;
    }

    public Payment(int paymentId, BigDecimal sum) {
        this.paymentId = paymentId;
        this.sum = sum;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
