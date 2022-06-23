package produtos.extras;

public enum PizzaExtra {
    BORDA_RECHEADA(8);
    

    private double preco;

    /**
     * Construtor PizzaExtra
     * @param preco : Preço do componente extra da pizza
     */

    private PizzaExtra(double preco){
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
