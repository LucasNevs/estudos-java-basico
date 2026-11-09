package lanchonete;

import lanchonete.area.cliente.Cliente;
import lanchonete.atendimento.Atendente;
import lanchonete.atendimento.cozinha.Cozinheiro;

public class Estabelecimento {
    static void main(String[] args) {

        //ações que não precisam estar disponives para toda a aplicação
        Cozinheiro cozinheiro = new Cozinheiro();
        cozinheiro.prepararVitamina();
        cozinheiro.prepararVitamina();

        //ações que o estabelecimento precisa ter ciencia
        cozinheiro.adicionarSucoNoBalcao();
        cozinheiro.adicionarLancheNoBalcao();
        cozinheiro.adicionarComboNoBalcao();

        Atendente atendente = new Atendente();
        atendente.receberPagamento();
        atendente.servindoMesas();

        Cliente cliente = new Cliente();
        cliente.escolherLanche();
        cliente.fazerPedido();
        cliente.pagarConta();

    }
}
