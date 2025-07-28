package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    Set<Produto> produtoSet = new HashSet<>();

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
        Produto produto = new Produto(codigo, nome, preco, quantidade);
        this.produtoSet.add(produto);
    }

    public Set<Produto> exibirProdutosPorNome() {
        return new TreeSet<>(this.produtoSet);
    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtoSet = new TreeSet<>(new ProdutoComparator());
        produtoSet.addAll(this.produtoSet);
        return produtoSet;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();
        cadastroProdutos.adicionarProduto(1, "Notebook", 5000.0, 5);
        cadastroProdutos.adicionarProduto(2, "Smartphone", 3000.0, 10);
        cadastroProdutos.adicionarProduto(3, "Tablet", 2000.0, 8);
        cadastroProdutos.adicionarProduto(4, "Impressora", 1500.0, 4);
        cadastroProdutos.adicionarProduto(5, "Monitor", 800.0, 12);
        cadastroProdutos.adicionarProduto(6, "Teclado", 300.0, 6);
        cadastroProdutos.adicionarProduto(7, "Mouse", 200.0, 9);

        System.out.println("Produtos por nome:");
        System.out.println(cadastroProdutos.exibirProdutosPorNome());

        System.out.println("\nProdutos por preço:");
        System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    }
}
