package bank;

import org.junit.*;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount account;
    private Transaction transaction;
    private Date date;
    private DateTime dt;
    private List<Map<String, String>> transactions = new ArrayList<>();

    @Before
    public void setup(){
        transaction = new Transaction(transactions, dt);
        account = new BankAccount(0, transaction);
    }

    @Test
    public void balanceShouldIncreaseWhenUserDeposits(){
        account.deposit(500);
        assertEquals(account.viewBalance(), 500);
    }

    @Test
    public void balanceShouldDecreaseWhenUserWithdraws(){
        account.deposit(1000);
        account.withdraw(500);
        assertEquals(account.viewBalance(), 500);
    }

    @Test(expected=Error.class)
    public void cannotWithdrawIfNotEnoughMoney() {
        account.deposit(1000);
        account.withdraw(1100);
        assertThrows(Error.class, () -> account.withdraw(1100));
    }

}
