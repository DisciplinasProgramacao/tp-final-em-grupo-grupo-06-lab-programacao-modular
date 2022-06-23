package produtos;
public class Agua extends Bebidas{

    public Agua(){
        super(2.0);
    }

    public String descricao(){
        return String.format("| %-25s %-10s |\n",
        "Água mineral sem gás",
        String.format("R$ %.2f",this.getPrecoBase()));
    }
    
}
