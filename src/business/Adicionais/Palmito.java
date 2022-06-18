package Adicionais;

public class Palmito extends AdicionaisDecorator {
    
    public Palmito(AlimentosComAdicional alimento) {
        super(alimento);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + ", Palmito (3)";
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 3;
    }

}
