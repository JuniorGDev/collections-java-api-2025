package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        Convidado convidado = new Convidado(nome, codigoConvite);
        this.convidadoSet.add(convidado);
    }

    public void removerConvidado(int codigoConvite) {
        Convidado convidado = null;
        for (Convidado c : this.convidadoSet) {
            if (c.getCodigoConvite() == codigoConvite) {
                convidado = c;
                break;
            }
        }
        if (convidado != null) {
            this.convidadoSet.remove(convidado);
        }
    }

    public int contarConvidados() {
        return this.convidadoSet.size();
    }

    public void exibirConvidados() {
        System.out.println(this.convidadoSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        conjuntoConvidados.adicionarConvidado("João", 123);
        conjuntoConvidados.adicionarConvidado("Maria", 124);
        conjuntoConvidados.adicionarConvidado("Pedro", 3);
        conjuntoConvidados.adicionarConvidado("Ana", 4);

        conjuntoConvidados.exibirConvidados();

        conjuntoConvidados.removerConvidado(3);
        conjuntoConvidados.exibirConvidados();

        System.out.println("Número de convidados: " + conjuntoConvidados.contarConvidados());
    }
}

