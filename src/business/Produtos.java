import java.util.ArrayList;

import Adicionais.AlimentosComAdicional;

public abstract class Produtos {
    private double precoBase;
    private double precoTotal;
    private double valorReajusteAnual;

    private ArrayList<AlimentosComAdicional> adicionais;

    // Construtor

    public Produtos(Double preco){
        this.precoBase = preco;
    }

    // Getters

    public double getPrecoBase() {
        return precoBase;
    }

    public double getPrecoTotal(){
        return precoBase + getAdicionais();
    }

    public double getAdicionais(){
        return adicionais.stream()
        .mapToDouble(AlimentosComAdicional::getPreco)
        .reduce(0, (n,m) -> n + m);
    }

    // Setters

    public void setValorReajusteAnual(double valorReajusteAnual) {
        this.valorReajusteAnual = valorReajusteAnual;
    }

    // Reajusta preço do produto 

    public void reajustarPrecoAnual(){
        this.precoBase = getPrecoBase() + (getPrecoBase() * this.valorReajusteAnual)/100;
    }
    
    // Descrição do produto

    public abstract String descricao();


}
