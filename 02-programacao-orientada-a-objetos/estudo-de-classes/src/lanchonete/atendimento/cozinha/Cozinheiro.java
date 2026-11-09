package lanchonete.atendimento.cozinha;
import lanchonete.atendimento.Atendente;

public class Cozinheiro {
    public void adicionarLancheNoBalcao(){
        System.out.println("ADICIONANDO LANCHE NATURAL DE HAMBURGUER NO BALCÃO");
    }    public void adicionarSucoNoBalcao(){
        System.out.println("ADICIONANDO SUCO NO BALCÃO");
    }
    public void adicionarComboNoBalcao(){
        adicionarLancheNoBalcao();
        adicionarSucoNoBalcao();
    }
    private void prepararLanche(){
        System.out.println("PREPARANDO LANCHE TIPO HAMBURGUER");
    }
    public void prepararVitamina(){
        System.out.println("PREPARANDO SUCO");
    }
    public void prepararCombo(){
        prepararLanche();
        prepararVitamina();
    }
    private void selecionarIngredientes(){
        System.out.println("SELECIONANDO O PÃO, SALADA, OVO E CARNE");
    }
    private void selecionarIngredientesVitamina(){
        System.out.println("SELECIONANDO FRUTA, LEITE E SUCO");
    }
    private void lavarIngredientes(){
        System.out.println("LAVANDO INGREDIENTES");
    }
    private void baterVitaminaLiquidificador(){
        System.out.println("BATENDO VITAMINA NO LIQUIDIFICADOR");
    }
    private void fritarIngredientesLanche(){
        System.out.println("FRITANDO O PÃO, CARNE E OVO PARA O HAMBURGUER");
    }
    private void pedirParaTrocarGas(Almoxarife meuAmigo){
    }
    private void pedirIngredientesAlmoxarife(Almoxarife almoxarife){
        almoxarife.entregarIngredientes();
    }

}

