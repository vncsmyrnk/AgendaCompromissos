import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

public class AgendaTest {
    @Test
    public void testRelatorioCompromissos() {
        Compromisso c1 = new Compromisso(LocalDateTime.parse("2022-01-01T20:00:00.0"), "Compromisso 1", 2);
        Compromisso c2 = new Compromisso(LocalDateTime.parse("2022-01-01T21:00:00.0"), "Compromisso 2", 1);
        Agenda a = new Agenda(c1);
        a.adicionarCompromisso(c2);
        String relatorioEsperado = "___ Relatório de Compromissos ___\n== Dia: 01/01/2022 ==\n01/01/2022 20:00:00 | Compromisso 1\n01/01/2022 21:00:00 | Compromisso 2\n== Dia: 02/01/2022 ==\n02/01/2022 21:00:00 | Compromisso 2\n== Dia: 03/01/2022 ==\n03/01/2022 20:00:00 | Compromisso 1\n03/01/2022 21:00:00 | Compromisso 2\n";
        String relatorioGerado = a.relatorio(LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-03"));
        assertEquals(relatorioEsperado, relatorioGerado);
    }
}
