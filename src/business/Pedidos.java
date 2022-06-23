
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import produtos.Produtos;

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

    public String gerarNotaDeCompra() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String str = String.format(
            
        "| %-25s %-10s |\n| %-25s %-10s |\n| %-25s %-10s |\n| %-35s |",
        "Data de Realização:",this.dataDeRealizacao.format(dtf),
         "Preço total:",getPrecoTotal(),
          "Desconto aplicado:",this.cliente.categoria.desconto()*100+"%",
          "------------------------------------"
        
        );

        str += mostraPedidos();

        return str;

    }

    // Gera a nota de compra simplificada

    public  String gerarNotaDeCompraSimplificada() {
        String str = "Id: " + this.identificador + "\n" +
                "Data de realização: " + this.dataDeRealizacao + "\n";
                return str;
    }

    // Mostra cada produto no pedido 

    public String mostraPedidos() {
        String str = "\n";
        for (int i = 0; i <= produtos.size() - 1; i++) {
            str += produtos.get(i).descricao();
        }

        return str;

    }

}
