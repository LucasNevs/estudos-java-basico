package user;

import service.Banco;
import service.MenuBanco;

public class AppBancoDigital {

    public static void main(String[] args) {
        Banco banco = new Banco("Banco Master");
        MenuBanco menu = new MenuBanco(banco);
        menu.exibirMenu();
    }

}