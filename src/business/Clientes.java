import java.util.ArrayList;

public class Clientes {
    private String nome;
    private String cpf;
    protected Categoria categoria; 

    private ArrayList<Pedidos> pedidos;
    
    // Cliente atribui uma nota a um determinado produto 

    public Clientes(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;;
    }


    // Getters

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    // Setters

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Cliente atribui uma nota ao pedido

    public void atribuirNota(Pedidos pedido, double notaPedido){
        pedido.setNota(notaPedido);
        
    }

    // Mostra nota média das avaliações do cliente

    public void mostrarAvaliacaoMedia(){
        double notaMedia = (double) pedidos.stream()
        .mapToDouble(Pedidos::getNota)
        .average()
        .orElse(Double.NaN);

        System.out.println("Avaliação média: " + notaMedia);
    }

    // Mostra extrato simplificado de todos os seus pedidos

    public void solicitarExtratoSimplificado(){
        pedidos.stream()
        .forEach(n -> n.gerarNotaDeCompraSimplificada());

    }

    // Mostra extrato completo de um pedido específico

    public void solicitarExtratoCompleto(Pedidos pedido){
        Pedidos pedidoEncontrado = (Pedidos) pedidos.stream()
        .filter(n -> n.equals(pedido));

        pedidoEncontrado.gerarNotaDeCompra();
    }
    
}
