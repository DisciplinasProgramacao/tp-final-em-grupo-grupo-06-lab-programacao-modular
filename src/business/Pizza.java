import Adicionais.AlimentosComAdicional;
import Extras.AlimentosComExtra;

public class Pizza extends Alimentos implements AlimentosComAdicional, AlimentosComExtra {
    
    public Pizza(){
        super(25.0);
    }

    @Override
    public String descricao() {
        return "Pizza da casa - R$25,00;";
    }

    @Override
    public double getPreco() {
        return 25;
    }
    
}
