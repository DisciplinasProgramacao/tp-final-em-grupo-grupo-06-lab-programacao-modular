package Adicionais;

public class Ovo extends AdicionaisDecorator{

    public Ovo(AlimentosComAdicional alimento) {
		super(alimento);
	}

	@Override
	public String getDescricao() {
		return super.getDescricao() + ", Ovo (2)";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 2;
	}
    
}
