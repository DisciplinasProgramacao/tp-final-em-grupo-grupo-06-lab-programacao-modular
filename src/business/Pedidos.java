import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedidos {
    // Constantes
    private static final int MAX_PRODUTOS = 10;
    // Atributos
    private Clientes cliente;
    private static int identificador;
    private LocalDateTime dataDeRealizacao;
    private float precoTotal;
    private float porcentagemDesconto;

    private ArrayList<Produtos> produtos;
    private int numProdutos = 0;

    private float nota;

    public Pedidos(Clientes cliente, LocalDateTime dataProduto){
        this.cliente = cliente;
        this.dataDeRealizacao = dataProduto;
        Pedidos.identificador = ++numProdutos;
    }

    public Pedidos(Clientes cliente, LocalDateTime dataProduto, float desconto){
        this.cliente = cliente;
        Pedidos.identificador = ++numProdutos;
        this.dataDeRealizacao = dataProduto;
        
    }

    // Getters

    public float getPrecoTotal() {
        float precoTotal = produtos.stream() // !!!!!!!!!!!!!!
        .map(p -> p.getPrecoTotal(valorAdicionais))
        .reduce(0, (n, m) -> n + m);

        this.precoTotal = precoTotal;
    }

    // Adiciona produto a pedidos

    public void adicionaProduto(Produtos produto){
        if (numProdutos < MAX_PRODUTOS){
            produtos.add(produto);
            this.numProdutos++;
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

    public void mostraPedidos() {
        for(int i = 0; i <= numProdutos; i++){
            System.out.println("Descrição: " + produtos.get(i).descricao() + "\n" + "Preço base: " + produtos.get(i).getPrecoBase());
        }
    

    }
    
}
