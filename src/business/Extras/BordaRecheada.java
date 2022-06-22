package Extras;

public class BordaRecheada extends PizzaExtraDecorator {

    public BordaRecheada(AlimentosComExtra alimento) {
		super(alimento);
	}

	@Override
	public String descricao() {
		return super.descricao() + "Borda Recheada - R$8,00;";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 8;
	}
    
}
