public class CaixaEletronico {
    static void main(String[] args) {
        double saldo = 25;
        double valorSolicitado = 24;

        if (saldo >= valorSolicitado) {
            saldo = saldo - valorSolicitado;
            System.out.println("Saldo atual: " + saldo);
        }
        else
            System.out.println("Saldo insuficiente");
    }
}
