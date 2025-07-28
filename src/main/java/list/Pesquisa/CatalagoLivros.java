package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalagoLivros {
    private List<Livro> livroList;

    public CatalagoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        Livro livro = new Livro(titulo, autor, anoPublicacao);
        this.livroList.add(livro);
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        if (!this.livroList.isEmpty()) {
            for (Livro livro : this.livroList) {
                if (livro.getAutor().equalsIgnoreCase(autor)) {
                    livrosEncontrados.add(livro);
                }
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> pesquisarPorAnoPublicacao(int anoInicial, int anoFinal) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        if (!this.livroList.isEmpty()) {
            for (Livro livro : this.livroList) {
                if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal) {
                    livrosEncontrados.add(livro);
                }
            }
        }
        return livrosEncontrados;
    }

    public Livro pesquisarPorTitulo(String titulo) {
        Livro livroEncontrado = null;
        if (!this.livroList.isEmpty()) {
            for (Livro livro : this.livroList) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    livroEncontrado = livro;
                    break;
                }
            }
        }
        return livroEncontrado;
    }

    public static void main(String[] args) {
        CatalagoLivros catalagoLivros = new CatalagoLivros();
        catalagoLivros.adicionarLivro("Livro 1", "Autor 1", 2000);
        catalagoLivros.adicionarLivro("Livro 1", "Autor 1", 2000);
        catalagoLivros.adicionarLivro("Livro 1", "Autor 1", 2000);
        catalagoLivros.adicionarLivro("Livro 2", "Autor 2", 2001);
        catalagoLivros.adicionarLivro("Livro 3", "Autor 3", 2002);
        catalagoLivros.adicionarLivro("Livro 3", "Autor 3", 2002);
        catalagoLivros.adicionarLivro("Livro 3", "Autor 3", 2002);
        catalagoLivros.adicionarLivro("Livro 4", "Autor 4", 2003);

        System.out.println("Pesquisa por autor: \n" + catalagoLivros.pesquisarPorAutor("Autor 1"));
        System.out.println("Pesquisa por ano: \n" + catalagoLivros.pesquisarPorAnoPublicacao(2002, 2003));
        System.out.println("Pesquisa por título: \n" + catalagoLivros.pesquisarPorTitulo("Livro 3"));
    }
}
