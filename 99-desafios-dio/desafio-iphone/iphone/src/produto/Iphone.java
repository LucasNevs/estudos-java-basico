package produto;

import modelo.SistemaIos;

public class Iphone extends SistemaIos {
    static void main() {
        Iphone iPhone = new Iphone();

        iPhone.ligar("8855545522");
        iPhone.desligar();
        iPhone.iniciarCorreioVoz();
        iPhone.selecionarMusica("And Justice for all - Metallica");
        iPhone.tocarMusica();
    }
}
