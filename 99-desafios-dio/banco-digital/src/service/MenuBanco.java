package service;

import java.util.List;
import java.util.Scanner;

public class MenuBanco {

    private final Banco banco;
    private final Scanner input = new Scanner(System.in);

    public MenuBanco(Banco banco) {
        this.banco = banco;
    }

    // ---------- MENU PRINCIPAL ----------

    public void exibirMenu() {
        System.out.println("====== BEM-VINDO AO " + banco.getNome().toUpperCase() + " ======");
        int escolha;
        do {
            System.out.println("\n--- MENU PRINCIPAL ---\n" +
                    "1 - CADASTRAR NOVO CLIENTE\n" +
                    "2 - LISTAR CLIENTES\n" +
                    "3 - ABRIR CONTA PARA UM CLIENTE\n" +
                    "4 - ACESSAR UMA CONTA (depositar, sacar, transferir, extrato)\n" +
                    "0 - SAIR");
            escolha = lerInt("OPÇÃO SELECIONADA: ");

            switch (escolha) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 3 -> abrirConta();
                case 4 -> acessarConta();
                case 0 -> System.out.println("Obrigado por usar o " + banco.getNome() + ". Até logo!");
                default -> System.out.println("Opa! Digite uma opção válida.");
            }
        } while (escolha != 0);

        input.close();
    }

    // ---------- CLIENTES E CONTAS ----------

    private void cadastrarCliente() {
        System.out.print("Digite o nome completo do cliente: ");
        String nome = input.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("O nome não pode ficar vazio.");
            return;
        }
        banco.cadastrarCliente(nome);
        System.out.println("Cliente \"" + nome + "\" cadastrado com sucesso!");
        System.out.println("Use a opção 3 para abrir uma conta para ele.");
    }

    private void listarClientes() {
        List<Cliente> clientes = banco.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado ainda.");
            return;
        }
        System.out.println("\n--- CLIENTES DO " + banco.getNome().toUpperCase() + " ---");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            System.out.printf("%d - %s%n", i + 1, c.getNome());
            for (Conta conta : banco.contasDoCliente(c)) {
                System.out.printf("      %s | Agência %d | Conta %d | Saldo R$ %.2f%n",
                        conta.getTipo(), conta.getAgencia(), conta.getNumero(), conta.getSaldo());
            }
        }
    }

    private void abrirConta() {
        Cliente cliente = escolherCliente();
        if (cliente == null) {
            return;
        }
        int tipo = lerInt("Qual o tipo de conta? Digite 1 para Conta Corrente ou 2 para Poupança: ");
        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo inválido. Conta não criada.");
            return;
        }
        Conta conta = banco.abrirConta(cliente, tipo);
        System.out.printf("%s criada para %s! Agência %d, número %d.%n",
                conta.getTipo(), cliente.getNome(), conta.getAgencia(), conta.getNumero());
    }

    private Cliente escolherCliente() {
        List<Cliente> clientes = banco.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado. Use a opção 1 primeiro.");
            return null;
        }
        listarClientes();
        int indice = lerInt("Digite o número do cliente: ");
        if (indice < 1 || indice > clientes.size()) {
            System.out.println("Cliente inválido.");
            return null;
        }
        return clientes.get(indice - 1);
    }

    // ---------- OPERAÇÕES NA CONTA ----------

    private void acessarConta() {
        if (banco.getContas().isEmpty()) {
            System.out.println("Nenhuma conta aberta ainda. Use a opção 3 primeiro.");
            return;
        }
        int numero = lerInt("Digite o número da conta: ");
        Conta conta = banco.buscarConta(numero);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
        menuConta(conta);
    }

    private void menuConta(Conta conta) {
        int escolha;
        do {
            System.out.println("\nOlá, " + conta.getCliente().getNome() + " (" + conta.getTipo() +
                    " nº " + conta.getNumero() + "), vamos às suas opções:\n" +
                    "1 - DEPOSITAR\n" +
                    "2 - SACAR\n" +
                    "3 - TRANSFERIR\n" +
                    "4 - EXIBIR EXTRATO\n" +
                    "0 - VOLTAR AO MENU PRINCIPAL");
            escolha = lerInt("OPÇÃO SELECIONADA: ");

            try {
                switch (escolha) {
                    case 1 -> {
                        conta.depositar(lerDouble("Quanto deseja depositar? R$ "));
                        System.out.println("Depósito realizado com sucesso!");
                    }
                    case 2 -> {
                        conta.sacar(lerDouble("Quanto deseja sacar? R$ "));
                        System.out.println("Saque realizado com sucesso!");
                    }
                    case 3 -> transferir(conta);
                    case 4 -> conta.imprimirExtrato();
                    case 0 -> System.out.println("Voltando ao menu principal...");
                    default -> System.out.println("Opa! Digite uma opção válida.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Operação não realizada: " + e.getMessage());
            }
        } while (escolha != 0);
    }

    private void transferir(Conta origem) {
        int numeroDestino = lerInt("Número da conta de destino: ");
        Conta destino = banco.buscarConta(numeroDestino);
        if (destino == null) {
            System.out.println("Conta de destino não encontrada.");
            return;
        }
        if (destino == origem) {
            System.out.println("A conta de destino precisa ser diferente da conta de origem.");
            return;
        }
        double valor = lerDouble("Quanto deseja transferir? R$ ");
        origem.transferir(valor, destino);
        System.out.printf("Transferência de R$ %.2f para %s (conta %d) realizada com sucesso!%n",
                valor, destino.getCliente().getNome(), destino.getNumero());
    }

    // ---------- LEITURA SEGURA DO TECLADO ----------

    private int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String linha = input.nextLine().trim();
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Opa! Digite um número inteiro válido.");
            }
        }
    }

    private double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String linha = input.nextLine().trim().replace(",", ".");
            try {
                return Double.parseDouble(linha);
            } catch (NumberFormatException e) {
                System.out.println("Opa! Digite um valor válido (ex.: 150.50).");
            }
        }
    }
}
