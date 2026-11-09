void main() {
    Scanner terminal = new Scanner(System.in);

    IO.println("Qual o primeiro número: ");
    int parametro1 = terminal.nextInt();
    IO.println("Qual o segundo número: ");
    int parametro2 = terminal.nextInt();

    try {
        contar(parametro1, parametro2);
    } catch (ParametrosInvalidosException e) {
        IO.println("O segundo parâmetro deve ser maior que o primeiro!");

    }
}

private static void contar(int parametro1, int parametro2) throws ParametrosInvalidosException {
    if (parametro1 > parametro2) {
        throw new ParametrosInvalidosException();
    } else {
        int contagem = parametro2 - parametro1;
        for (int i = 1; i <= contagem; i++) {
            IO.println("Imprimindo o número " + i);
        }
    }
}
