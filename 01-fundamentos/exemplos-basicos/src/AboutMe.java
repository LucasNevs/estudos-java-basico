import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class AboutMe {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);

        try {
            System.out.println("Digite seu nome: ");
            String nome = input.nextLine();

            System.out.println("Digite seu sobrenome: ");
            String sobrenome = input.nextLine();

            System.out.println("Digite sua idade: ");
            int idade = input.nextInt();

            System.out.println("Digite sua altura: ");
            float altura = input.nextFloat();

            System.out.println("Olá! Me chamo " + nome.toUpperCase() + " " + sobrenome.toUpperCase() + "" +
                    ", tenho  " + idade + " anos de idade e tenho " + altura + " de altura");
            input.close();
        } catch (InputMismatchException e) {
            System.out.println("Altura e idade devem ser numéricos!");;
        }
    }
}
