package Extras;

public class PaoArtesanal extends SanduicheExtraDecorator {

    public PaoArtesanal(AlimentosComExtra alimento) {
		super(alimento);
	}

	@Override
	public String getDescricao() {
		return super.getDescricao() + ", Pão Artesanal (2)";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 2;
	}
    
}
