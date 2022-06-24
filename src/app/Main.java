
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Adicionais.Adicional;
import cliente.Clientes;
import dao.ClientesDAO;
import dao.DAO;
import pedido.Pedidos;
import produtos.Agua;
import produtos.Categoria;
import produtos.Cerveja;
import produtos.Pizza;
import produtos.PratoFeito;
import produtos.Refrigerante;
import produtos.Sanduiche;
import produtos.Suco;
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
         
         Pedidos pedido2 = new Pedidos(cliente, LocalDateTime.now());
         pedido2.setNota(9.5);
         
         System.out.println(pedido.gerarNotaDeCompra());
         pedido.setNota(7);
         

        DAO<Clientes, String> clientesDao = new ClientesDAO("data/Clientes.bin");
        clientesDao.add(new Clientes("Cliente", "999.999.999-99"));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));
        clientesDao.add(new Clientes(Utilitario.gerarNome(), Utilitario.gerarCPF()));

        println("Carregando clientes...");
        List<Clientes> listaClientes = clientesDao.getAll();
        HashMap<String, Clientes> clientes = new HashMap<String, Clientes>();

        for (Clientes c : listaClientes) {
            clientes.put(c.getCpf(), c);
            println(c.getCpf());
        }
       
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do {
            println("\tRestaurante/MinhaConta");
            println("1. Listar Clientes");
            println("2. Selecionar CLiente");
            println("0. Encerrar");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    ListarClientes(clientes);
                    break;
                case 2:
                    SelecionarCliente(clientes);
                    break;
                case 0:
                    print("Salvando...Encerrando...");
                    break;
                default:
                    limparConsole();
            }

        } while (opcao != 0);
        
         for( int i = 0 ; i < clientes.size() ;i++ ){
          clientesDao.add(clientes.get(i));
         }
         
    }

    public static void print(String s) {
        System.out.print(s);
    }

    public static void println(String s) {
        System.out.println(s);
    }

    public static void limparConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void cardapio() {
        limparConsole();
        System.out.println(
                "-----------------------------" +
                        "--- Alimentos ---\n" +
                        "1. Pizza  R$ 25,00 \n" +
                        "2. Sanduíche  R$ 12,00 \n" +
                        "3. Prato Feito  R$ 15,00 \n" +
                        "--- Bebidas ---\n" +
                        "4. Água  R$ 2,00 \n" +
                        "5. Suco  R$ 5,00 \n" +
                        "6. Refrigerante  R$ 5,00 \n" +
                        "7. Cerveja  R$ 8,00 \n" +
                        "--- Adicionais ---\n" +
                        "Pepperoni  R$ 4,00 \n" +
                        "Bacon  R$ 3,00\n" +
                        "Palmito  R$ 3,00\n" +
                        "Queijo  R$ 2,00\n" +
                        "Picles  R$ 2,00\n" +
                        "Ovo  R$ 2,00\n" +
                        "Batata Palha  R$ 2,00\n" +
                        "--- Extras ---\n" +
                        "Borda Recheada (Pizza)  R$ 8,00\n" +
                        "Pão Artesanal (Sanduiche)  R$ 2,00\n" +
                        "-----------------------------");
    }

    /**
     * Método utilizado para obter dados do cliente (nome, cpf e número de pedidos)
     */
    public static void ListarClientes(HashMap<String, Clientes> clientes) {
        String str = String.format("| %-15s | %-25s |\n", "CPF", "Nome");
        str += clientes.values().stream()
                .map(cliente -> String.format("| %-15s | %-25s |\n", cliente.getCpf(), cliente.getNome()))
                .reduce((a, b) -> a.concat(b))
                .get();

        print(str);
    }

    public static void SelecionarCliente(HashMap<String, Clientes> clientes) {

        print("Digite o CPF do cliente(Com formatação: 000.000.000-00): ");
        Scanner entrada = new Scanner(System.in);
        String CPF = entrada.next();
        menuCliente(clientes.get(CPF));

    }

    public static void menuCliente(Clientes cliente) {
        String str = String.format("| %-15s | %-25s |\n", "CPF", "Nome");
        str += String.format("| %-15s | %-25s |\n", cliente.getCpf(), cliente.getNome());
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do {
            println("\tRestaurante/MinhaConta");
            println("1. Solicitar Extrato Simplificado");
            println("2. Mostrar Avaliação Média");
            println("3. Fazer Pedido");
            println("0. Voltar");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cliente.solicitarExtratoSimplificado();
                    break;

                case 2:
                    println("Avaliação Média: " + cliente.mostrarAvaliacaoMedia());
                    break;

                case 3:
                    IniciarRotinaDePedido(cliente);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    public static void IniciarRotinaDePedido(Clientes cliente) {
        cardapio();
        String str = String.format("| %-15s | %-25s |\n", "CPF", "Nome");
        str += String.format("| %-15s | %-25s |\n", cliente.getCpf(), cliente.getNome());

        println("Para encerrar a montagem de pedido, digite 0");
        Pedidos novoPedido = new Pedidos(cliente, LocalDateTime.now());
        int opcao;
        Scanner entrada = new Scanner(System.in);
        do {
            print("\nProduto: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    novoPedido.getProdutos().add(new Pizza());
                    break;
                case 2:
                    novoPedido.getProdutos().add(new Sanduiche());
                    break;
                case 3:
                    novoPedido.getProdutos().add(new PratoFeito());
                    break;
                case 4:
                    novoPedido.getProdutos().add(new Agua());
                    break;
                case 5:
                    novoPedido.getProdutos().add(new Suco());
                case 6:
                    novoPedido.getProdutos().add(new Refrigerante());
                    break;
                case 7:
                    novoPedido.getProdutos().add(new Cerveja());
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            println("Adicionado com sucesso");

        } while (opcao != 0);
        cliente.addPedido(novoPedido);

    }
}