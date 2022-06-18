package Adicionais;

public class Picles extends AdicionaisDecorator {

	public Picles(AlimentosComAdicional alimento) {
		super(alimento);
	}

	@Override
	public String getDescricao() {
		return super.getDescricao() + ", Picles (2)";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 2;
	}


}
