package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap = new HashMap<>();

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
        Produto produto = new Produto(nome, preco, quantidade);
        this.estoqueProdutosMap.put(codigo, produto);
    }

    public void exibirProdutos() {
        System.out.println(this.estoqueProdutosMap);
    }

    public Double calcularValorTotalEstoque() {
        double valorTotal = 0d;
        if (!this.estoqueProdutosMap.isEmpty()) {
            for (Produto produto : this.estoqueProdutosMap.values()) {
                valorTotal += produto.getPreco() * produto.getQuantidade();
            }
        }
        return valorTotal;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (!this.estoqueProdutosMap.isEmpty()) {
            for (Produto produto : this.estoqueProdutosMap.values()) {
                if (produto.getPreco() > maiorPreco) {
                    produtoMaisCaro = produto;
                    maiorPreco = produto.getPreco();
                }
            }
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if (!this.estoqueProdutosMap.isEmpty()) {
            for (Produto produto : this.estoqueProdutosMap.values()) {
                if (produto.getPreco() < menorPreco) {
                    produtoMaisBarato = produto;
                    menorPreco = produto.getPreco();
                }
            }
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorQuantidadeValorTotal = null;
        double maiorQuantidadeValorTotal = Double.MIN_VALUE;
        if (!this.estoqueProdutosMap.isEmpty()) {
            for (Produto produto : this.estoqueProdutosMap.values()) {
                double quantidadeValorTotal = produto.getQuantidade() * produto.getPreco();
                if (quantidadeValorTotal > maiorQuantidadeValorTotal) {
                    produtoMaiorQuantidadeValorTotal = produto;
                    maiorQuantidadeValorTotal = quantidadeValorTotal;
                }
            }
        }
        return produtoMaiorQuantidadeValorTotal;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1L, "Produto 1", 10.0, 5);
        estoqueProdutos.adicionarProduto(2L, "Produto 2", 20.0, 3);
        estoqueProdutos.adicionarProduto(3L, "Produto 3", 15.0, 2);
        estoqueProdutos.adicionarProduto(4L, "Produto 4", 25.0, 4);
        estoqueProdutos.adicionarProduto(5L, "Produto 5", 30.0, 1);
        estoqueProdutos.adicionarProduto(6L, "Produto 6", 40.0, 6);
        estoqueProdutos.adicionarProduto(7L, "Produto 7", 35.0, 3);
        estoqueProdutos.adicionarProduto(8L, "Produto 8", 50.0, 2);
        estoqueProdutos.adicionarProduto(9L, "Produto 9", 45.0, 4);
        estoqueProdutos.adicionarProduto(10L, "Produto 10", 55.0, 1);

        estoqueProdutos.exibirProdutos();
        System.out.println("Valor total do estoque: " + estoqueProdutos.calcularValorTotalEstoque());
        System.out.println("Produto mais caro: " + estoqueProdutos.obterProdutoMaisCaro());
        System.out.println("Produto mais barato: " + estoqueProdutos.obterProdutoMaisBarato());
        System.out.println("Produto com maior quantidade e valor total no estoque: " + estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }
}
