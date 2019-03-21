package bank;

import org.junit.*;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount account;
    private Transaction transaction;
    private Statement statement;
    private String testDate;
    private ArrayList transactions = new ArrayList<>();
    private static final double DELTA = 1e-15;

    @Before
    public void setup(){

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        testDate = dateFormatter.format(new Date());
        statement = new Statement();
        transaction = new Transaction(transactions, statement);
        account = new BankAccount(0, transaction);

}

    @Test
    public void balanceShouldIncreaseWhenUserDeposits(){
        account.deposit(500.00);
        assertEquals(account.viewBalance(), 500.00, DELTA);
    }

    @Test
    public void balanceShouldDecreaseWhenUserWithdraws(){
        account.deposit(1000.00);
        account.withdraw(500.00);
        assertEquals(account.viewBalance(), 500.00, DELTA);
    }

    @Test(expected=Error.class)
    public void cannotWithdrawIfNotEnoughMoney() {
        account.deposit(1000.00);
        account.withdraw(1100.00);
        assertThrows(Error.class, () -> account.withdraw(1100.00));
    }
    @Test(expected=Error.class)
    public void cannotWithdrawIflimitHasBeenReached() {
        account.deposit(2000.00);
        account.withdraw(700.00);
        account.withdraw(500.00);
        assertThrows(Error.class, () -> account.withdraw(500.00));
    }

    @Test
    public void printStatementShouldPrintTheStatement() {
        account.deposit(1000.00);
        account.withdraw(500.00);
        assertEquals(account.printStatement(), "Date || Credit || Debit || Balance\n" +
                                                     testDate + " || 1000.0 || || 1000.0\n" +
                                                     testDate + " || || 500.0 || 500.0\n");

    }

}
