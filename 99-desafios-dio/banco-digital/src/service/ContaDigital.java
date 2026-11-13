package service;

public interface ContaDigital {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, ContaDigital destino);

    void imprimirExtrato();

}
