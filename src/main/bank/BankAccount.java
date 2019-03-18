package bank;

public class BankAccount{

    int balance;

    BankAccount(int balance){
        this.balance = balance;
    }

    public void deposit(int amount){
        this.balance += amount;
    }
}