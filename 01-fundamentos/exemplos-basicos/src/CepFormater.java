public class CepFormater {
    static void main(String[] args) {
        try {
            String cepFormatado = formatCep("1234568");
            System.out.println( cepFormatado );
        } catch (CepInvalidoException e) {
            System.out.println("O cep não está de acordo com o padrão.");
        }
    }

    static String formatCep(String cep) throws CepInvalidoException {
        if (cep.length() != 8)
            throw new CepInvalidoException();
            return "65.633-240";
    }
}
