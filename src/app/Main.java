
import java.io.IOException;
import java.time.LocalDateTime;

import Adicionais.Adicional;
import cliente.Clientes;
import dao.ClientesDAO;
import dao.DAO;
import pedido.Pedidos;
import produtos.Agua;
import produtos.Categoria;
import produtos.Cerveja;
import produtos.Pizza;
import produtos.Refrigerante;
import produtos.Sanduiche;
import utils.Utilitario;


public class Main {
    public static void main(String args[]) throws IOException {
        Clientes cliente = new Clientes("Kanye West", "123456");
        cliente.setCategoria(Categoria.PRATA);

        Pedidos pedido = new Pedidos(cliente, LocalDateTime.now());
        
        pedido.getProdutos().add(new Cerveja());
        pedido.getProdutos().add(new Refrigerante());
        pedido.getProdutos().add(new Agua());
        Pizza pizza = new Pizza();
        pizza.adicionarAdicional(Adicional.OVO);
        pizza.adicionarAdicional(Adicional.BACON);
        pizza.adicionarAdicional(Adicional.BATATA_PALHA);
        pizza.adicionarAdicional(Adicional.PALMITO);
        pizza.adicionarAdicional(Adicional.PEPERONI);
        pizza.adicionarAdicional(Adicional.PICLES);
        pizza.adicionarAdicional(Adicional.QUEIJO);
        pedido.getProdutos().add(pizza);

        Sanduiche sanduiche = new Sanduiche();
        sanduiche.adicionarAdicional(Adicional.OVO);
        sanduiche.adicionarAdicional(Adicional.BACON);
        sanduiche.adicionarAdicional(Adicional.BATATA_PALHA);
        sanduiche.adicionarAdicional(Adicional.PALMITO);
        sanduiche.adicionarAdicional(Adicional.PEPERONI);
        sanduiche.adicionarAdicional(Adicional.PICLES);
        sanduiche.adicionarAdicional(Adicional.QUEIJO);
        pedido.getProdutos().add(sanduiche);
        cliente.addPedido(pedido);
        
        Pizza pizzaExtra = new Pizza();
        pizzaExtra.addExtra();
        pedido.getProdutos().add(pizzaExtra);

        Sanduiche sanduicheExtra = new Sanduiche();
        sanduicheExtra.addExtra();
        pedido.getProdutos().add(sanduicheExtra);


        // pedido.produtos.add();

        Pedidos pedido2 = new Pedidos(cliente, LocalDateTime.now());
        pedido2.setNota(9.5);

        System.out.println(pedido.gerarNotaDeCompra());
        pedido.setNota(7);

        DAO<Clientes, String> clientesDao = new ClientesDAO("data/Clientes.bin");

        clientesDao.add(new Clientes(Utilitario.gerarNome(),Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(),Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(),Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(),Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(),Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(),Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(),Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(),Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(),Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(),Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(),Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(),Utilitario.gerarCPF()));
        /*
         * cliente.solicitarExtratoCompleto(pedido);
         * 
         * // Checar pipelines de Notas De Pedido e Extrato Completo
         * 
         * cliente.mostrarAvaliacaoMedia();
         */

         

    }
}