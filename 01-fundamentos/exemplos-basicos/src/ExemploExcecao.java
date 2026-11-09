import java.text.NumberFormat;
import java.text.ParseException;

public class ExemploExcecao {
    static void main(String[] args){

        Number valor = null;
        try {
            valor = NumberFormat.getInstance().parse("a1.75");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("valor: " + valor);
    }
}
