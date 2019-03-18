package bank;

import org.junit.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransactionTest{

    private Instant rawDate = Instant.now(Clock.fixed(
            Instant.parse("2018-08-22T10:00:00Z"),
            ZoneOffset.UTC));

    private DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/YYYY")
                    .withLocale( Locale.UK )
                    .withZone( ZoneId.systemDefault());

    private String fixedDate = formatter.format(rawDate);


    private Transaction transaction;
    private TreeMap<String, String> transactions;

    @Before
    public void setup(){
        transactions = new TreeMap<>();
        transaction = new Transaction(transactions);
    }

    @Test
    public void creditShouldAddCreditToStatementEx1() {
        transaction.credit(1000, 1000);
        System.out.println(fixedDate);
        System.out.println(transactions.get("date"));
        assertTrue(transactions.get("date").equals(fixedDate));
        assertTrue(transactions.get("credit").equals("1000"));
        assertTrue(transactions.get("balance").equals("1000"));
    }

    @Test
    public void creditShouldAddCreditToStatementEx2() {
        transaction.credit(2000, 2000);
        assertTrue(transactions.get("credit").equals("2000"));
        assertTrue(transactions.get("balance").equals("2000"));
    }

    @Test
    public void debitShouldAddDebitToStatementEx1() {
        transaction.credit(1000, 1000);
        transaction.debit(800, 200);
        assertTrue(transactions.get("debit").equals("800"));
        assertTrue(transactions.get("balance").equals("200"));
    }

    @Test
    public void debitShouldAddDebitToStatementEx2() {
        transaction.credit(2000, 2000);
        transaction.debit(1500, 500);
        assertTrue(transactions.get("debit").equals("1500"));
        assertTrue(transactions.get("balance").equals("500"));
    }
}