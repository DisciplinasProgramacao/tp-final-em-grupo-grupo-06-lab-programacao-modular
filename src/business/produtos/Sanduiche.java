package produtos;

import java.util.ArrayList;
import java.util.List;

import Adicionais.Adicional;
import Adicionais.AlimentosComAdicional;
import produtos.extras.SanduicheExtra;

public class Sanduiche extends Alimentos implements AlimentosComAdicional, produtos.extras.AlimentosComExtra {

    public static final double VALOR = 12;

    private List<SanduicheExtra> extras = new ArrayList<SanduicheExtra>();

    /**
     * Construtor Sanduíche
     */

    public Sanduiche() {
        super(VALOR);
    }

    /**
     * Método utilizado para obter a descrição do produto
     * @return string contendo a descrição do produto
     */

    @Override
    public String descricao() {

        String str = String.format("| %-25s %-10s |\n", "Sanduíche", getPrecoTotal());
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
        return VALOR;
    }

    /**
     * Método utilizado para obter a soma do preço de todos os adicionais do Sanduiche
     * @return um valor double contendo o valor total dos adicionais
     */

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
     * Método utilizado para obter o preço total do sanduiche (considerando os adicionais)
     * @return double contendo o preço total
     */

    @Override
    public double getPrecoTotal() {
        return this.getPrecoBase() + getAdicionais() + getExtra();
    }

    /**
     * Método utilizado para adicionar um componente adicional ao sanduiche
     * @param adicional : Adicional do sanduiche
     */

    @Override
    public void adicionarAdicional(Adicional adicional) {
        this.adicionais.add(adicional);
    }

    /**
     * Método utilizado para obter a soma do preço de todos os extras do sanduiche
     * @return um valor double contendo o valor total dos extras
     */

    @Override
    public double getExtra() {
        if (extras.isEmpty()) {
            return 0;
        } else {
            return extras.stream()
                    .mapToDouble(SanduicheExtra::getPreco)
                    .reduce(0, (n, m) -> n + m);
        }
    }

    /**
     * Método utilizado para adicionar componente extra à Pizza
     */

    @Override
    public void addExtra() {
        this.extras.add(SanduicheExtra.PAO_ARTESANAL);

    }
}
