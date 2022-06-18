package Extras;

public abstract class PizzaExtraDecorator implements AlimentosComExtra {
    
    private final AlimentosComExtra pizza;

    public PizzaExtraDecorator(AlimentosComExtra pizza){
        if(pizza == null)
            throw new RuntimeException("Acrescimo deve possuir uma pizza");
        this.pizza = pizza;
    }

    @Override
    public double getPreco(){
        return pizza.getPreco();
    }

    @Override
    public String getDescricao(){
        return pizza.getDescricao();
    }
    
}