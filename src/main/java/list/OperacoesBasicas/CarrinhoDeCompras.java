package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        for (Item item : this.itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                itensParaRemover.add(item);
            }
        }
        this.itens.removeAll(itensParaRemover);
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : this.itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    public void exibirItens() {
        System.out.println(this.itens);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        System.out.println("Total: " + carrinho.calcularTotal());

        carrinho.adicionarItem(new Item("Item 1", 10.0, 2));
        carrinho.adicionarItem(new Item("Item 2", 20.0, 1));
        carrinho.adicionarItem(new Item("Item 3", 30.0, 3));

        carrinho.removerItem("Item 2");
        carrinho.exibirItens();
        System.out.println("Total: " + carrinho.calcularTotal());
    }
}
