package bank;

import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class TransactionTest{

    private Transaction transaction;
    private Date date;

    @Before
    public void setup(){
        Statement statement = new Statement();
        ArrayList transactions = new ArrayList<>();
        date = new GregorianCalendar(2018, Calendar.AUGUST, 20).getTime();
        transaction = new Transaction(transactions, statement);
    }

    @Test
    public void creditShouldAddCreditToStatementEx1() {
        transaction.credit(date, 1000.0, 1000.0);
        assertEquals("20/08/2018 || 1000.0 || || 1000.0\n", transaction.returnTransactions().get(0));
    }

    @Test
    public void creditShouldAddCreditToStatementEx2() {
        transaction.credit(date, 2000.0, 2000.0);
        assertEquals("20/08/2018 || 2000.0 || || 2000.0\n", transaction.returnTransactions().get(0));
    }

    @Test
    public void debitShouldAddDebitToStatementEx1() {
        transaction.credit(date, 1000.0, 1000.0);
        transaction.debit(date, 500.0, 500.0);
        assertEquals("20/08/2018 || || 500.0 || 500.0\n", transaction.returnTransactions().get(0));
    }

    @Test
    public void debitShouldAddDebitToStatementEx2() {
        transaction.credit(date, 2000.0, 2000.0);
        transaction.debit(date, 1500.0, 500.0);
        assertEquals("20/08/2018 || || 1500.0 || 500.0\n", transaction.returnTransactions().get(0));
    }

    @Test
    public void displayStatementShouldDisplayTheStatement() {
        transaction.credit(date, 1000.0, 1000.0);
        transaction.debit(date, 500.0, 500.0);
        assertEquals(transaction.displayStatement(), "Date || Credit || Debit || Balance\n" +
                                                           "20/08/2018 || 1000.0 || || 1000.0\n" +
                                                           "20/08/2018 || || 500.0 || 500.0\n");

    }
}


