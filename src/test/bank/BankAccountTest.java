package bank;

import org.junit.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setup(){
        account = new BankAccount(0);
    }

    @Test
    public void balanceShouldIncreaseWhenUserDeposits(){
       account.deposit(500);
       assertEquals(account.balance, 500);
    }

    @Test
    public void balanceShouldDecreaseWhenUserWithdraws(){
        account.deposit(1000);
        account.withdraw(500);
        assertEquals(account.balance, 500);
    }

}