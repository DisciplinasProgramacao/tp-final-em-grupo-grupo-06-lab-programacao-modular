package Adicionais;

public class Queijo extends AdicionaisDecorator {

	public Queijo(AlimentosComAdicional alimento) {
		super(alimento);
	}

	@Override
	public String descricao() {
		return super.descricao() + "Queijo - R$2,00;";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 2;
	}

}
