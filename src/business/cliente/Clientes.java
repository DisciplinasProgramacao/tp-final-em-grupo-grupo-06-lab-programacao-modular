package cliente;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import pedido.Pedidos;
import produtos.Categoria;

public class Clientes implements Serializable {
    private String nome;
    private String cpf;
    protected Categoria categoria;

    private List<Pedidos> pedidos = new ArrayList<Pedidos>();

    public Clientes(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.categoria = Categoria.BRANCO;
    }

    public void addPedido(Pedidos pedido) {
        this.pedidos.add(pedido);
        if ( pedidos.size() >= 4 && pedidos.size() < 10 && dinheiroMes(1,100)) {
            setCategoria(Categoria.PRATA);
        } else if (pedidos.size() >= 10 && pedidos.size() < 50 && dinheiroMes(2,250)) {
            setCategoria(Categoria.PRETO);
        } else if (pedidos.size() >= 50 && dinheiroMes(6,600)) {
            setCategoria(Categoria.FV);
        }

    }
    private boolean dinheiroMes(int meses, double dinheiro){
        double money = this.pedidos.stream()
        .filter(ped -> ped.getDataRealizacao().isAfter(LocalDateTime.now().minusMonths(meses)))
        .mapToDouble(d -> d.getPrecoTotal())
        .reduce(0,(a,b) -> a+b);
        
        return money >= dinheiro;
    }

    public List<Pedidos> getProdutos() {
        return this.pedidos;
    }

    /**
     * Método utilizado para obter o nome do cliente
     * 
     * @return o nome do cliente
     */

    public String getNome() {
        return nome;
    }

    /**
     * Método utilizado para obter o cpf do cliente
     * 
     * @return o cpf do cliente
     */

    public String getCpf() {
        return cpf;
    }

    /**
     * Método utilizado para definir categoria do cliente
     * 
     * @param categoria : Categoria a que o cliente pertence
     */

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    /**
     * Método utilizado para obter a avaliação média das notas que o cliente
     * atribuiu aos seus pedidos
     * 
     * @return uma string contendo a nota média
     */

    public String mostrarAvaliacaoMedia() {
        String str;
        double notaMedia = (double) pedidos.stream()
                .mapToDouble(Pedidos::getNota)
                .average()
                .orElse(Double.NaN);

        str = "Avaliação média: " + notaMedia;

        return str;
    }

    /**
     * Método utilizado para obter um extrato simplificado de todos os pedidos do
     * cliente
     */

    public void solicitarExtratoSimplificado() {
        pedidos.stream()
                .forEach(n -> n.gerarNotaDeCompraSimplificada());

    }

    /**
     * Método utilizado para obter o extrato completo de um determinado pedido
     * 
     * @param pedido : pedido específico para obter extrato
     */

    public void solicitarExtratoCompleto(Pedidos pedido) {
        Pedidos pedidoEncontrado = (Pedidos) pedidos.get(pedidos.indexOf(pedido));

        /*
         * .stream()
         * .filter(n -> n.equals(pedido))
         * .get();
         */

        pedidoEncontrado.gerarNotaDeCompra();
    }

}
