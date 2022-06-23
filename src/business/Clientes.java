import java.util.ArrayList;
import java.util.List;

import produtos.Categoria;

public class Clientes {
    private String nome;
    private String cpf;
    protected Categoria categoria; 

    List<Pedidos> pedidos = new ArrayList<Pedidos>();
    

    public Clientes(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.categoria = Categoria.BRANCO;
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
        Pedidos pedidoEncontrado = (Pedidos) pedidos.get(pedidos.indexOf(pedido));
        
        /* 
        .stream()
        .filter(n -> n.equals(pedido))
        .get();*/

        pedidoEncontrado.gerarNotaDeCompra();
    }
    
}
