package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoa {
    private List<Pessoa> pessoaList;

    public OrdenacaoPessoa() {
        this.pessoaList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        Pessoa pessoa = new Pessoa(nome, idade, altura);
        this.pessoaList.add(pessoa);
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> pessoasOrdenadas = new ArrayList<>(this.pessoaList);
        Collections.sort(pessoasOrdenadas);
        return pessoasOrdenadas;
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoasOrdenadas = new ArrayList<>(this.pessoaList);
        Collections.sort(pessoasOrdenadas, new PessoaComparator());
        return pessoasOrdenadas;
    }

    public static void main(String[] args) {
        OrdenacaoPessoa ordenacaoPessoa = new OrdenacaoPessoa();
        ordenacaoPessoa.adicionarPessoa("João", 25, 1.75);
        ordenacaoPessoa.adicionarPessoa("Maria", 30, 1.65);
        ordenacaoPessoa.adicionarPessoa("Pedro", 35, 1.80);
        System.out.println("Ordenação por idade:");
        System.out.println(ordenacaoPessoa.ordenarPorIdade());
        System.out.println("Ordenação por altura:");
        System.out.println(ordenacaoPessoa.ordenarPorAltura());
    }
}
