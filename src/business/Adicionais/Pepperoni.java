package Adicionais;

public class Pepperoni extends AdicionaisDecorator {

    public Pepperoni(AlimentosComAdicional alimento) {
		super(alimento);
	}

	@Override
	public String descricao() {
		return super.descricao() + "Pepperoni - R$ 4,00;";
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 4;
	}
    
}
