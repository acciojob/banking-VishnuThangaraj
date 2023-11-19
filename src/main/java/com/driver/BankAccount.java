package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(!generateRec(digits, sum))
            throw new Exception("Account Number can not be generated");

        return null;
    }

    public boolean generateRec(int digits, int sum){
        if(digits == 0 && sum == 0) return true;
        if(digits <= 0 || sum <= 0) return false;

        boolean result = false;

        for(int num=0; num<=9; num++){
            result = generateRec(digits-1, sum-num);
            if(result) break;
        }

        return result;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance - amount < minBalance){
            throw new Exception("Insufficient Balance");
        }
        this.balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

}