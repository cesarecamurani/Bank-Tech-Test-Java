package bank;

import java.util.*;
import java.time.*;
import java.time.format.*;

class Transaction{

    private TreeMap transactions;
    private ZonedDateTime rawDate = ZonedDateTime.now();
    private String date = DateTimeFormatter.ofPattern("dd/MM/YYYY").format(rawDate);

    Transaction(TreeMap transactions){
        this.transactions = transactions;
    }

    void credit(Integer amount, Integer balance){
        this.transactions.put("date", date);
        this.transactions.put("credit", amount.toString());
        this.transactions.put("debit", "0");
        this.transactions.put("balance", balance.toString());
    }

    void debit(Integer amount, Integer balance){
        this.transactions.put("date", date);
        this.transactions.put("credit", "0");
        this.transactions.put("debit", amount.toString());
        this.transactions.put("balance", balance.toString());
    }
}