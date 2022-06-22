package Adicionais;

public class Ovo extends AdicionaisDecorator{

    public Ovo(AlimentosComAdicional alimento) {
		super(alimento);
	}

	@Override
	public String descricao() {
		return super.descricao() + "Ovo - R$ 2,00;";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 2;
	}
    
}
