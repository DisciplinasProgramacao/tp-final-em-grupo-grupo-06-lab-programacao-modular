package produtos.extras;

public enum PizzaExtra {
    BORDA_RECHEADA(8);
    

    private double preco;

    private PizzaExtra(double preco){
        this.preco = preco;
    }

    public double getPreco(){
        return this.preco;
    }

}
