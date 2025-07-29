package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    Map<LocalDate, Evento> agendaEventosMap = new HashMap<>();

    public AgendaEventos() {
        this.agendaEventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        Evento evento = new Evento(nome, atracao);
        agendaEventosMap.put(data, evento);
    }

    public void exibirAgenda() {
        System.out.println(new TreeMap<>(agendaEventosMap));
    }

    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventosMap);
        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                LocalDate dataProximoEvento = entry.getKey();
                Evento proximoEvento = entry.getValue();
                System.out.println("Próximo evento na data " + dataProximoEvento + ": " + proximoEvento);
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        agendaEventos.adicionarEvento(LocalDate.of(2025, 8, 1), "Festival da Música", "Concerto de rock");
        agendaEventos.adicionarEvento(LocalDate.of(2025, 8, 15), "Carnaval de São Paulo", "Festival de música");

        agendaEventos.exibirAgenda();
        agendaEventos.obterProximoEvento();

        agendaEventos.adicionarEvento(LocalDate.of(2025, 8, 10), "Festival da Música", "Concerto de rock");

        agendaEventos.exibirAgenda();
        agendaEventos.obterProximoEvento();
    }
}
