public abstract class Produtos {
    private double precoBase;
    private double precoTotal;
    private int valorReajusteAnual;

    // Construtor

    public Produtos(Double preco){
        this.precoBase = preco;
    }

    // Getters

    public double getPrecoBase() {
        return precoBase;
    }

    public double getPrecoTotal(double valorAdicionais){
        return precoBase + valorAdicionais;
    }

    // Reajusta preço do produto 

    public void reajustarPrecoAnual(){
        this.precoBase = getPrecoBase() + (getPrecoBase() * this.valorReajusteAnual)/100;
    }


}
