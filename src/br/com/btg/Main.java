package br.com.btg;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Account a1 = new Account();
        a1.createAccount("Lincoln Biancardi");
        a1.deposit(500.00);

        Account a2 = new Account();
        a2.createAccount("Maria do Carmo");

        MoneyTransfer transfer = new MoneyTransfer();
        transfer.transfer(a2, a1, 255.55);

        a2.getDataAccount();
    }
}
