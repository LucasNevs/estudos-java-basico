import java.util.Scanner;

public static void main(String[] args) {

    Scanner input = new Scanner(System.in);


    System.out.println("Digite seu nome: ");
    String NomeUsuario = input.nextLine();
    System.out.println("Digite o número da sua conta: ");
    int ContaUsuario = input.nextInt();
    System.out.println("Digite o número da sua agência: ");
    String AgenciaUsuario = input.next();
    double Saldo = 237.48;

    System.out.println("Olá " + NomeUsuario + ", obrigado por criar uma conta " +
            "em nosso banco, sua agência é " + AgenciaUsuario + ", conta " + ContaUsuario + " e " +
            "seu saldo " + Saldo + " já está disponível para saque.");
}