package com.priceminister.account;


import static org.junit.Assert.*;

import com.sun.org.apache.bcel.internal.generic.DLOAD;
import org.junit.*;

import com.priceminister.account.implementation.*;
import org.omg.CORBA.DoubleHolder;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {

    Account customerAccount;
    AccountRule rule;

    private static final double DELTA = 0.00000001;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule();
    }

    //================== getBalance() =======================================//
    @Test
    public void getBalance_newAccountHasNotNullBalance() {
        Double result = customerAccount.getBalance();

        assertNotNull(result);
    }

    @Test
    public void getBalance_newAccountHasZeroBalance() {
        Double result = customerAccount.getBalance();

        assertEquals(0, result, DELTA);
    }
    
    //================== add() =======================================//
    @Test
    public void add_PositiveAmount() {
        double amount = 10.0;

        customerAccount.add(amount);

        assertEquals(amount, customerAccount.getBalance(), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_NegativeAmount()  {
        double amount = -10.0;

        customerAccount.add(amount);
    }

    //================== withdraw() =======================================//
    @Test
    public void withdrawAndReportBalance_normal() {
        AccountRule non_negative_balance = new CustomerAccountRule();

        customerAccount.add(20.0);

        try {
            customerAccount.withdrawAndReportBalance(10.0, non_negative_balance);
        } catch (Exception e) {
            fail();
        }

        assertEquals(customerAccount.getBalance(), 10.0, DELTA);
    }

    @Test
    public void withdrawAndReportBalance_toZero() {
        AccountRule non_negative_balance = new CustomerAccountRule();
        customerAccount.add(20.0);

        try {
            customerAccount.withdrawAndReportBalance(20.0, non_negative_balance);
        } catch (Exception ee) {
            fail();
        }

        assertEquals(customerAccount.getBalance(), 0, DELTA);
    }

    @Test (expected = IllegalArgumentException.class)
    public void withdrawAndReportBalance_negative() {
        customerAccount.add(20.0);

        try {
            customerAccount.withdrawAndReportBalance(-1.0, rule);
        } catch (IllegalBalanceException ee) {
            fail();
        }

        assertEquals(customerAccount.getBalance(), 0, DELTA);
    }

    @Test (expected = IllegalBalanceException.class)
    public void withdrawAndReportBalance_IllegalBalance() throws IllegalBalanceException {
        customerAccount.add(10.0);
        customerAccount.withdrawAndReportBalance(20.0, rule);
    }

}
