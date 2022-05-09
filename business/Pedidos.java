import java.time.LocalDateTime;

public class Pedidos {
    // Constantes
    private static final int MAX_PRODUTOS = 10;
    // Atributos
    private static int identificador;
    private LocalDateTime dataDeRealizacao;
    private float porcentagemDesconto;
    private Produtos produtos[];
    private int numProdutos = 1;

    public Pedidos(LocalDateTime dataProduto){
        this.identificador++;
        this.dataDeRealizacao = dataProduto;
    }

    // Adiciona produto a pedidos

    public void adicionaProduto(Produtos produto){
        if (numProdutos < MAX_PRODUTOS){
            produtos[numProdutos] = produto;
            numProdutos++;
        }
    }


    // Aplica o desconto, se houver, no subtotal do pedido

    public void aplicarDesconto(){

    }

    // Gera a nota de compra

    public void gerarNotaDeCompra(){

    }
    
}
