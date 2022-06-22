package Adicionais;

public class Bacon extends AdicionaisDecorator {

    public Bacon(AlimentosComAdicional alimento) {
		super(alimento);
	}

	@Override
	public String descricao() {
		return super.descricao() + ", Bacon - R$3,00;";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 3;
	}
    
}
