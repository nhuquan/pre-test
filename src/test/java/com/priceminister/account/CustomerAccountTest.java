package com.priceminister.account;


import static org.junit.Assert.*;

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
    }
    
    @Test
    public void newAccountHasNotNullBalance() {
        Double result = customerAccount.getBalance();

        assertNotNull(result);
    }

    @Test
    public void newAccountHasZeroBalance() {
        Double result = customerAccount.getBalance();

        assertEquals(0, result, DELTA);
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
        double amount = 10.0;

        customerAccount.add(amount);

        assertEquals(amount, customerAccount.getBalance(), DELTA);
    }

    @Test
    public void testAddNegativeAmount() {
        double amount = -10.0;

        Double before = customerAccount.getBalance();
        customerAccount.add(amount);
        Double after = customerAccount.getBalance();

        assertEquals(before, after, DELTA);
    }
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() {
        fail("not yet implemented");
    }
    
    // Also implement missing unit tests for the above functionalities.

}
