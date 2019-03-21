package bank;

import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class StatementTest{

    private ArrayList transactions;
    private Date date;
    private Transaction transaction;
    private Statement statement;

    @Before
    public void setup(){

        transactions = new ArrayList<>();
        transaction = new Transaction(transactions, statement);
        statement = new Statement();
        date = new GregorianCalendar(2018, Calendar.AUGUST, 20).getTime();
    }

    @Test
    public void printShouldPrintTheStatementInTheDesiredFormat(){
        transaction.credit(date, 1000.0, 1000.0);
        transaction.debit(date, 500.0, 500.0);
        assertEquals(statement.display(transactions), "Date || Credit || Debit || Balance\n" +
                                                            "20/08/2018 || 1000.0 || || 1000.0\n" +
                                                            "20/08/2018 || || 500.0 || 500.0\n");
    }
}