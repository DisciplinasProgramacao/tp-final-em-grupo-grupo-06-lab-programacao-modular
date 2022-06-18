package Adicionais;

public class BatataPalha extends AdicionaisDecorator {

    public BatataPalha(AlimentosComAdicional alimento) {
		super(alimento);
	}

	@Override
	public String getDescricao() {
		return super.getDescricao() + ", Batata Palha (2)";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 2;
	}
    
}
