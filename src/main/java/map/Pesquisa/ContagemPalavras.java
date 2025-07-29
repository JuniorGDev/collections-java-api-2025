package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    Map<String, Integer> palavrasMap = new HashMap<>();

    public ContagemPalavras() {
        this.palavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        palavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (!this.palavrasMap.isEmpty()) {
            palavrasMap.remove(palavra);
        } else {
            System.out.println("O dicionário está vazio!");
        }
    }

    public Integer exibirContagemPalavras() {
        Integer contagemPalavras = 0;
        for (Integer contagem : palavrasMap.values()) {
            contagemPalavras += contagem;
        }
        return contagemPalavras;
    }

    public String encontrarPalavrasMaisFrequentes() {
        String palavrasMaisFrequentes = null;
        int maiorContagem = 0;
        if (!this.palavrasMap.isEmpty()) {
            for (Map.Entry<String, Integer> palavra : palavrasMap.entrySet()) {
                if (palavra.getValue() > maiorContagem) {
                    maiorContagem = palavra.getValue();
                    palavrasMaisFrequentes = palavra.getKey();
                }
            }
        }
        return palavrasMaisFrequentes;
    }


    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();
        contagemPalavras.adicionarPalavra("Java", 3);
        contagemPalavras.adicionarPalavra("Python", 2);
        contagemPalavras.adicionarPalavra("C++", 1);
        contagemPalavras.removerPalavra("C++");
        System.out.println(contagemPalavras.exibirContagemPalavras());
        System.out.println(contagemPalavras.encontrarPalavrasMaisFrequentes());
    }
}
