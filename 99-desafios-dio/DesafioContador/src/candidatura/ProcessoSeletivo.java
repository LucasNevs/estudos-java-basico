package candidatura;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProcessoSeletivo {
    ArrayList<String> candidatosAprovados = new ArrayList<>();
    void main() {
        selecaoCandidato();
        imprimirCandidatosAprovados();
        tentarContato(candidatosAprovados);

    }

    public void selecaoCandidato(){
        Scanner input = new Scanner(System.in);
        int candidatosSelecionados = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5) {

            System.out.println("Nome do candidato: ");
            String candidato = input.next();
            System.out.println("Pretensão salarial: ");
            double pretensaoSalarial = input.nextDouble();
            if (pretensaoSalarial <= salarioBase){
                System.out.println("O candidato " + candidato + " foi selecionado com sucesso!");
                candidatosAprovados.add(candidato);
                candidatosSelecionados++;
            }else{
                System.out.println("Vamos te ligar");
            }
        }
    }

    public void imprimirCandidatosAprovados(){
        System.out.println("Candidatos Aprovados: " +  candidatosAprovados);
    }

    public boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    public void tentarContato(ArrayList<String> candidatosAprovados){
        for (String candidato : candidatosAprovados) {
            int tentativasRealizadas = 1;
            boolean continuarTentando;
            boolean atendeu;
            do {
                atendeu = atender();
                continuarTentando = !atendeu;
                if (continuarTentando) {
                    tentativasRealizadas++;
                } else
                    System.out.println("Sucesso!\n");

            } while (continuarTentando && tentativasRealizadas < 3);
            if (atendeu) {
                System.out.println("Conseguimos contato com " + candidato + " na tentativa de número " + tentativasRealizadas + "\n");
            } else {
                System.out.println("Não conseguimos contato com o candidato(a) " + candidato + "\n");
            }
        }
    }
}
