package service;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public String getTipo() {
        return "Conta Poupança";
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato da conta poupança ===");
        super.imprimirInfosComuns();
    }
}