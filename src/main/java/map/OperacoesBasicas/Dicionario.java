package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    Map<String, String> dicionario = new HashMap<>();

    public Dicionario() {
        this.dicionario = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        this.dicionario.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!this.dicionario.isEmpty()) {
            this.dicionario.remove(palavra);
        } else {
            System.out.println("O dicionário está vazio!");
        }
    }

    public void exibirPalavras() {
        System.out.println(this.dicionario);
    }

    public String pesquisarPorPalavra(String palavra) {
        String definicao = null;
        if (!this.dicionario.isEmpty()) {
            definicao = this.dicionario.get(palavra);
        }
        return definicao;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Java", "Linguagem de programação");
        dicionario.adicionarPalavra("Python", "Linguagem de programação");
        dicionario.adicionarPalavra("C++", "Linguagem de programação");
        dicionario.exibirPalavras();
        dicionario.removerPalavra("C++");
        dicionario.exibirPalavras();
        System.out.println(dicionario.pesquisarPorPalavra("Java"));
        System.out.println(dicionario.pesquisarPorPalavra("C++"));
    }
}
