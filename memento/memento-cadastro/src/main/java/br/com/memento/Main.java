package br.com.memento;

import br.com.memento.caretaker.HistoricoCadastro;

public class Main {

    public static void main(String[] args) {

        FormularioCadastro formulario = new FormularioCadastro();
        HistoricoCadastro historico = new HistoricoCadastro();

        formulario.setNome("Carlos");
        formulario.setEmail("carlos@email.com");
        formulario.setTelefone("11999990000");
        formulario.setEndereco("Rua A, 100");

        historico.salvar(formulario.salvarEstado());
        System.out.println("Estado salvo: " + formulario);

        formulario.setNome("Carlos Silva");
        formulario.setEmail("carlossilva@email.com");
        formulario.setTelefone("11988880000");
        formulario.setEndereco("Rua B, 200");

        historico.salvar(formulario.salvarEstado());
        System.out.println("Estado salvo: " + formulario);

        formulario.setNome("Carlos Silva Junior");
        formulario.setEmail("junior@email.com");
        System.out.println("Estado atual: " + formulario);

        formulario.restaurarEstado(historico.desfazer());
        System.out.println("Apos desfazer: " + formulario);

        formulario.restaurarEstado(historico.desfazer());
        System.out.println("Apos desfazer: " + formulario);
    }
}
