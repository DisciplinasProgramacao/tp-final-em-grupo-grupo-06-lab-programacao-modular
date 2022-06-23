package produtos;
import java.util.ArrayList;
import java.util.List;

import Adicionais.Adicional;
import Adicionais.AlimentosComAdicional;

public abstract class Produtos {
    private double precoBase;
    private double precoTotal;
    private double valorReajusteAnual;

    List<Adicional> adicionais = new ArrayList<Adicional>();

    // Construtor

    public Produtos(Double preco) {
        this.precoBase = preco;
    }

    // Getters

    public double getPrecoBase() {
        return precoBase;
    }

    // tá dando erro nessa porra aqui
    public double getPrecoTotal() {
        return precoBase;
    }

   

    // Setters

    public void setValorReajusteAnual(double valorReajusteAnual) {
        this.valorReajusteAnual = valorReajusteAnual;
    }

    // Reajusta preço do produto

    public void reajustarPrecoAnual() {
        this.precoBase = getPrecoBase() + (getPrecoBase() * this.valorReajusteAnual) / 100;
    }

    // Descrição do produto

    public abstract String descricao();

}
