package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciarAlunos {
    Set<Aluno> alunoSet = new HashSet<>();

    public GerenciarAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double media) {
        Aluno aluno = new Aluno(nome, matricula, media);
        this.alunoSet.add(aluno);
    }

    public void removerAluno(long matricula) {
        Aluno alunoRemovido = null;
        if (!this.alunoSet.isEmpty()) {
            for (Aluno aluno : this.alunoSet) {
                if (aluno.getMatricula() == matricula) {
                    alunoRemovido = aluno;
                    break;
                }
            }
        }
        if (alunoRemovido != null) {
            this.alunoSet.remove(alunoRemovido);
        } else {
            System.out.println("Aluno nao encontrado!");
        }
    }

    public Set<Aluno> exibirAlunosPorNome() {
        return new TreeSet<>(this.alunoSet);
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunoSet = new TreeSet<>(new AlunoComparator());
        alunoSet.addAll(this.alunoSet);
        return alunoSet;
    }

    public void exibirAlunos() {
        System.out.println(this.alunoSet);
    }

    public static void main(String[] args) {
        GerenciarAlunos gerenciarAlunos = new GerenciarAlunos();
        gerenciarAlunos.adicionarAluno("João", 1, 8.5);
        gerenciarAlunos.adicionarAluno("Maria", 2, 9.0);
        gerenciarAlunos.adicionarAluno("Pedro", 3, 7.5);
        System.out.println("Alunos por nome:");
        System.out.println(gerenciarAlunos.exibirAlunosPorNome());
        System.out.println("\nAlunos por nota:");
        System.out.println(gerenciarAlunos.exibirAlunosPorNota());
        System.out.println("\nAlunos:");
        gerenciarAlunos.exibirAlunos();
        System.out.println("\nRemovendo aluno com matricula 2:");
        gerenciarAlunos.removerAluno(2);

        System.out.println("\nAlunos:");
        gerenciarAlunos.exibirAlunos();
    }
}
