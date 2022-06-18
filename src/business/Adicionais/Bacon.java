package Adicionais;

public class Bacon extends AdicionaisDecorator {

    public Bacon(AlimentosComAdicional alimento) {
		super(alimento);
	}

	@Override
	public String getDescricao() {
		return super.getDescricao() + ", Bacon (3)";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 3;
	}
    
}
