package grafico.presenter;

import java.util.HashMap;
import java.util.Map;

public class MementoOpcao {

    private Map<String, Boolean> opcoes = new HashMap<>();

    MementoOpcao(Map<String, Boolean> opcoes) {
        this.opcoes = opcoes;
    }

    Map<String, Boolean> getOpcoes() {
        return opcoes;
    }

}
