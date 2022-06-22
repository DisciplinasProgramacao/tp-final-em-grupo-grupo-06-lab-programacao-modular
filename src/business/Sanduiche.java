import Adicionais.AlimentosComAdicional;
import Extras.AlimentosComExtra;

public class Sanduiche extends Alimentos implements AlimentosComAdicional, AlimentosComExtra {

    public Sanduiche(){
        super(12.0);
    }

    @Override
    public String descricao() {
        return "Sanduíche - R$12,00;";
    }

    @Override
    public double getPreco() {
        return 12;
    }


    
}
