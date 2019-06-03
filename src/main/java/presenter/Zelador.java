/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import GraficoDecorator.GraficoBarrasMemento;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public class Zelador {
    protected static ArrayList<GraficoBarrasMemento> estados = new ArrayList<GraficoBarrasMemento>();
    
    public static void adicionarMemento(GraficoBarrasMemento memento) {
        estados.add(memento);

    }
    
    public static GraficoBarrasMemento getUltimoEstadoSalvo() {
        if (estados.isEmpty()) {
            throw new RuntimeException("Não há estados salvos!");
                    
        }
        GraficoBarrasMemento estadoSalvo = estados.get(estados.size()-1);
        estados.remove(estados.size()-1);
        return estadoSalvo;
    }
    
    public static ArrayList<GraficoBarrasMemento> getEstados() {
        return estados;
    }
}
