package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numeros;

    public SomaNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        this.numeros.add(numero);
    }

    public int calcularSoma() {
        int soma = 0;
        if (this.numeros.isEmpty()) {
            for (int numero : this.numeros) {
                soma += numero;
            }
        }
        return soma;
    }

    public int encontrarMaiorNumero() {
        int maiorNumero = 0;
        if (!this.numeros.isEmpty()) {
            for (int numero : this.numeros) {
                if (numero > maiorNumero) {
                    maiorNumero = numero;
                }
            }
        }
        return maiorNumero;
    }

    public int encontrarMenorNumero() {
        int menorNumero = encontrarMaiorNumero();
        if (!this.numeros.isEmpty()) {
            for (int numero : this.numeros) {
                if (numero < menorNumero) {
                    menorNumero = numero;
                }
            }
        }
        return menorNumero;
    }

    public List<Integer> exibirNumeros() {
        return this.numeros;
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(20);
        somaNumeros.adicionarNumero(30);
        somaNumeros.adicionarNumero(40);
        somaNumeros.adicionarNumero(50);

        System.out.println("Soma dos números: " + somaNumeros.calcularSoma());
        System.out.println("Maior número: " + somaNumeros.encontrarMaiorNumero());
        System.out.println("Menor número: " + somaNumeros.encontrarMenorNumero());
        System.out.println("Números: " + somaNumeros.exibirNumeros());
    }
}
