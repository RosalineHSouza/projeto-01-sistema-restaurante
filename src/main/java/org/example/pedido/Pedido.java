package org.example.pedido;

import org.example.cardapio.ItemCardapio;
// import org.example.cardapio.Lanche;

import java.util.ArrayList;

public class Pedido {

    private int numero;
    private String nomeCliente;
    //private ArrayList<Lanche> itens;
    private ArrayList<ItemCardapio> itens;

    public Pedido(int numero, String nomeCliente) {
        this.numero = numero;
        setNomeCliente(nomeCliente);
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemCardapio item) {

        itens.add(item);
    }

    public void removerItem(int indice) {

        if (indice >= 0 && indice < itens.size()) {

            itens.remove(indice);

        } else {

            throw new IllegalArgumentException("Índice do item inválido!");

        }
    }

    public int getNumero() {

        return numero;
    }

    public void setNumero(int numero) {

        this.numero = numero;
    }

    public String getNomeCliente() {

        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {

        if (nomeCliente != null && !nomeCliente.trim().isEmpty()) {

            this.nomeCliente = nomeCliente;

        } else {

            throw new IllegalArgumentException("Nome do cliente inválido!");

        }
    }

    public ArrayList<ItemCardapio> getItens() {

        return itens;
    }

    /*

    public void setItens(ArrayList<ItemCardapio> itens) {

        this.itens = itens;
    }


    */

    public double calcularTotal() {

        double totalPedido = 0;

        for (ItemCardapio item : itens) {

            totalPedido += item.getPreco();

        }

            return totalPedido;

        }

    }





