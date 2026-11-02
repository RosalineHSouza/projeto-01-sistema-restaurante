package org.example.app;

import org.example.cardapio.ItemCardapio;
import org.example.cardapio.Lanche;
import org.example.pedido.Pedido;

public class Main {

    public static void main(String[] args) {

        RestauranteFacade restaurante = new RestauranteFacade();

        while (MenuConsole.opcao != 0) {

            MenuConsole.exibirMenu();

            MenuConsole.lerOpcao();

            switch (MenuConsole.opcao) {


                case 1:

                    String nomeCliente = MenuConsole.lerNomeCliente();

                    Pedido pedido = restaurante.criarPedido(nomeCliente);

                    int opcaoPedido = 1;

                    while (opcaoPedido != 0) {

                        if (opcaoPedido == 1) {

                            // ADICIONAR LANCHE

                            MenuConsole.exibirCardapio();

                            int opcaoLanche = MenuConsole.lerOpcaoLanche();

                            if (opcaoLanche >= 1 && opcaoLanche <= 3) {

                                Lanche lancheOriginal = restaurante.criarLanche(opcaoLanche);

                                int opcaoIngrediente = -1;

                                while (opcaoIngrediente != 0) {

                                    MenuConsole.exibirMenuIngredientes();

                                    opcaoIngrediente = MenuConsole.lerOpcaoIngrediente();

                                    if (opcaoIngrediente >= 1 && opcaoIngrediente <= 4) {

                                        restaurante.retirarIngrediente(
                                                lancheOriginal, opcaoIngrediente
                                        );

                                        MenuConsole.mostrarMensagem("Ingrediente retirado!");

                                    } else if (opcaoIngrediente != 0) {

                                        MenuConsole.mostrarMensagem(
                                                "Opção de ingrediente inválida!"
                                        );
                                    }
                                }

                                ItemCardapio lanche = lancheOriginal;

                                int opcaoAdicional = -1;

                                while (opcaoAdicional != 0) {

                                    MenuConsole.exibirMenuAdicionais();

                                    opcaoAdicional = MenuConsole.lerOpcaoAdicional();

                                    if (opcaoAdicional >= 1 && opcaoAdicional <= 2) {

                                        lanche = restaurante.adicionarAdicional(
                                                lanche, opcaoAdicional
                                        );

                                        MenuConsole.mostrarMensagem("Adicional incluído!");

                                    } else if (opcaoAdicional != 0) {

                                        MenuConsole.mostrarMensagem(
                                                "Opção de adicional inválida!"
                                        );
                                    }
                                }

                                restaurante.adicionarLanche(pedido, lanche);

                                MenuConsole.mostrarMensagem(
                                        "Lanche adicionado: " + lanche.getDescricao()
                                );

                                MenuConsole.mostrarMensagem(
                                        "Total parcial: R$ " + pedido.calcularTotal()
                                );

                            } else {

                                MenuConsole.mostrarMensagem("Opção de lanche inválida!");
                            }

                        } else if (opcaoPedido == 2) {

                            // REMOVER LANCHE

                            if (pedido.getItens().isEmpty()) {

                                MenuConsole.mostrarMensagem("O pedido não possui itens!");

                            } else {

                                MenuConsole.exibirItensPedido(pedido);

                                MenuConsole.mostrarMensagem("Digite o número do item que deseja remover:");

                                int posicao = MenuConsole.lerItemRemover();

                                if (posicao >= 1 && posicao <= pedido.getItens().size()) {

                                    restaurante.removerItem(pedido, posicao - 1);

                                    MenuConsole.mostrarMensagem("Item removido!");

                                    MenuConsole.mostrarMensagem(
                                            "Novo total: R$ " + pedido.calcularTotal()
                                    );

                                } else {

                                    MenuConsole.mostrarMensagem("Item inválido!");
                                }
                            }
                        }

                        // MENU DE GERENCIAMENTO DO PEDIDO

                        MenuConsole.exibirMenuPedido();

                        opcaoPedido = MenuConsole.lerOpcaoPedido();

                        while (opcaoPedido != 0 && opcaoPedido != 1 && opcaoPedido != 2) {

                            MenuConsole.mostrarMensagem("Opção inválida!");

                            MenuConsole.exibirMenuPedido();

                            opcaoPedido = MenuConsole.lerOpcaoPedido();
                        }
                    }

                    /*

                    MenuConsole.mostrarMensagem(
                            "Pedido criado: " + pedido.getNumero()
                    );

                    MenuConsole.mostrarMensagem(
                            "Total do pedido: R$ " + pedido.calcularTotal()
                    );

                    */

                    // IMPEDIR O REGISTRO DE PEDIDOS VAZIOS

                    if (pedido.getItens().isEmpty()) {

                        restaurante.cancelarPedido(pedido.getNumero());

                        MenuConsole.mostrarMensagem("Pedido vazio! Registro cancelado.");

                    } else {

                        MenuConsole.mostrarMensagem("Pedido criado: " + pedido.getNumero());

                        MenuConsole.mostrarMensagem("Total do pedido: R$ " + pedido.calcularTotal());
                    }

                    break;

                case 2:

                    MenuConsole.mostrarPedidos(restaurante.listarPedidos());

                    break;

                case 3:

                    MenuConsole.mostrarFechamento(restaurante.contarPedidos(),restaurante.calcularTotalDoDia());
                    MenuConsole.mostrarCombinacoes(restaurante.obterCombinacoesUnicas());

                    // FECHAR O RESTAURANTE E O SISTEMA

                    MenuConsole.opcao = 0;

                    break;

                case 4:

                    int numeroPedido = MenuConsole.lerNumeroPedido();

                    if (numeroPedido > 0) {

                        try {

                            restaurante.cancelarPedido(numeroPedido);

                            MenuConsole.mostrarMensagem("Pedido cancelado com sucesso!");

                        } catch (IllegalArgumentException e) {

                            MenuConsole.mostrarMensagem(e.getMessage());
                        }

                    } else {

                        MenuConsole.mostrarMensagem("Número do pedido inválido!");
                    }

                    break;

                case 0:

                    MenuConsole.mostrarMensagem("Encerrando...");
                    break;

                case -1000:

                    MenuConsole.mostrarMensagem("Entrada inválida! Digite um número.");
                    break;

                default:

                    MenuConsole.mostrarMensagem("Opção inexistente! Digite novamente.");






            }

        }

    }

}
