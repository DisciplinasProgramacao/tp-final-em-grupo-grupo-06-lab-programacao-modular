package Adicionais;

public class BatataPalha extends AdicionaisDecorator {

    public BatataPalha(AlimentosComAdicional alimento) {
		super(alimento);
	}

	@Override
	public String descricao() {
		return super.descricao() + ", Batata Palha - R$ 2,00;";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 2;
	}
    
}
