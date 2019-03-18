package bank;

import java.util.*;
import java.time.ZonedDateTime;

public class Transaction{

    private Hashtable transactions;

    Transaction(Hashtable transactions){
        this.transactions = transactions;
    }

    void credit(Integer amount, Integer balance){
        this.transactions.put("date", ZonedDateTime.now());
        this.transactions.put("credit", amount);
        this.transactions.put("debit", 0);
        this.transactions.put("balance", balance);
    }
}