package produtos;
public abstract class Bebidas extends Produtos {

    /**
     * Construtor Bebidas
     * @param preco : Preço do produto
     */

    public Bebidas(double preco){
        super(preco);
    }

    /**
     * Método utilizado para obter a descrição do produto
     * @return a descrição do produto
     */

    public abstract String descricao();
}
