public enum Extras {

    BORDARECHEADA(8), 
    PAOARTESANAL(2);

    private double preco;

    private Extras(double valor){
        this.preco = valor;
    }

    public double preco(){
        return this.preco;
    }

}
