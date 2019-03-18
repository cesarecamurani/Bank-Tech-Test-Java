package bank;

public class BankAccount{

    private int balance;

    BankAccount(int balance){
        this.balance = balance;
    }

    int viewBalance(){
        return this.balance;
    }

    void deposit(int amount){
        this.balance += amount;
    }

    void withdraw(int amount){
        this.balance -= amount;
    }
}