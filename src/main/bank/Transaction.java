package bank;

import java.util.*;

class Transaction {

    Date date;

    Map<String,String> transactionCre = new HashMap<>();
    Map<String,String> transactionDeb = new HashMap<>();
    List<Map<String , String>> transactions;

    Transaction(List<Map<String , String>> transactions, Date date){
        this.transactions = transactions;
        this.date = date;
    }

    void credit(int amount, int balance){
        this.transactionCre.put("date", String.valueOf(this.date));
        this.transactionCre.put("credit", String.valueOf(amount));
        this.transactionCre.put("debit", "0");
        this.transactionCre.put("balance", String.valueOf(balance));
        this.transactions.add(0, transactionCre);

    }

    void debit(int amount, int balance){
        this.transactionDeb.put("date", String.valueOf(this.date));
        this.transactionDeb.put("credit", "0");
        this.transactionDeb.put("debit", String.valueOf(amount));
        this.transactionDeb.put("balance", String.valueOf(balance));
        this.transactions.add(0, transactionDeb);
    }
}