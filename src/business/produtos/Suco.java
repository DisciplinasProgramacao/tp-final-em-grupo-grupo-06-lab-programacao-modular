package produtos;
public class Suco extends Bebidas {
    public static final double VALOR = 5;

    /**
     * Construtor Refrigerante
     */

    public Suco(){
        super(VALOR);
    }

    /**
     * Método utilizado para obter a descrição do produto
     * @return a descrição do produto formatada
     */

    public String descricao(){
        return String.format("| %-25s %-10s |\n",
        "Suco",
        String.format("R$ %.2f",this.getPrecoBase()));
    }
    
}
