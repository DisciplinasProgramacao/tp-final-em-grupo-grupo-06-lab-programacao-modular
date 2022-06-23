package produtos;
public class Refrigerante extends Bebidas {

    public Refrigerante(){
        super(5.0);
    }

    public String descricao(){
        return String.format("| %-25s %-10s |\n",
        "Refrigerante",
        String.format("R$ %.2f",this.getPrecoBase()));
    }
    
}
