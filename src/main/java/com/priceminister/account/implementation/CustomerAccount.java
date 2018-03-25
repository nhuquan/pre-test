package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

    private double balance = 0.0;

    public void add(Double addedAmount) {
        // TODO Auto-generated method stub
    }

    public Double getBalance() {
        // TODO Auto-generated method stub
        return this.balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {
        // TODO Auto-generated method stub
        return null;
    }

}
