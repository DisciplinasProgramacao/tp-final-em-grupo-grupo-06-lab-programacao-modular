import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedidos {
    // Constantes
    private static final int MAX_PRODUTOS = 10;
    // Atributos
    private static int identificador;
    private Clientes cliente;
    private LocalDateTime dataDeRealizacao;
    private double precoTotal;
    private double porcentagemDesconto;
    private double nota;

    List<Produtos> produtos = new ArrayList(MAX_PRODUTOS);
    private int numProdutos = 0;

    public Pedidos(Clientes cliente, LocalDateTime dataProduto) {
        this.cliente = cliente;
        this.dataDeRealizacao = dataProduto;
        Pedidos.identificador = ++numProdutos;
    }

    public Pedidos(Clientes cliente, LocalDateTime dataProduto, double desconto) {
        this.cliente = cliente;
        Pedidos.identificador = ++numProdutos;
        this.dataDeRealizacao = dataProduto;

    }

    // Getters

    public double getPrecoTotal() {
        double precoTotal = produtos.stream()
                .mapToDouble(p -> p.getPrecoTotal())
                .reduce(0, (n, m) -> n + m);
        
        precoTotal = precoTotal - (precoTotal * cliente.categoria.desconto());

        this.precoTotal = precoTotal;
        return precoTotal;
    }

    public double getNota() {
        return nota;
    }

    // Setters 

    public void setNota(double nota) {
        this.nota = nota;
    }

    // Aplica o desconto, se houver, no subtotal do pedido

    public void aplicarDesconto() {
        this.precoTotal = getPrecoTotal() + (getPrecoTotal() * this.porcentagemDesconto) / 100;
    }

    // Gera a nota de compra

    public void gerarNotaDeCompra() {
        System.out.println("Id: " + this.identificador + "\n" +
                "Data de realização: " + this.dataDeRealizacao + "\n" +
                "Preço total: " + getPrecoTotal() + "\n" +
                "Desconto aplicado: " + this.porcentagemDesconto + "%" + "\n");
        mostraPedidos();

    }

    // Gera a nota de compra simplificada

    public void gerarNotaDeCompraSimplificada() {
        System.out.println("Id: " + this.identificador + "\n" +
                "Data de realização: " + this.dataDeRealizacao + "\n"
               );
    }

    // Mostra cada produto no pedido 

    public void mostraPedidos() {
        for (int i = 0; i <= numProdutos; i++) {
            System.out.println("Descrição: " + produtos.get(i).descricao() + "\n" + "Preço base: "
                    + produtos.get(i).getPrecoBase());
        }

    }

}
