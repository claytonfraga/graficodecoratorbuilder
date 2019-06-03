/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.command;

import GraficoDecorator.decorators.AnotacaoProporcionalDecorator;
import GraficoDecorator.decorators.IComponente;
import presenter.Zelador;

/**
 *
 * @author Thiago
 */
public class addNotacaoProporcionalCommand implements Command{
    private IComponente grafico;
    private boolean visivel;

    public addNotacaoProporcionalCommand(IComponente grafico, boolean visivel) {
        this.grafico = grafico;
        this.visivel = visivel;
    }

    @Override
    public void execute() {
        Zelador.adicionarMemento(grafico.criaMemento());
        grafico = new AnotacaoProporcionalDecorator(grafico, visivel);
        
    }
    
    
}
