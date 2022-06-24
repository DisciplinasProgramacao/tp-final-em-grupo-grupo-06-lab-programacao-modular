package produtos;
public enum Categoria {

    BRANCO(0),
    PRATA(0.05),
    PRETO(0.1),
    FV(0.2);

    private double desconto;

    /**
     * Construtor Categoria
     * @param valor : Valor do desconto
     */

    private Categoria(double valor){
        this.desconto = valor;
    }

    /**
     * Método utilizado para obter o valor do desconto com base na categoria do cliente
     * @return valor do desconto
     */

    public double desconto(){
        return this.desconto;
    }
    
    
}
