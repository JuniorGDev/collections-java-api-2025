package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    private List<Tarefa> tarefas;

    public ListaTarefa() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String tarefa) {
        this.tarefas.add(new Tarefa(tarefa));
    }

    public void removerTarefa(String tarefa) {
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for (Tarefa t : this.tarefas) {
            if (t.getDescricao().equalsIgnoreCase(tarefa)) {
                tarefasParaRemover.add(t);
            }
        }
        this.tarefas.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas() {
        return this.tarefas.size();
    }

    public void obterDescricoesTarefas() {
        System.out.println(this.tarefas);
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();

        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 2");
        listaTarefa.adicionarTarefa("Tarefa 3");
        listaTarefa.adicionarTarefa("Tarefa 1");

        System.out.println("Número total de tarefas: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.removerTarefa("Tarefa 2");

        System.out.println("Número total de tarefas: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.obterDescricoesTarefas();
    }
}
