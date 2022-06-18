package Adicionais;

public class Queijo extends AdicionaisDecorator {

	public Queijo(AlimentosComAdicional alimento) {
		super(alimento);
	}

	@Override
	public String getDescricao() {
		return super.getDescricao() + ", Queijo (2)";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 2;
	}

}
