import java.time.LocalDateTime;

public class Aplicacao{
public static void main(String args[]){
    Clientes cliente = new Clientes("Kanye West", "123456");
    cliente.setCategoria(Categoria.PRATA);

 
    Pedidos pedido = new Pedidos(cliente, LocalDateTime.now());
    pedido.produtos.add(new Cerveja());
    pedido.produtos.add(new Pizza());
    pedido.produtos.add(new Refrigerante());
    pedido.produtos.add(new Agua());
    pedido.produtos.add(new Sanduiche());

    Pedidos pedido2 = new Pedidos(cliente, LocalDateTime.now());
    pedido2.setNota(9.5);

    pedido.gerarNotaDeCompra();
    pedido.setNota(7);

    cliente.solicitarExtratoCompleto(pedido);

    // Checar pipelines de Notas De Pedido e Extrato Completo
    
    cliente.mostrarAvaliacaoMedia();


}
}