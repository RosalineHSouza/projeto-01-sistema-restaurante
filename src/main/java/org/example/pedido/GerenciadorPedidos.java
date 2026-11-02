package org.example.pedido;

import org.example.cardapio.ItemCardapio;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class GerenciadorPedidos {

    private HashMap<Integer, Pedido> pedidos = new HashMap<>();
    private int contadorPedidos = 1;

    public Pedido criarPedido(String nomeCliente) {

        Pedido novo = new Pedido(contadorPedidos, nomeCliente);
        pedidos.put(novo.getNumero(), novo);
        contadorPedidos++;
        return novo;

    }

    public Pedido buscarPedido(int numero) {

        return pedidos.get(numero);

    }

    public Collection<Pedido> getPedidos() {

        return pedidos.values();

    }

    public double calcularTotalDoDia() {

        double total = 0;

        for (Pedido p : pedidos.values()) {

            total += p.calcularTotal();
        }

        return total;
    }

    public void cancelarPedido(int numero) {

        if (pedidos.containsKey(numero)) {

            pedidos.remove(numero);

        } else {

            throw new IllegalArgumentException("Pedido não encontrado!");

        }
    }

    public HashSet<String> obterCombinacoesUnicas() {

        HashSet<String> combinacoes = new HashSet<>();

        for (Pedido pedido : pedidos.values()) {

            for (ItemCardapio item : pedido.getItens()) {

                combinacoes.add(item.getDescricao());
            }
        }

        return combinacoes;
    }



}
