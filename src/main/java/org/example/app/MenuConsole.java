package org.example.app;

import org.example.cardapio.ItemCardapio;
import org.example.pedido.Pedido;

import java.util.Collection;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsole {

    static Scanner sc = new Scanner(System.in);

    static int opcao = -1;

    public static void exibirMenu() {

        System.out.println("=== RESTAURANTE ===");
        System.out.println("1 - Registrar novo pedido");
        System.out.println("2 - Listar pedidos do dia");
        System.out.println("3 - Fechar restaurante");
        System.out.println("4 - Cancelar pedido");
        System.out.println("0 - Sair");
        System.out.println("Escolha: ");

    }

    public static void lerOpcao() {

        //Scanner sc = new Scanner(System.in);

        // Tratamento de exceção para o caso de digitar letras em vez de números

        try {

            opcao = sc.nextInt();
            sc.nextLine();

        } catch (InputMismatchException e) {

            // System.out.println("Entrada inválida! Digite um número.");

            sc.nextLine(); // Descarta a entrada inválida e impede loop infinito

            opcao = -1000;

        }

    }

    public static String lerNomeCliente() {

        String nomeCliente;
        //Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        nomeCliente = sc.nextLine();
        return nomeCliente;

    }

    public static void mostrarMensagem(String mensagem) {

        System.out.println(mensagem);

    }

    public static void exibirCardapio() {

        System.out.println("=== CARDÁPIO ===");
        System.out.println("1 - X-Burger - R$ 16,00");
        System.out.println("2 - X-Salada - R$ 18,00");
        System.out.println("3 - X-Bacon - R$ 22,00");
        System.out.println("Escolha o lanche: ");
    }

    public static int lerOpcaoLanche() {

        try {

            int opcaoLanche = sc.nextInt();
            sc.nextLine();

            return opcaoLanche;

        } catch (InputMismatchException e) {

            sc.nextLine();
            return -1000;

        }
    }

    public static void mostrarPedidos(Collection<Pedido> pedidos) {

        if (pedidos.isEmpty()) {

            System.out.println("Nenhum pedido registrado!");

        } else {

            System.out.println("=== PEDIDOS DO DIA ===");

            for (Pedido pedido : pedidos) {

                System.out.println("Pedido: " + pedido.getNumero());
                System.out.println("Cliente: " + pedido.getNomeCliente());

                for (ItemCardapio item : pedido.getItens()) {

                    System.out.println("Lanche: " + item.getDescricao() + " - R$ " + item.getPreco());

                }

                System.out.println("Total: R$ " + pedido.calcularTotal());
                System.out.println("-------------------------");

            }
        }
    }

    public static void mostrarFechamento(int quantidadePedidos, double total) {

        System.out.println("=== FECHAMENTO DO RESTAURANTE ===");
        System.out.println("Quantidade de pedidos: " + quantidadePedidos);
        System.out.println("Total do dia: R$ " + total);

    }

    public static void exibirMenuAdicionais() {

        System.out.println("=== ADICIONAIS ===");
        System.out.println("1 - Cheddar - R$ 4,00");
        System.out.println("2 - Bacon extra - R$ 6,00");
        System.out.println("0 - Finalizar adicionais");
        System.out.println("Escolha: ");
    }

    public static int lerOpcaoAdicional() {

        try {

            int opcaoAdicional = sc.nextInt();
            sc.nextLine();

            return opcaoAdicional;

        } catch (InputMismatchException e) {

            sc.nextLine();
            return -1000;
        }
    }

    public static void exibirMenuIngredientes() {

        System.out.println("=== RETIRAR INGREDIENTES ===");
        System.out.println("1 - Retirar queijo");
        System.out.println("2 - Retirar alface");
        System.out.println("3 - Retirar tomate");
        System.out.println("4 - Retirar cebola");
        System.out.println("0 - Finalizar retirada de ingredientes");
        System.out.println("Escolha: ");
    }

    public static int lerOpcaoIngrediente() {

        try {
            int opcaoIngrediente = sc.nextInt();
            sc.nextLine();

            return opcaoIngrediente;

        } catch (InputMismatchException e) {
            sc.nextLine();
            return -1000;
        }
    }

    public static void exibirMenuNovoLanche() {
        System.out.println("Deseja adicionar outro lanche?");
        System.out.println("1 - Sim");
        System.out.println("0 - Não");
        System.out.println("Escolha: ");
    }

    public static int lerOpcaoNovoLanche() {

        try {

            int opcaoNovoLanche = sc.nextInt();
            sc.nextLine();
            return opcaoNovoLanche;

        } catch (InputMismatchException e) {

            sc.nextLine();
            return -1000;

        }
    }

    public static void exibirItensPedido(Pedido pedido) {

        System.out.println("=== ITENS DO PEDIDO ===");

        int numero = 1;

        for (ItemCardapio item : pedido.getItens()) {

            System.out.println(numero + " - " + item.getDescricao());
            numero++;

        }
    }

    public static int lerItemRemover() {

        try {

            int opcao = sc.nextInt();
            sc.nextLine();
            return opcao;

        } catch (InputMismatchException e) {

            sc.nextLine();
            return -1000;

        }
    }

    public static void exibirMenuPedido() {

        System.out.println("=== GERENCIAR PEDIDO ===");
        System.out.println("1 - Adicionar outro lanche");
        System.out.println("2 - Remover um lanche");
        System.out.println("0 - Finalizar pedido");
        System.out.println("Escolha: ");

    }

    public static int lerOpcaoPedido() {

        try {

            int opcaoPedido = sc.nextInt();
            sc.nextLine();

            return opcaoPedido;

        } catch (InputMismatchException e) {

            sc.nextLine();
            return -1000;
        }
    }

    public static int lerNumeroPedido() {

        System.out.println("Digite o número do pedido que deseja cancelar:");

        try {

            int numero = sc.nextInt();
            sc.nextLine();

            return numero;

        } catch (InputMismatchException e) {

            sc.nextLine();
            return -1000;

        }
    }

    public static void mostrarCombinacoes(HashSet<String> combinacoes) {

        System.out.println("=== COMBINAÇÕES ÚNICAS ===");

        for (String combinacao : combinacoes) {

            System.out.println(combinacao);

        }

        System.out.println("Quantidade de combinações únicas: " + combinacoes.size());

    }





    }






