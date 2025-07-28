package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, String telefone) {
        Contato contato = new Contato(nome, telefone);
        this.contatoSet.add(contato);
    }

    public void exibirContatos() {
        System.out.println(this.contatoSet);
    }

    public Set<Contato> pesquisarContato(String nome) {
        Set<Contato> contatosEncontrados = new HashSet<>();
        for (Contato contato : this.contatoSet) {
            if (contato.getNome().startsWith(nome)) {
                contatosEncontrados.add(contato);
            }
        }
        return contatosEncontrados;
    }

    public Contato atualizarContato(String nome, String novoNumero) {
        Contato contatoAtualizado = null;
        for (Contato contato : this.contatoSet) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contato.setTelefone(novoNumero);
                contatoAtualizado = contato;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("João", "123456789");
        agendaContatos.adicionarContato("Maria", "987654321");
        agendaContatos.adicionarContato("Pedro", "555555555");
        agendaContatos.adicionarContato("Ana Camelo", "999999999");
        agendaContatos.adicionarContato("Ana Silva", "888888888");

        agendaContatos.exibirContatos();

        Set<Contato> contatosEncontrados = agendaContatos.pesquisarContato("Ana");
        System.out.println("Contatos encontrados: " + contatosEncontrados);

        Contato contatoAtualizado = agendaContatos.atualizarContato("Maria", "111111111");
        System.out.println("Contato atualizado: " + contatoAtualizado);
    }
}
