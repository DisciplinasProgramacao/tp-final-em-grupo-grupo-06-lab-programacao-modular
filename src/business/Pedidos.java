import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedidos {
    // Constantes
    private static final int MAX_PRODUTOS = 10;
    // Atributos
    private static int auxID = 0;
    private int identificador;
    private Clientes cliente;
    private LocalDateTime dataDeRealizacao;
    private double precoTotal;
    private double porcentagemDesconto;
    private double nota;

    List<Produtos> produtos = new ArrayList<Produtos>(MAX_PRODUTOS);

    public Pedidos(Clientes cliente, LocalDateTime dataProduto) {
        this.cliente = cliente;
        this.dataDeRealizacao = dataProduto;
        this.identificador = ++auxID;

        cliente.pedidos.add(this);
    }

    public Pedidos(Clientes cliente, LocalDateTime dataProduto, double desconto) {
        this.cliente = cliente;
        this.identificador = ++auxID;
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

    // Gera a nota de compra

    public void gerarNotaDeCompra() {
        System.out.println("Id: " + this.identificador + "\n" +
                "Data de realização: " + this.dataDeRealizacao + "\n" +
                "Preço total: " + getPrecoTotal() + "\n" +
                "Desconto aplicado: " + this.cliente.categoria.desconto() * 100 + "%" + "\n");
        
        System.out.println("========= Produtos do Pedido ==========");
        mostraPedidos();
        System.out.println("=======================================");

    }

    // Gera a nota de compra simplificada

    public void gerarNotaDeCompraSimplificada() {
        System.out.println("Id: " + this.identificador + "\n" +
                "Data de realização: " + this.dataDeRealizacao + "\n"
               );
    }

    // Mostra cada produto no pedido 

    public void mostraPedidos() {
        for (int i = 0; i <= produtos.size() - 1; i++) {
            System.out.println("Descrição: " + produtos.get(i).descricao() + "\n" + "Preço base: "
                    + produtos.get(i).getPrecoBase());
        }

    }

}
