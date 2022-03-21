import java.time.LocalDate;
import java.util.ArrayList;

public class Agenda {
    private ArrayList<Compromisso> compromissos;

    private void initAgenda(Compromisso compromisso) {
        this.compromissos = new ArrayList<Compromisso>();
        this.adicionarCompromisso(compromisso);
    }

    public Agenda(Compromisso compromisso) {
        this.initAgenda(compromisso);
    }

    public void adicionarCompromisso(Compromisso compromisso) {
        this.compromissos.add(compromisso);
    }

    public void removerCompromisso(Compromisso compromisso) {
        this.compromissos.remove(compromisso);
    }

    public String relatorio(LocalDate dataInicio, LocalDate dataFim) {
        StringBuilder sbuilder = new StringBuilder("___ Relatório de Compromissos ___\n");
        while (!dataInicio.isAfter(dataFim)) {
            sbuilder.append("== Dia: " + DateFormatter.localDateFormat(dataInicio) + " ==\n");
            for (Compromisso c : this.compromissos) {
                if (c.isDiaPrevistoCompromisso(dataInicio)) {
                    sbuilder.append(c.relatorioDia(dataInicio));
                }
            }
            dataInicio = dataInicio.plusDays(1);
        }
        return sbuilder.toString();
    }
}