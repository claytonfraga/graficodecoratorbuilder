/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.command;

import GraficoDecorator.decorators.IComponente;
import GraficoDecorator.decorators.TituloDecorator;
import presenter.Zelador;

/**
 *
 * @author Thiago
 */
public class AddTituloCommand implements Command {

    private IComponente grafico;
    private String titulo;

    public AddTituloCommand(IComponente grafico, String titulo) {
        this.titulo = titulo;
        this.grafico=grafico;
    }

    @Override
    public void execute() {
        Zelador.adicionarMemento(grafico.criaMemento());
        grafico = new TituloDecorator(grafico, titulo);
    }

}
