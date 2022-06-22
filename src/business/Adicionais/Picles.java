package Adicionais;

public class Picles extends AdicionaisDecorator {

	public Picles(AlimentosComAdicional alimento) {
		super(alimento);
	}

	@Override
	public String descricao() {
		return super.descricao() + "Picles - R$2,00;";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 2;
	}


}
