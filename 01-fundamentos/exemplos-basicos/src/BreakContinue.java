public class BreakContinue {
    static void main(String[] args) {
        for(int contador = 1; contador <= 5; contador++){
            if(contador == 3){
                break;
            }
            System.out.println(contador);
        }

        for(int contador = 1; contador <= 5; contador++){
            if(contador == 3){
                continue;
            }
            System.out.println(contador);
        }
    }
}
