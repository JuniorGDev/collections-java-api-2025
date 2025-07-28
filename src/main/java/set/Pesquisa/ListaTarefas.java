package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa tarefa = new Tarefa(descricao);
        this.tarefaSet.add(tarefa);
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefa = new Tarefa(descricao);
        if (!this.tarefaSet.isEmpty()) {
            for (Tarefa t : this.tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(tarefa.getDescricao())) {
                    this.tarefaSet.remove(t);
                    System.out.println("Tarefa removida com sucesso!");
                    break;
                }
            }
        } else {
            System.out.println("A lista de tarefas está vazia!");
        }
    }

    public void exibirTarefas() {
        System.out.println(this.tarefaSet);
    }

    public int contarTarefas() {
        return this.tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa t : this.tarefaSet) {
            if (t.isConcluida()) {
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for (Tarefa t : this.tarefaSet) {
            if (!t.isConcluida()) {
                tarefasPendentes.add(t);
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao) {
        Tarefa tarefaSelecionada = null;
        if (!this.tarefaSet.isEmpty()) {
            for (Tarefa t : this.tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluida(true);
                    tarefaSelecionada = t;
                    break;
                }
            }
        } else {
            System.out.println("A lista de tarefas está vazia!");
            return;
        }

        if (tarefaSelecionada != null) {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void marcarTarefaPendente(String descricao) {
        Tarefa tarefaSelecionada = null;
        if (!this.tarefaSet.isEmpty()) {
            for (Tarefa t : this.tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluida(false);
                    tarefaSelecionada = t;
                    break;
                }
            }
        } else {
            System.out.println("A lista de tarefas está vazia!");
            return;
        }

        if (tarefaSelecionada != null) {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void limparListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();
        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 2");
        listaTarefas.adicionarTarefa("Tarefa 3");
        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.exibirTarefas();
        listaTarefas.removerTarefa("Tarefa 2");
        listaTarefas.exibirTarefas();
        System.out.println("Número total de tarefas: " + listaTarefas.contarTarefas());
        System.out.println("Tarefas concluídas: " + listaTarefas.obterTarefasConcluidas());
        System.out.println("Tarefas pendentes: " + listaTarefas.obterTarefasPendentes());
        listaTarefas.marcarTarefaConcluida("Tarefa 1");
        listaTarefas.marcarTarefaPendente("Tarefa 2");
        System.out.println("Tarefas concluídas: " + listaTarefas.obterTarefasConcluidas());
        listaTarefas.exibirTarefas();
        listaTarefas.limparListaTarefas();
    }
}
