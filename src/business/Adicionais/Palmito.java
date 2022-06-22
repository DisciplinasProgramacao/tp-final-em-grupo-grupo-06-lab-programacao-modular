package Adicionais;

public class Palmito extends AdicionaisDecorator {
    
    public Palmito(AlimentosComAdicional alimento) {
        super(alimento);
    }

    @Override
    public String descricao() {
        return super.descricao() + "Palmito R$3,00;";
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 3;
    }

}
