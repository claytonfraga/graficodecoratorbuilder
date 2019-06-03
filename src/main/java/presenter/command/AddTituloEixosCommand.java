/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.command;

import GraficoDecorator.decorators.EixosDecorator;
import GraficoDecorator.decorators.IComponente;
import presenter.Zelador;

/**
 *
 * @author Thiago
 */
public class AddTituloEixosCommand implements Command {

    private IComponente grafico;
    private String eixoClasses, eixoValores;

    public AddTituloEixosCommand(IComponente grafico, String eixoClasses, String eixoValores) {
        this.grafico = grafico;
        this.eixoClasses = eixoClasses;
        this.eixoValores = eixoValores;
    }

    @Override
    public void execute() {
        Zelador.adicionarMemento(grafico.criaMemento());
        grafico = new EixosDecorator(grafico, eixoClasses, eixoValores);

    }

}
