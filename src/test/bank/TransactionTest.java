package bank;

import org.junit.*;
import org.mockito.Mockito;

import java.util.*;
import static org.junit.Assert.*;
import org.hamcrest.collection.IsMapContaining;

public class TransactionTest{

    private Transaction transaction;
    private String header;
//    private Statement statement;
    private List<Map<String, String>> transactions;
    private Date date;

    @Before
    public void setup(){

        date = Mockito.mock(Date.class);
        Mockito.when(date.toString())
                .thenReturn("20/08/2018");

        transactions = new ArrayList<>();
        transaction = new Transaction(transactions, date);
    }

    @Test
    public void creditShouldAddCreditToStatementEx1() {
        transaction.credit(1000, 1000);
        assertThat(transactions.get(0), IsMapContaining.hasEntry("date", "20/08/2018"));
        assertThat(transactions.get(0), IsMapContaining.hasEntry("credit", "1000"));
        assertThat(transactions.get(0), IsMapContaining.hasEntry("debit", "0"));
        assertThat(transactions.get(0), IsMapContaining.hasEntry("balance", "1000"));
    }

    @Test
    public void creditShouldAddCreditToStatementEx2() {
        transaction.credit(2000, 2000);
        assertThat(transactions.get(0), IsMapContaining.hasEntry("date", "20/08/2018"));
        assertThat(transactions.get(0), IsMapContaining.hasEntry("credit", "2000"));
        assertThat(transactions.get(0), IsMapContaining.hasEntry("debit", "0"));
        assertThat(transactions.get(0), IsMapContaining.hasEntry("balance", "2000"));
    }

    @Test
    public void debitShouldAddDebitToStatementEx1() {
        transaction.credit(1000, 1000);
        transaction.debit(800, 200);
        assertThat(transactions.get(0), IsMapContaining.hasEntry("date", "20/08/2018"));
        assertThat(transactions.get(0), IsMapContaining.hasEntry("credit", "0"));
        assertThat(transactions.get(0), IsMapContaining.hasEntry("debit", "800"));
        assertThat(transactions.get(0), IsMapContaining.hasEntry("balance", "200"));
    }

    @Test
    public void debitShouldAddDebitToStatementEx2() {
        transaction.credit(2000, 2000);
        transaction.debit(1500, 500);
        assertThat(transactions.get(0), IsMapContaining.hasEntry("date", "20/08/2018"));
        assertThat(transactions.get(0), IsMapContaining.hasEntry("credit", "0"));
        assertThat(transactions.get(0), IsMapContaining.hasEntry("debit", "1500"));
        assertThat(transactions.get(0), IsMapContaining.hasEntry("balance", "500"));
    }
}


