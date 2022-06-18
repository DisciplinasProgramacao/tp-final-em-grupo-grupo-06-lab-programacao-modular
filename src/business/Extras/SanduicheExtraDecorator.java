package Extras;

public abstract class SanduicheExtraDecorator implements AlimentosComExtra {
    
    private final AlimentosComExtra sanduiche;

    public SanduicheExtraDecorator(AlimentosComExtra sanduiche){
        if(sanduiche == null)
            throw new RuntimeException("Acrescimo deve possuir um hambúrguer");
        this.sanduiche = sanduiche;
    }

    @Override
    public double getPreco(){
        return sanduiche.getPreco();
    }

    @Override
    public String getDescricao(){
        return sanduiche.getDescricao();
    }
    
}