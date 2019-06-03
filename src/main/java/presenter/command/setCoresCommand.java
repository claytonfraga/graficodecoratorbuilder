/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.command;

import GraficoDecorator.decorators.CorBarrasDecorator;
import GraficoDecorator.decorators.IComponente;
import java.awt.Color;
import java.util.ArrayList;
import presenter.Zelador;

/**
 *
 * @author Thiago
 */
public class setCoresCommand implements Command {

    private IComponente grafico;
    private ArrayList<Color> cores;

    public setCoresCommand(IComponente grafico, ArrayList<Color> cores) {
        this.grafico = grafico;
        this.cores = cores;
    }

    @Override
    public void execute() {
        Zelador.adicionarMemento(grafico.criaMemento());
        grafico = new CorBarrasDecorator(grafico, cores);

    }

}
