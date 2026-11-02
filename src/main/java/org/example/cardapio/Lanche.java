package org.example.cardapio;

//public class Lanche {

public class Lanche implements ItemCardapio {

    private String nome;
    private double preco;

    private boolean queijo = true;
    private boolean alface = true;
    private boolean tomate = true;
    private boolean cebola = true;

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        if (nome != null && !nome.trim().isEmpty()) {

            this.nome = nome;

        } else {

            throw new IllegalArgumentException("Nome inválido!");
        }
    }

    @Override
    public double getPreco() {

        return preco;
    }

    public void setPreco(double preco) {

        if (preco >= 0) {

            this.preco = preco;

        } else {

            throw new IllegalArgumentException("Preço inválido!");
        }


    }

    public Lanche(String nome, double preco) {

        setNome(nome);
        setPreco(preco);

    }

    @Override
    public String getDescricao() {

        String descricao = nome;

        if (!queijo) {

            descricao += " sem queijo";

        }

        if (!alface) {

            descricao += " sem alface";

        }

        if (!tomate) {

            descricao += " sem tomate";

        }

        if (!cebola) {

            descricao += " sem cebola";

        }

        return descricao;

    }

    public boolean isQueijo() {

        return queijo;
    }

    public void setQueijo(boolean queijo) {

        this.queijo = queijo;

    }

    public boolean isAlface() {

        return alface;

    }

    public void setAlface(boolean alface) {

        this.alface = alface;

    }

    public boolean isTomate() {

        return tomate;

    }

    public void setTomate(boolean tomate) {

        this.tomate = tomate;

    }

    public boolean isCebola() {

        return cebola;

    }

    public void setCebola(boolean cebola) {

        this.cebola = cebola;

    }

}
