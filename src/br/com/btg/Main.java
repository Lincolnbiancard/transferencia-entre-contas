package br.com.btg;

public class Main {

    public static void main(String[] args) {
        Account a1 = new Account();
        a1.createAccount("Lincoln Biancardi", 1);
        a1.deposit(500.00);

        Account a2 = new Account();
        a2.createAccount("Btg Pactual Digital", 1);

        MoneyTransfer transfer = new MoneyTransfer();
        transfer.transfer(a2, a1, 255.55, a1.getTypeAccount());

        a2.getDataAccount();
    }
}
