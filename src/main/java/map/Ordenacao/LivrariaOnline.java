package main.java.map.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LivrariaOnline {
    Map<String, Livro> livrosMap = new HashMap<>();

    public LivrariaOnline() {
        this.livrosMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        Livro livro = new Livro(titulo, autor, preco);
        this.livrosMap.put(link, livro);
    }

    public void removerLivro(String link) {
        if (!this.livrosMap.isEmpty()) {
            this.livrosMap.remove(link);
        } else {
            System.out.println("O dicionário está vazio!");
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> listaLivroOrdenados = new ArrayList<>(this.livrosMap.entrySet()); // <key, value>
        Collections.sort(listaLivroOrdenados, new LivroComparatorPreco());
        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : listaLivroOrdenados) {
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Map<String, Livro> livrosOrdenados = new TreeMap<>(this.livrosMap);
        Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : livrosOrdenados.entrySet()) {
            if (entry.getValue().getAutor().equalsIgnoreCase(autor)) {
                livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
            }
        }
        return livrosOrdenadosPorAutor;
    }

    public Livro obterLivroMaisCaro() {
        Livro livroMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (!this.livrosMap.isEmpty()) {
            for (Map.Entry<String, Livro> livro : this.livrosMap.entrySet()) {
                if (livro.getValue().getPreco() > maiorPreco) {
                    maiorPreco = livro.getValue().getPreco();
                    livroMaisCaro = livro.getValue();
                }
            }
        }
        return livroMaisCaro;
    }

    public Livro obterLivroMaisBarato() {
        Livro livroMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if (!this.livrosMap.isEmpty()) {
            for (Map.Entry<String, Livro> livro : this.livrosMap.entrySet()) {
                if (livro.getValue().getPreco() < menorPreco) {
                    menorPreco = livro.getValue().getPreco();
                    livroMaisBarato = livro.getValue();
                }
            }
        }
        return livroMaisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        livrariaOnline.adicionarLivro("link1", "Livro 1", "Autor 1", 19.99);
        livrariaOnline.adicionarLivro("link2", "Livro 2", "Autor 2", 29.99);
        livrariaOnline.adicionarLivro("link3", "Livro 3", "Autor 2", 39.99);
        livrariaOnline.adicionarLivro("link4", "Livro 4", "Autor 2", 49.99);
        livrariaOnline.adicionarLivro("link5", "Livro 5", "Autor 2", 59.99);
        livrariaOnline.adicionarLivro("link6", "Livro 6", "Autor 6", 69.99);
        livrariaOnline.adicionarLivro("link7", "Livro 7", "Autor 7", 79.99);
        livrariaOnline.adicionarLivro("link8", "Livro 8", "Autor 8", 89.99);
        livrariaOnline.adicionarLivro("link9", "Livro 9", "Autor 9", 99.99);
        livrariaOnline.adicionarLivro("link10", "Livro 10", "Autor 10", 109.99);

        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());
        System.out.println("Livros por autor: \n" + livrariaOnline.pesquisarLivrosPorAutor("Autor 2"));
        System.out.println("Livro mais caro: \n" + livrariaOnline.obterLivroMaisCaro());
        System.out.println("Livro mais barato: \n" + livrariaOnline.obterLivroMaisBarato());
    }
}
