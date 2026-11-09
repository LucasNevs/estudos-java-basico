package escola;

public class Escola  {
    public static void main(String[] args) {
        Aluno lucas = new Aluno();
        lucas.setNome("Lucas");
        lucas.setIdade(34);

        System.out.println("A aluno " + lucas.getNome() + " tem " + lucas.getIdade() + " anos");
    }
}