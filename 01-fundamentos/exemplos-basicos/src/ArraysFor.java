public class ArraysFor {
    static void main(String[] args) {
        String alunos[] = {"FELIPE", "JONAS", "JULIA", "MARCOS"};

        for(String aluno: alunos) {
            //Em arrays o índice inicial é 0
            System.out.println("Aluno (a): " + aluno);
        }
    }
}
