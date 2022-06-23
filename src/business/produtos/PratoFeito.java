package produtos;
public class PratoFeito extends Alimentos {

    public PratoFeito(){
        super(15.0);
    }

    public String descricao() {
        return String.format("| %-25s %-10s |\n",
        "Prato feito",
        String.format("R$ %.2f",this.getPrecoBase()));
    }
    
}
