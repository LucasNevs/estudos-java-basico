package modelo;

import servicos.AparelhoTelefonico;
import servicos.NavegadorInternet;
import servicos.ReprodutorMusical;

public class SistemaIos implements NavegadorInternet, ReprodutorMusical, AparelhoTelefonico {

    @Override
    public void ligar(String numeroTelefone) {
        System.out.println("Ligando para o número " +  numeroTelefone);

    }

    @Override
    public void desligar() {
        System.out.println("Encerrando a ligação...");

    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando o Correio voz...");

    }

    @Override
    public void exibirPagina() {
        System.out.println("Exibindo o pagina...");

    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba...");

    }

    @Override
    public void atualizarPagina() {
        System.out.println("Atualizando o página...pressione F5");

    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("Selecionando música " +  musica);

    }

    @Override
    public void tocarMusica() {
        System.out.println("Tocando música selecionada...");

    }

    @Override
    public void pausarMusica() {
        System.out.println("Música pausada");

    }


}
