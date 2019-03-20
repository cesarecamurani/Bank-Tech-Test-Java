package bank;

import org.junit.*;
import org.mockito.Mockito;

import java.util.*;
import static org.junit.Assert.*;

public class StatementTest{

    private List<Map<String, String>> transactions;
    private Date date;
    private Transaction transaction;
    private Statement statement;

    @Before
    public void setup(){
        transactions = new ArrayList<>();
        transaction = new Transaction(transactions, date);
        statement = new Statement();
    }

    @Test
    public void printShouldPrintTheStatementInTheDesiredFormat(){
        statement.print(transactions);
        assertEquals(statement.display(), "Date || Credit || Debit || Balance\n" +
                                                 "20/08/2018 || 1000 || 0 || 1000\n" +
                                                 "20/08/2018 || 0 || 500 || 500");
    }
}