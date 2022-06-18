public enum Categoria {

    BRANCO(0),
    PRATA(5),
    PRETO(10),
    FV(20);

    private double desconto;

    private Categoria(double valor){
        this.desconto = valor;
    }

    public double desconto(){
        return this.desconto;
    }
    
    
}
