package produtos.extras;


public enum SanduicheExtra {
    PAO_ARTESANAL(2);

    private double  preco;

    private SanduicheExtra(double preco){
        this.preco = preco;
    }

    public double getPreco(){
        return this.preco;
    }

}
