package Adicionais;

import produtos.Alimentos;

public interface AlimentosComAdicional  {

   

    public abstract String descricao();
    public abstract double getPreco();

    public double getAdicionais();
    public void adicionarAdicional(Adicional adicional);

}
