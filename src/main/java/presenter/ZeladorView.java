/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import java.util.Stack;
import static presenter.Zelador.estados;
import view.MainViewMemento;

/**
 *
 * @author Thiago
 */
public class ZeladorView {
    protected static Stack<MainViewMemento> estados = new Stack();
    
    public static void adicionarMemento(MainViewMemento m){
        estados.push(m);
    }
    
    public static MainViewMemento getUltimoEstado() {
         if (estados.isEmpty()) {
            throw new RuntimeException("Não há estados salvos!");
                    
        }
        return estados.pop();
    }
}
