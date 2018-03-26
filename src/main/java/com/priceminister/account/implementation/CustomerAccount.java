package com.priceminister.account.implementation;

import com.priceminister.account.*;

public class CustomerAccount implements Account {

    private double balance = 0.0;

    public Double getBalance() {
        return this.balance;
    }

    public void add(Double addedAmount) {
        verify_param(addedAmount);

        balance = balance + addedAmount;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule)
    		throws IllegalBalanceException {

        verify_param(withdrawnAmount);

        double future_balance = balance - withdrawnAmount;
        if (!rule.withdrawPermitted(future_balance))
            throw new IllegalBalanceException(future_balance);

        balance = balance - withdrawnAmount;

        return balance;
    }

    private void verify_param(Double param) {
        if (param < 0) {
            throw new IllegalArgumentException("Method accept only positive value as parameter!");
        }
    }
}
