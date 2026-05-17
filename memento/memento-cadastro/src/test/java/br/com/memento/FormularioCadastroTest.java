package br.com.memento;

import br.com.memento.caretaker.HistoricoCadastro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FormularioCadastroTest {

    private FormularioCadastro formulario;
    private HistoricoCadastro historico;

    @Before
    public void setUp() {
        formulario = new FormularioCadastro();
        historico = new HistoricoCadastro();
    }

    @Test
    public void testSalvarERestaurarEstado() {
        formulario.setNome("Ana");
        formulario.setEmail("ana@email.com");
        formulario.setTelefone("11900000000");
        formulario.setEndereco("Rua X, 10");

        historico.salvar(formulario.salvarEstado());

        formulario.setNome("Ana Paula");
        formulario.setEmail("anapaula@email.com");

        formulario.restaurarEstado(historico.desfazer());

        Assert.assertEquals("Ana", formulario.getNome());
        Assert.assertEquals("ana@email.com", formulario.getEmail());
    }

    @Test
    public void testMultiplosDesfazer() {
        formulario.setNome("Joao");
        historico.salvar(formulario.salvarEstado());

        formulario.setNome("Joao Pedro");
        historico.salvar(formulario.salvarEstado());

        formulario.setNome("Joao Pedro Souza");

        formulario.restaurarEstado(historico.desfazer());
        Assert.assertEquals("Joao Pedro", formulario.getNome());

        formulario.restaurarEstado(historico.desfazer());
        Assert.assertEquals("Joao", formulario.getNome());
    }

    @Test
    public void testHistoricoVazioRetornaNull() {
        MementoFormulario resultado = historico.desfazer();
        Assert.assertNull(resultado);
    }

    @Test
    public void testTamanhoHistorico() {
        formulario.setNome("Maria");
        historico.salvar(formulario.salvarEstado());

        formulario.setNome("Maria Lucia");
        historico.salvar(formulario.salvarEstado());

        Assert.assertEquals(2, historico.getTamanhoHistorico());

        historico.desfazer();

        Assert.assertEquals(1, historico.getTamanhoHistorico());
    }

    @Test
    public void testMementoGuardaValoresCorretos() {
        formulario.setNome("Pedro");
        formulario.setEmail("pedro@email.com");
        formulario.setTelefone("21999990000");
        formulario.setEndereco("Av. Brasil, 500");

        MementoFormulario memento = formulario.salvarEstado();

        Assert.assertEquals("Pedro", memento.getNome());
        Assert.assertEquals("pedro@email.com", memento.getEmail());
        Assert.assertEquals("21999990000", memento.getTelefone());
        Assert.assertEquals("Av. Brasil, 500", memento.getEndereco());
    }
}
