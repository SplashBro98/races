package com.epam.race.entity.common;

import com.epam.race.entity.Entity;

import java.math.BigDecimal;

public class Payment implements Entity {
    private String paymentId;
    private BigDecimal sum;

    public Payment() {
    }

    public Payment(BigDecimal sum) {
        this.sum = sum;
    }

    public Payment(String paymentId, BigDecimal sum) {
        this.paymentId = paymentId;
        this.sum = sum;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
