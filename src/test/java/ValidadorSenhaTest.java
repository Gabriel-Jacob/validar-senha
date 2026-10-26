import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidadorSenhaTest {

    // ---------- Válidas ----------

    @Test
    void senhaComOitoCaracteresDigitoEMaiusculaEhValida() { // valor-limite (8)
        // Arrange
        var validador = new ValidadorSenha();
        // Act
        boolean resultado = validador.validar("Abcdef12");
        // Assert
        assertTrue(resultado);
    }

    @Test
    void senhaLongaComDigitoEMaiusculaEhValida() {
        var validador = new ValidadorSenha();

        boolean resultado = validador.validar("MinhaSenhaSegura2026");

        assertTrue(resultado);
    }

    @Test
    void digitoEMaiusculaEmQualquerPosicaoEhValida() {
        var validador = new ValidadorSenha();

        boolean resultado = validador.validar("1bcdefgH");

        assertTrue(resultado);
    }

    // ---------- Inválidas: tamanho ----------

    @Test
    void senhaComSeteCaracteresEhInvalida() { // valor-limite (7)
        var validador = new ValidadorSenha();
        assertFalse(validador.validar("Abcde12"));
    }

    @Test
    void senhaVaziaEhInvalida() {
        var validador = new ValidadorSenha();

        boolean resultado = validador.validar("");

        assertFalse(resultado);
    }

    @Test
    void senhaNulaEhInvalida() {
        var validador = new ValidadorSenha();

        boolean resultado = validador.validar(null);

        assertFalse(resultado);
    }

    // ---------- Inválidas: falta de requisito ----------

    @Test
    void senhaSemDigitoEhInvalida() {
        var validador = new ValidadorSenha();

        boolean resultado = validador.validar("Abcdefgh");

        assertFalse(resultado);
    }

    @Test
    void senhaSemMaiusculaEhInvalida() {
        var validador = new ValidadorSenha();

        boolean resultado = validador.validar("abcdefg1");

        assertFalse(resultado);
    }

    @Test
    void senhaSomenteComDigitosEhInvalida() {
        var validador = new ValidadorSenha();

        boolean resultado = validador.validar("12345678");

        assertFalse(resultado);
    }

    @Test
    void senhaSomenteComMaiusculasEhInvalida() {
        var validador = new ValidadorSenha();

        boolean resultado = validador.validar("ABCDEFGH");

        assertFalse(resultado);
    }

    @Test
    void senhaCurtaSemDigitoENemMaiusculaEhInvalida() {
        var validador = new ValidadorSenha();

        boolean resultado = validador.validar("abc");

        assertFalse(resultado);
    }
}
