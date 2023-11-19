package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name,balance,5000);

        if(balance < 5000) throw new Exception("Insufficient Balance");
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int[] letter = new int[26];
        boolean validID = false;
        char previous = ' ';

        for(char character : tradeLicenseId.toCharArray()){
            letter[character - 'a']++;
            if(previous == character) return; // Valid Id

            previous = character;
        }

        // Check if Possible to generate valid id
        for(int index=0; index<26; index++){
            if(letter[index] >= 2){
                validID = true;
                break;
            }
        }

        if(validID){
            tradeLicenseId = "";
            for(int index=0; index<letter.length; index++){
                for(int loop=1; loop<=letter[index]; loop++){
                    tradeLicenseId += (char)(index+'a');
                }
            }
        }else{
            throw new Exception("Valid License can not be generated");
        }
    }

}
