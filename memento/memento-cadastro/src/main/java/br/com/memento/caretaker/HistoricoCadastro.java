package br.com.memento.caretaker;

import br.com.memento.MementoFormulario;
import java.util.ArrayList;
import java.util.List;

public class HistoricoCadastro {

    private List<MementoFormulario> historico = new ArrayList<>();

    public void salvar(MementoFormulario memento) {
        historico.add(memento);
    }

    public MementoFormulario desfazer() {
        if (historico.isEmpty()) {
            return null;
        }
        MementoFormulario ultimo = historico.get(historico.size() - 1);
        historico.remove(historico.size() - 1);
        return ultimo;
    }

    public int getTamanhoHistorico() {
        return historico.size();
    }
}
