package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatos;

    public AgendaContatos() {
        this.agendaContatos = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        this.agendaContatos.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if (!this.agendaContatos.isEmpty()) {
            this.agendaContatos.remove(nome);
        }
    }

    public void exibirContatos() {
        System.out.println(this.agendaContatos);
    }

    public Integer pesquisarContato(String nome) {
        Integer telefone = null;
        if (!this.agendaContatos.isEmpty()) {
            telefone = this.agendaContatos.get(nome);
        }
        return telefone;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("João", 123456789);
        agendaContatos.adicionarContato("Maria", 987654321);
        agendaContatos.adicionarContato("Pedro", 555555555);
        agendaContatos.adicionarContato("Ana Camelo", 999999999);
        agendaContatos.adicionarContato("Ana Silva", 888888888);

        agendaContatos.exibirContatos();

        agendaContatos.removerContato("Maria");
        agendaContatos.exibirContatos();

        Integer telefone = agendaContatos.pesquisarContato("Ana");
        System.out.println("Telefone de Ana: " + telefone);
    }
}
