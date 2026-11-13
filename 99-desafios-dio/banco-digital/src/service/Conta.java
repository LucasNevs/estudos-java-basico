package service;

public abstract class Conta implements ContaDigital {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        validarValor(valor);
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente. Saldo atual: R$ " + String.format("%.2f", saldo));
        }
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        validarValor(valor);
        saldo += valor;
    }

    @Override
    public void transferir(double valor, ContaDigital contaDestino) {
        // sacar já valida o valor e o saldo; se falhar, o depósito não acontece
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    private void validarValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public abstract String getTipo();

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: R$ %.2f%n", this.saldo);
    }
}