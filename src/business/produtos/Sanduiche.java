package produtos;

import java.util.ArrayList;
import java.util.List;

import Adicionais.Adicional;
import Adicionais.AlimentosComAdicional;
import produtos.extras.SanduicheExtra;

public class Sanduiche extends Alimentos implements AlimentosComAdicional, produtos.extras.AlimentosComExtra {

    private List<SanduicheExtra> extras = new ArrayList<SanduicheExtra>();

    public Sanduiche() {
        super(12.0);
    }

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

    @Override
    public double getPreco() {
        return 12;
    }

    public double getAdicionais() {
        if (adicionais.isEmpty()) {
            return 0;
        } else {
            return adicionais.stream()
                    .mapToDouble(Adicional::getPreco)
                    .reduce(0, (n, m) -> n + m);
        }
    }

    @Override
    public double getPrecoTotal() {
        return this.getPrecoBase() + getAdicionais() + getExtra();
    }

    @Override
    public void adicionarAdicional(Adicional adicional) {
        this.adicionais.add(adicional);
    }

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

    @Override
    public void addExtra() {
        this.extras.add(SanduicheExtra.PAO_ARTESANAL);

    }
}
