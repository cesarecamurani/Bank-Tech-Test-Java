package bank;

import org.junit.*;
import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransactionTest{

    private Transaction transaction;
    private TreeMap<String, Integer> transactions;

    @Before
    public void setup(){
        transactions = new TreeMap<>();
        transaction = new Transaction(transactions);
    }

    @Test
    public void creditShouldAddCreditToStatementEx1() {
        transaction.credit(1000, 1000);
        assertTrue(transactions.get("credit").equals(1000));
        assertTrue(transactions.get("balance").equals(1000));
    }

    @Test
    public void creditShouldAddCreditToStatementEx2() {
        transaction.credit(2000, 2000);
        assertTrue(transactions.get("credit").equals(2000));
        assertTrue(transactions.get("balance").equals(2000));
    }

    @Test
    public void debitShouldAddDebitToStatementEx1() {
        transaction.credit(1000, 1000);
        transaction.debit(800, 200);
        assertTrue(transactions.get("debit").equals(800));
        assertTrue(transactions.get("balance").equals(200));
    }
}