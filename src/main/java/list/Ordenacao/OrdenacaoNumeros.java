package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numeros;

    public OrdenacaoNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        this.numeros.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> numerosOrdenados = new ArrayList<>(this.numeros);
        Collections.sort(numerosOrdenados);
        return numerosOrdenados;
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> numerosOrdenados = new ArrayList<>(this.numeros);
        Collections.sort(numerosOrdenados, Collections.reverseOrder());
        return numerosOrdenados;
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();
        ordenacaoNumeros.adicionarNumero(5);
        ordenacaoNumeros.adicionarNumero(2);
        ordenacaoNumeros.adicionarNumero(8);
        ordenacaoNumeros.adicionarNumero(1);
        ordenacaoNumeros.adicionarNumero(3);
        System.out.println("Ordenação ascendente:");
        System.out.println(ordenacaoNumeros.ordenarAscendente());
        System.out.println("Ordenação descendente:");
        System.out.println(ordenacaoNumeros.ordenarDescendente());
    }
}
