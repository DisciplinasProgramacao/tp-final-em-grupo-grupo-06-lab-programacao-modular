import java.util.ArrayList;
import java.util.List;

import Adicionais.AlimentosComAdicional;

public abstract class Produtos {
    private double precoBase;
    private double precoTotal;
    private double valorReajusteAnual;

    List<AlimentosComAdicional> adicionais = new ArrayList<AlimentosComAdicional>();

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
        return precoBase + getAdicionais();
    }

    public double getAdicionais() {
        if (adicionais.isEmpty()) {
            return 0;
        } else {
            return adicionais.stream()
                    .mapToDouble(AlimentosComAdicional::getPreco)
                    .reduce(0, (n, m) -> n + m);
        }
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
