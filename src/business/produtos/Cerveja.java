package produtos;
public class Cerveja extends Bebidas{

    public Cerveja(){
        super(8.0);
    }

    public String descricao(){
        return String.format("| %-25s %-10s |\n",
        "Cerveja gelada",
        String.format("R$ %.2f",this.getPrecoBase()));
    }
    
}
