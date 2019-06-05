package grafico.presenter;

import java.util.Stack;

public class Zelador {

    private final Stack<MementoOpcao> checkeds = new Stack<>();

    private static volatile Zelador instance;
    private static Object mutex = new Object();

    private Zelador() {
    }

    public void addCheckeds(MementoOpcao memento) {
        checkeds.add(memento);
    }

    public MementoOpcao getCheckeds() {
        return checkeds.pop();
    }

    public static Zelador getInstance() {
        Zelador result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = result = new Zelador();
                }
            }
        }
        return result;
    }

}
