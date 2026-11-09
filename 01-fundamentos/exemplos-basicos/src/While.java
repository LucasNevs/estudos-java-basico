import java.util.concurrent.ThreadLocalRandom;
public class While {
    static void main(String[] args) {
        double mesada = 50.0;

        while (mesada >= 0) {
            double valorDoce = valorAleatorio();
            /*if(valorDoce > mesada) {
                valorDoce = mesada;
                */
            System.out.println("Valor doce: " + valorDoce + "adicionado no carrinho");
            mesada -= valorDoce;
        }
        System.out.println("Mesada final: " + mesada);
        System.out.println("Acabou o dinheiro");
    }

    private static double valorAleatorio() {
        return ThreadLocalRandom.current().nextDouble(1, 8);
    }
}