package bank;

import org.junit.*;
import java.util.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FeatureTest {

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
    public void featureTestForDepositFunctionality(){
        account.deposit(date, 2000.00);
        account.deposit(date, 1500.00);
        account.deposit(date, 3000.00);
        assertEquals("20/08/2018 || 3000.0 || || 6500.0\n", transaction.returnTransactions().get(0));
    }

    @Test
    public void featureTestForWithdrawFunctionality(){
        account.deposit(date, 2000.00);
        account.deposit(date, 1500.00);
        account.deposit(date, 3000.00);
        account.withdraw(date, 2000.00);
        account.withdraw(date, 500.00);
        account.withdraw(date, 3000.00);
        assertEquals("20/08/2018 || || 3000.0 || 1000.0\n", transaction.returnTransactions().get(0));
    }

    @Test
    public void featureTestForPrintStatementFunctionality(){

    }
}