package org.example.app;

import org.example.cardapio.*;
// import org.example.cardapio.Lanche;
import org.example.pedido.GerenciadorPedidos;
import org.example.pedido.Pedido;

import java.util.Collection;
import java.util.HashSet;

public class RestauranteFacade {

    private GerenciadorPedidos gp;

    public RestauranteFacade() {

        this.gp = new GerenciadorPedidos();

    }

    public Pedido criarPedido(String nomeCliente) {

        return gp.criarPedido(nomeCliente);

    }

    /*

    public void adicionarLanche(Pedido pedido, Lanche lanche) {

        pedido.adicionarItem(lanche);

    }


    */

    public Lanche criarLanche(int opcao) {

        switch (opcao) {

            case 1:
                return LancheFactory.xBurger();

            case 2:
                return LancheFactory.xSalada();

            case 3:
                return LancheFactory.xBacon();

            default:
                throw new IllegalArgumentException("Lanche inválido!");
        }

    }

    public void adicionarLanche(Pedido pedido, ItemCardapio item) {

        pedido.adicionarItem(item);

    }

    public double calcularTotalDoDia() {

        return gp.calcularTotalDoDia();

    }

    public Collection<Pedido> listarPedidos() {

        return gp.getPedidos();

    }

    public int contarPedidos() {

        return gp.getPedidos().size();

    }

    public ItemCardapio adicionarAdicional(ItemCardapio lanche, int opcao) {

        switch (opcao) {
            case 1:
                return new ComCheddar(lanche);

            case 2:
                return new ComBaconExtra(lanche);

            default:
                throw new IllegalArgumentException("Adicional inválido!");
        }
    }

    public void retirarIngrediente(Lanche lanche, int opcao) {

        switch (opcao) {
            case 1:
                lanche.setQueijo(false);
                break;

            case 2:
                lanche.setAlface(false);
                break;

            case 3:
                lanche.setTomate(false);
                break;

            case 4:
                lanche.setCebola(false);
                break;

            default:
                throw new IllegalArgumentException("Ingrediente inválido!");
        }
    }

    public void removerItem(Pedido pedido, int indice) {

        pedido.removerItem(indice);

    }

    public void cancelarPedido(int numero) {

        gp.cancelarPedido(numero);

    }

    public HashSet<String> obterCombinacoesUnicas() {

        return gp.obterCombinacoesUnicas();

    }

}
