package br.com.btg;

public class Account implements IAccountRepository{
    private int origemAccountId;
    private String name;
    private double amount;
    private int typeAccount;
    static int accounts = 0;

    public Account() {}

    @Override
    public void createAccount(String pName, int typeAccount) {
        this.setName(pName);
        accounts++;
        this.setOrigemAccountId(accounts); ;
        this.setAmount(0.0);
        this.setTypeAccount(typeAccount);
    }

    public void getDataAccount() {
        System.out.println("--- Dados Bancários ---");
        System.out.println("Número: " + this.getOrigemAccountId());
        System.out.println("Titular: " + this.getName());
        System.out.println("Saldo: " + this.getAmount());
        System.out.println("----------------------");
        System.out.println("");
    }

    public void deposit(Double pValue) {
        System.out.println("--- Depósito ---");
        System.out.println("Saldo Anterior: " + this.getAmount());
        this.setAmount(this.amount += pValue);
        System.out.println("Processando depósito...");
        System.out.println("Depósito no valor de R$" + pValue + " foi realizado com sucesso!");
        System.out.println("Seu saldo atual: " + this.getAmount());
        System.out.println("-------------------------------------");
    }

    public String getTypeAccount(int number) {
        String typeAccount;
        if(number == 1) {
            typeAccount = "corrente";
        } else {
            typeAccount = "poupança";
        }

        return typeAccount;
    }

    public void withdraw(Double pValue) {
        System.out.println("--- Saque ---");
        System.out.println("Saldo Atual: " + this.getAmount());

        if(pValue <= this.getAmount()) {
            this.amount -= pValue;
            System.out.println("Processando saque, aguarde por favor...");
            System.out.println("Saque no valor de R$" + pValue + " foi realizado com sucesso!");
            System.out.println("Seu saldo atual: " + this.getAmount());
        } else {
            System.out.println("Saldo insuficiente para está operação, por favor tente novamente, " +
                    "ou entre em contado com um de nossos atendentes.");
        }
    }

    public int getOrigemAccountId() {
        return origemAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public int getTypeAccount() {
        return typeAccount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrigemAccountId(int origemAccountId) {
        this.origemAccountId = origemAccountId;
    }

    public void setTypeAccount(int typeAccount) {
        this.typeAccount = typeAccount;
    }
}
