package produtos;
public class Cerveja extends Bebidas{
    public static final double VALOR = 8;

    /**
     * Construtor Cerveja
     */

    public Cerveja(){
        super(VALOR);
    }

    /**
     * Método utilizado para obter a descrição do produto
     * @return a descrição do produto formatada
     */

    public String descricao(){
        return String.format("| %-25s %-10s |\n",
        "Cerveja gelada",
        String.format("R$ %.2f",this.getPrecoBase()));
    }
    
}
