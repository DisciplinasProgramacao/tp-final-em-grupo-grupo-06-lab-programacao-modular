public abstract class Produtos {
    private double precoBase;
    private int valorReajusteAnual;

    // Construtor

    public Produtos(Double preco){
        this.precoBase = preco;
    }

    // Getters

    public double getPrecoBase() {
        return precoBase;
    }

    // Reajusta preço do produto 

    public void reajustarPrecoAnual(){
        this.precoBase = getPrecoBase() + (getPrecoBase() * this.valorReajusteAnual)/100;
    }

    // Mostra descrição do produto

    public abstract String descricao();
}
