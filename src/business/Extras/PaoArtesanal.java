package Extras;

public class PaoArtesanal extends SanduicheExtraDecorator {

    public PaoArtesanal(AlimentosComExtra alimento) {
		super(alimento);
	}

	@Override
	public String descricao() {
		return super.descricao() + "Pão Artesanal - R$ 2,00;";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 2;
	}
    
}
