import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

public class CompromissoTest {

    @Test
    public void testNovoCompromisso() {
        Compromisso t = new Compromisso(LocalDateTime.now(), "Exemplo", 2);
        assertFalse(t.isTerminado());
    }

    @Test
    public void testTerminarCompromisso() {
        Compromisso t = new Compromisso(LocalDateTime.now(), "Exemplo", 2);
        t.terminar();
        assertTrue(t.isTerminado());
    }

    @Test
    public void testRelatorioOk() {
        LocalDateTime dataCompromisso = LocalDateTime.parse("2022-01-01T20:00:00.0");
        Compromisso t = new Compromisso(dataCompromisso, "Exemplo", 1);
        LocalDate novaData = dataCompromisso.toLocalDate().plusDays(1);
        assertEquals("02/01/2022 20:00:00 | Exemplo\n", t.relatorioDia(novaData));
    }

    @Test
    public void testRelatorioUnavailable() {
        LocalDateTime dataCompromisso = LocalDateTime.parse("2022-01-01T20:00:00.0");
        Compromisso t = new Compromisso(dataCompromisso, "Exemplo", 2);
        LocalDate novaData = dataCompromisso.toLocalDate().plusDays(1);
        assertEquals(Compromisso.COMPROMISSO_INDISPONIVEL, t.relatorioDia(novaData));
    }
}