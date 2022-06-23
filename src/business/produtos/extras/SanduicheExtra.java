package produtos.extras;


public enum SanduicheExtra {
    PAO_ARTESANAL(2);

    private double  preco;

    /**
     * Construtor SanduicheExtra
     * @param preco : Preço do componente extra do sanduiche
     */

    private SanduicheExtra(double preco){
        this.preco = preco;
    }

    /**
     * Método utilizado para obter o preço do componente extra
     * @return o preço do componente extra da pizza
     */

    public double getPreco(){
        return this.preco;
    }

}
