package produtos;
public class Agua extends Bebidas{
    public static final double VALOR = 2;

     /**
     * Construtor Agua
     */
    public Agua(){
        super(VALOR);
    }

     /**
     * Método utilizado para obter a descrição do produto
     * @return a descrição do produto formatada
     */

    public String descricao(){
        return String.format("| %-25s %-10s |\n",
        "Água mineral sem gás",
        String.format("R$ %.2f",this.getPrecoBase()));
    }
    
}
