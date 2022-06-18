package Adicionais;

public class Pepperoni extends AdicionaisDecorator {

    public Pepperoni(AlimentosComAdicional alimento) {
		super(alimento);
	}

	@Override
	public String getDescricao() {
		return super.getDescricao() + ", Pepperoni (4)";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 4;
	}
    
}
