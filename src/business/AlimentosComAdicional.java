public abstract class AlimentosComAdicional extends Alimentos implements ICustoAdicional, IComponenteExtra {

    public AlimentosComAdicional(Double preco) {
        super(preco);
    }

    @Override
    public void adicionarCustoExtra() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void somarCustoAdicional() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public abstract String descricao();
    
}
