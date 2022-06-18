package Adicionais;

public abstract class AdicionaisDecorator implements AlimentosComAdicional {
    
    private final AlimentosComAdicional alimento;

    public AdicionaisDecorator(AlimentosComAdicional alimento){
        if(alimento == null)
            throw new RuntimeException("Acrescimo deve possuir um hambúrguer ou pizza");
        this.alimento = alimento;
    }

    @Override
    public double getPreco(){
        return alimento.getPreco();
    }

    @Override
    public String getDescricao(){
        return alimento.getDescricao();
    }
    
}
