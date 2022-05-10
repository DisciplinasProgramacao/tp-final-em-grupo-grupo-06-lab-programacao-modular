import java.time.LocalDateTime;

public class Pedidos {
    // Constantes
    private static final int MAX_PRODUTOS = 10;
    // Atributos
    private static int identificador;
    private LocalDateTime dataDeRealizacao;
    private float precoTotal;
    private float porcentagemDesconto;
    private Produtos produtos[];
    private int numProdutos = 0;

    public Pedidos(LocalDateTime dataProduto){
        this.identificador = ++numProdutos;
        this.dataDeRealizacao = dataProduto;
    }

    public Pedidos(LocalDateTime dataProduto, float desconto){
        this.identificador = ++numProdutos;
        this.dataDeRealizacao = dataProduto;
        
    }

    // Getters

    public float getPrecoTotal() {
        return precoTotal;
    }

    // Adiciona produto a pedidos

    public void adicionaProduto(Produtos produto){
        if (numProdutos < MAX_PRODUTOS){
            produtos[numProdutos] = produto;
            this.numProdutos++;
        }
    }

    // Retorna o preço total do pedido 

    public void DefinePrecoTotal(){
        for(int i = 0; i <= numProdutos ; i++){
            this.precoTotal+= produtos[i].getPrecoBase();
        }
    }


    // Aplica o desconto, se houver, no subtotal do pedido

    public void aplicarDesconto(){
        this.precoTotal = getPrecoTotal() + (getPrecoTotal() * this.porcentagemDesconto)/100;
    }

    // Gera a nota de compra

    public void gerarNotaDeCompra(){
        System.out.println("Id: " + this.identificador + "\n" + 
        "Data de realização: " + this.dataDeRealizacao + "\n" +
        "Preço total: " + getPrecoTotal() + "\n" +
        "Desconto aplicado: " + this.porcentagemDesconto + "%" + "\n");
        mostraPedidos();
    }

    private void mostraPedidos() {
        for(int i = 0; i <= numProdutos; i++){
            System.out.println("Descrição: " + produtos[i].descricao() + "\n" + "Preço base: " + produtos[i].getPrecoBase());
        }
    }
    
}
