package produtos;
public class PratoFeito extends Alimentos {
    public static final double VALOR = 15;

    /**
     * Construtor PratoFeito
     */

    public PratoFeito(){
        super(VALOR);
    }

    /**
     * Método utilizado para obter a descrição do produto
     * @return a descrição do produto formatada
     */

    public String descricao() {
        return String.format("| %-25s %-10s |\n",
        "Prato feito",
        String.format("R$ %.2f",this.getPrecoBase()));
    }
    
}
