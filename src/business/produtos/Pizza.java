package produtos;

import java.util.ArrayList;
import java.util.List;

import Adicionais.Adicional;
import Adicionais.AlimentosComAdicional;
import produtos.extras.PizzaExtra;

public class Pizza extends Alimentos implements AlimentosComAdicional, produtos.extras.AlimentosComExtra {
    public static final double VALOR = 25;

    private List<PizzaExtra> extras = new ArrayList<PizzaExtra>();

    /**
     * Construtor Pizza
     */

    public Pizza() {
        super(VALOR);
    }

    /**
     * Método utilizado para obter a descrição do produto
     * @return string contendo a descrição do produto
     */

    @Override
    public String descricao() {
        
        String str = String.format("| %-25s %-10s |\n", "Pizza da casa", getPrecoTotal());
        if( !this.adicionais.isEmpty() ){
            String ad = this.adicionais.stream()
            .map(s -> String.format("|\t%-17s - %-10s |\n", s.toString(), String.format("R$%.2f", s.getPreco())))
            .reduce((a, b) -> a.concat(b))
            .get();
            str += ad;
        }
        if( !this.extras.isEmpty() ){
            String ex = this.extras.stream()
            .map(s -> String.format("|\t%-17s - %-10s |\n", s.toString(), String.format("R$%.2f", s.getPreco())))
            .reduce((a, b) -> a.concat(b))
            .get();
            str += "\tExtras----------\n" + ex;
        }
        return str;
    }

     /**
     * Método utilizado para obter o preço base do produto
     * @return preço base do produto
     */

    public double getPreco() {
        return this.getPrecoBase();
    }

    /**
     * Método utilizado para adicionar um componente adicional à pizza
     * @param adicional : Adicional da pizza
     */

    @Override
    public void adicionarAdicional(Adicional adicional) {
        this.adicionais.add(adicional);
    }

    /**
     * Método utilizado para obter a soma do preço de todos os adicionais da Pizza
     * @return um valor double contendo o valor total dos adicionais
     */

    @Override
    public double getAdicionais() {
        if (adicionais.isEmpty()) {
            return 0;
        } else {
            return adicionais.stream()
                    .mapToDouble(Adicional::getPreco)
                    .reduce(0, (n, m) -> n + m);
        }
    }

    /**
     * Método utilizado para obter o preço total da pizza (considerando os adicionais)
     * @return double contendo o preço total
     */

    @Override
    public double getPrecoTotal() {
        return this.getPrecoBase() + getAdicionais() + getExtra();
    }

    /**
     * Método utilizado para obter a soma do preço de todos os extras da Pizza
     * @return um valor double contendo o valor total dos extras
     */

    @Override
    public double getExtra() {
        if (extras.isEmpty()) {
            return 0;
        } else {
            return extras.stream()
                    .mapToDouble(PizzaExtra::getPreco)
                    .reduce(0, (n, m) -> n + m);
        }
    }

    /**
     * Método utilizado para adicionar componente extra à Pizza
     */

    @Override
    public void addExtra() {
        this.extras.add(PizzaExtra.BORDA_RECHEADA);

    }
}
