package br.com.btg;

public class MoneyTransfer extends Account{
    private double value;

    public MoneyTransfer() {}

    public boolean transfer(Account destinyAccount, Account origemAccount, double pValue, int typeAccount) {
        double originAmount = origemAccount.getAmount();
        double destinyAmount = destinyAccount.getAmount();

        // Se não for conta corrente retorna false
        if(typeAccount != 1) {
            System.out.println("Erro ao transferir, o tipo da conta deve ser corrente para esta operação!");
            return false;
        }

        // Verifica se o valor da transferência é maior que o saldo atual
        if(!this.verifyAmount(this.getValue())) {
            System.out.println("Saldo insuficiente para está operação.");
            return false;
        }

        System.out.println("--- Transferência ---");
        System.out.println("Titular: " + origemAccount.getName());
        System.out.println("Saldo Anterior: " + originAmount);

        origemAccount.setAmount(originAmount -= pValue);
        destinyAccount.setAmount(destinyAmount += pValue);
        this.setValue(pValue);

        System.out.println("Processando transferência...");
        System.out.println("Transferência no valor de R$" + this.getValue() + " foi realizada com sucesso!");
        System.out.println("Seu saldo atual: " + origemAccount.getAmount());
        System.out.println("------------------------------------");

        return true;
    }

    private boolean verifyAmount(double transferValue) {
        return transferValue <= this.getAmount();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
