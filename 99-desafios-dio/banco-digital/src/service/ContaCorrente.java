package service;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public String getTipo() {
        return "Conta Corrente";
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato da conta corrente ===");
        super.imprimirInfosComuns();
    }
}

