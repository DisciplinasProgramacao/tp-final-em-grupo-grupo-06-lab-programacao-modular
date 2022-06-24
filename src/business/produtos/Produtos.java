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

    /**
     * Método utilizado para obter o preço base do produto (sem adicionais)
     * @return o preço base do produto
     */
    public double getPrecoBase() {
        return precoBase;
    }

    /**
     * Método utilizado para obter o preço total do produto (considerando os adicionai)
     * @return o preço total do produto
     */
    public double getPrecoTotal() {
        return precoBase;
    }


    /**
     * Método utilizado para definir o valor do reajuste anual do produto
     * @param valorReajusteAnual : Valor do reajuste anual
     * @return o preço total do produto
     */
    public void setValorReajusteAnual(double valorReajusteAnual) {
        this.valorReajusteAnual = valorReajusteAnual;
    }

    /**
     * Método utilizado para reajustar o preço anual
     */

    public void reajustarPrecoAnual() {
        this.precoBase = getPrecoBase() + (getPrecoBase() * this.valorReajusteAnual) / 100;
    }

    /**
     * Descrição do produto
     * @return a descrição do produto
     */

    public abstract String descricao();

}
