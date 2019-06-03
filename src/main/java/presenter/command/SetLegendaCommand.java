/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.command;

import GraficoDecorator.decorators.IComponente;
import GraficoDecorator.decorators.LegendaDecorator;
import presenter.Zelador;

/**
 *
 * @author Thiago
 */
public class SetLegendaCommand implements Command {

    private IComponente grafico;
    private boolean visivel;

    public SetLegendaCommand(IComponente grafico, boolean visivel) {
        this.grafico = grafico;
        this.visivel = visivel;
    }

    @Override
    public void execute() {
        Zelador.adicionarMemento(grafico.criaMemento());
        grafico = new LegendaDecorator(grafico, visivel);

    }

}
