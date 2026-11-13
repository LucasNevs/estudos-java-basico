package service;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private final String nome;
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void cadastrarCliente(String nome) {
        Cliente cliente = new Cliente(nome);
        clientes.add(cliente);
    }

    public Conta abrirConta(Cliente cliente, int tipo) {
        Conta conta = (tipo == 1) ? new ContaCorrente(cliente) : new ContaPoupanca(cliente);
        contas.add(conta);
        return conta;
    }

    public Conta buscarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public List<Conta> contasDoCliente(Cliente cliente) {
        List<Conta> resultado = new ArrayList<>();
        for (Conta conta : contas) {
            if (conta.getCliente() == cliente) {
                resultado.add(conta);
            }
        }
        return resultado;
    }
}
