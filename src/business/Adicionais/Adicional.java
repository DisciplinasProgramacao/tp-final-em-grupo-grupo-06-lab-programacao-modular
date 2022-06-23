package Adicionais;

public enum Adicional {
    BACON(3),
    BATATA_PALHA(2),
    OVO(2),
    PALMITO(3),
    PEPERONI(4),
    PICLES(2),
    QUEIJO(2);

    private double  preco;

    private Adicional(double preco){
        this.preco = preco;
    }

    public double getPreco(){
        return this.preco;
    }

}
