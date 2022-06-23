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


    /**
     * Método utilizado para obter o nome do cliente
     * @return o nome do cliente
     */

    public String getNome() {
        return nome;
    }

    /**
     * Método utilizado para obter o cpf do cliente
     * @return o cpf do cliente
     */

    public String getCpf() {
        return cpf;
    }

    /**
     * Método utilizado para definir categoria do cliente
     * @param categoria : Categoria a que o cliente pertence
     */

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Método utilizado para obter a avaliação média das notas que o cliente atribuiu aos seus pedidos
     * @return uma string contendo a nota média
     */

    public String mostrarAvaliacaoMedia(){
        String str;
        double notaMedia = (double) pedidos.stream()
        .mapToDouble(Pedidos::getNota)
        .average()
        .orElse(Double.NaN);

        str = "Avaliação média: " + notaMedia;
        
        return str;
    }

    /**
     * Método utilizado para obter um extrato simplificado de todos os pedidos do cliente
     */

    public void solicitarExtratoSimplificado(){
        pedidos.stream()
        .forEach(n -> n.gerarNotaDeCompraSimplificada());

    }

    /**
     * Método utilizado para obter o extrato completo de um determinado pedido
     * @param pedido : pedido específico para obter extrato
     */

    public void solicitarExtratoCompleto(Pedidos pedido){
        Pedidos pedidoEncontrado = (Pedidos) pedidos.get(pedidos.indexOf(pedido));
        
        /* 
        .stream()
        .filter(n -> n.equals(pedido))
        .get();*/

        pedidoEncontrado.gerarNotaDeCompra();
    }
    
}
