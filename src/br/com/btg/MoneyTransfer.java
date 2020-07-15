package br.com.btg;

public class MoneyTransfer extends Account{
    private double value;

    public MoneyTransfer() {}

    public boolean transfer(Account destinyAccount, Account origemAccount, double pValue) {
        this.setAmount(origemAccount.getAmount());
        this.setValue(pValue);
        boolean transferred = false;

        // Verifica se o valor da transferência é maior que o saldo atual
        if(this.getValue() <= origemAccount.getAmount()) {
            System.out.println("--- Transferência ---");
            System.out.println("Titular: " + origemAccount.getName());
            System.out.println("Saldo Anterior: " + origemAccount.getAmount());

            double origemAmount = origemAccount.getAmount();
            double destinyAmount = destinyAccount.getAmount();
            origemAccount.setAmount(origemAmount -= this.getValue());
            destinyAccount.setAmount(destinyAmount += this.getValue());

            System.out.println("Processando transferência...");
            System.out.println("Transferência no valor de R$" + this.getValue() + " foi realizada com sucesso!");
            System.out.println("Seu saldo atual: " + origemAccount.getAmount());
            System.out.println("------------------------------------");
            transferred = true;
        } else {
            System.out.println("Saldo insuficiente para está operação.");
        }
        return transferred;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
