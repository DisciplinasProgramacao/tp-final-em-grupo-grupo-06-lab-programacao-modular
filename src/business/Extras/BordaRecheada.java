package Extras;

public class BordaRecheada extends PizzaExtraDecorator {

    public BordaRecheada(AlimentosComExtra alimento) {
		super(alimento);
	}

	@Override
	public String getDescricao() {
		return super.getDescricao() + ", Borda Recheada (8)";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 8;
	}
    
}
