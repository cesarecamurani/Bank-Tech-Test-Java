package bank;

import java.util.*;
import java.text.SimpleDateFormat;

class Transaction {

    ArrayList transactions;
    Statement statement;
    SimpleDateFormat dateFormatter;
    String dateNow;

    Transaction(ArrayList transactions, Statement statement){
        this.transactions = transactions;
        this.statement = statement;
    }

    ArrayList returnTransactions() {
        return this.transactions;
    }

    void credit(Date date, double amount, double balance){
        formatDate(date);
        this.transactions.add(dateNow + " || " +
                              amount + " || || " +
                              balance + "\n");

    }

    void debit(Date date, double amount, double balance){
        formatDate(date);
        this.transactions.add(dateNow + " || || " +
                              amount + " || " +
                              balance + "\n");
    }

    private String formatDate(Date date){
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        dateNow = dateFormatter.format(date);
        return dateNow;
    }

    String displayStatement(){
        return this.statement.display(this.transactions);
    }
}