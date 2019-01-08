package com.epam.race.entity.common;

import com.epam.race.entity.Entity;
import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return paymentId.equals(payment.paymentId) &&
                sum.equals(payment.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, sum);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", sum=" + sum +
                '}';
    }
}
