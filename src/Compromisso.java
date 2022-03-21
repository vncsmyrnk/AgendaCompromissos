import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Compromisso {
    private LocalDateTime data;
    private String descricao;
    private boolean terminado;
    private int intervaloRepeticao;

    public static final String COMPROMISSO_INDISPONIVEL = "-- Compromisso não disponível no dia --\n";

    private void initCompromisso(LocalDateTime data, String descricao, int intervaloRepeticao) {
        this.data = data;
        this.descricao = descricao;
        this.intervaloRepeticao = intervaloRepeticao;
        this.terminado = false;
    }

    public Compromisso(LocalDateTime data, String descricao, int intervaloRepeticao) {
        this.initCompromisso(data, descricao, intervaloRepeticao);
    }

    public void terminar() {
        this.terminado = true;
    }

    public boolean isTerminado() {
        return this.terminado;
    }

    public String relatorioDia(LocalDate dia) {
        if (!this.isDiaPrevistoCompromisso(dia)) {
            return COMPROMISSO_INDISPONIVEL;
        }

        String dataFormatada = DateFormatter.localDateFormat(dia);
        String horaCompromisso = this.formatTimeData();
        StringBuilder sbuilder = new StringBuilder(
                dataFormatada + " " + horaCompromisso + " | " + this.descricao + "\n");
        return sbuilder.toString();
    }

    public boolean isDiaPrevistoCompromisso(LocalDate dia) {
        LocalDate dataIncioCompromisso = this.data.toLocalDate();
        while (dataIncioCompromisso.isBefore(dia)) {
            dataIncioCompromisso = dataIncioCompromisso.plusDays(this.intervaloRepeticao);
        }
        return dia.equals(dataIncioCompromisso);
    }

    public String formatTimeData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return this.data.format(formatter);
    }
}
