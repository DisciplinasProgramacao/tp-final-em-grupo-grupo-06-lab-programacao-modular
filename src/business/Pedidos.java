
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

    /**
     * Método utilizado para obter o preço total do pedido
     * @return o preço total do pedido
     */

    public double getPrecoTotal() {
        double precoTotal = produtos.stream()
                .mapToDouble(p -> p.getPrecoTotal())
                .reduce(0, (n, m) -> n + m);
        
        precoTotal = precoTotal - (precoTotal * cliente.categoria.desconto());

        this.precoTotal = precoTotal;
        return precoTotal;
    }

    /**
     * Método utilizado para obter a nota do pedido
     * @return a nota que o cliente atribuiu ao pedido
     */

    public double getNota() {
        return nota;
    }

    /**
     * Método utilizado para definir uma nota ao pedido
     * @param nota : Nota que o cliente deseja atribuir ao pedido
     */

    public void setNota(double nota) {
        this.nota = nota;
    }

    /**
     * Método utilizado para gerar nota de compra (recibo) do pedido
     * @return nota de compra do cliente contendo data do pedido, desconto aplicado e todos os produtos do pedido
     */

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

    /**
     * Método utilizado para obter a nota de compra simplificada (recibo), contendo identificador do pedido e data de realização
     * @return string com id e data do pedido
     */

    public  String gerarNotaDeCompraSimplificada() {
        String str = "Id: " + this.identificador + "\n" +
                "Data de realização: " + this.dataDeRealizacao + "\n";
                return str;
    }

    /**
     * Método utilizado para mostrar todos os produtos contidos no pedido
     * @return string contendo descrição de todos os produtos do pedido
     */

    public String mostraPedidos() {
        String str = "\n";
        for (int i = 0; i <= produtos.size() - 1; i++) {
            str += produtos.get(i).descricao();
        }

        return str;

    }

}
