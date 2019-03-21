package bank;

import org.junit.*;
import java.util.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount account;
    private Transaction transaction;
    private Statement statement;
    private Date date;
    private ArrayList transactions = new ArrayList<>();
    private static final double DELTA = 1e-15;

    @Before
    public void setup(){

        date = new GregorianCalendar(2018, Calendar.AUGUST, 20).getTime();
        statement = new Statement();
        transaction = new Transaction(transactions, statement);
        account = new BankAccount(0, transaction);

}

    @Test
    public void balanceShouldIncreaseWhenUserDeposits(){
        account.deposit(date, 500.00);
        assertEquals(account.viewBalance(), 500.00, DELTA);
    }

    @Test
    public void balanceShouldDecreaseWhenUserWithdraws(){
        account.deposit(date, 1000.00);
        account.withdraw(date, 500.00);
        assertEquals(account.viewBalance(), 500.00, DELTA);
    }

    @Test(expected=Error.class)
    public void cannotWithdrawIfNotEnoughMoney() {
        account.deposit(date, 1000.00);
        account.withdraw(date, 1100.00);
        assertThrows(Error.class, () -> account.withdraw(date, 1100.00));
    }

    @Test
    public void printStatementShouldPrintTheStatement() {
        account.deposit(date, 1000.00);
        account.withdraw(date, 500.00);
        assertEquals(account.printStatement(), "Date || Credit || Debit || Balance\n" +
                                                     "20/08/2018 || 1000.0 || || 1000.0\n" +
                                                     "20/08/2018 || || 500.0 || 500.0\n");

    }

}
