package produtos;
public enum Categoria {

    BRANCO(0),
    PRATA(0.05),
    PRETO(0.1),
    FV(0.2);

    private double desconto;

    private Categoria(double valor){
        this.desconto = valor;
    }

    public double desconto(){
        return this.desconto;
    }
    
    
}
