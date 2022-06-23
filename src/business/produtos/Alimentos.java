package produtos;
public abstract class Alimentos extends Produtos {

    /**
     * Construtor Alimentos
     * @param preco : Preço do produto
     */

    public Alimentos(Double preco) {
        super(preco);
    }

    /**
     * Método utilizado para obter a descrição do produto
     * @return a descrição do produto
     */

    public abstract String descricao();
}
