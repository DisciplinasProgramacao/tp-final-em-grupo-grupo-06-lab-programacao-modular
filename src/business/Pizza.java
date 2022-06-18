import Adicionais.AlimentosComAdicional;
import Extras.AlimentosComExtra;

public class Pizza extends Alimentos implements AlimentosComAdicional, AlimentosComExtra {
    
    public Pizza(){
        super(25.0);
    }

    @Override
    public String getDescricao() {
        return "Pizza da casa";
    }

    @Override
    public double getPreco() {
        return 25;
    }
    
}
