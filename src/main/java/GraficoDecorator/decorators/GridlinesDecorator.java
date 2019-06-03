/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraficoDecorator.decorators;

/**
 *
 * @author Thiago
 */
public class GridlinesDecorator extends GraficoDecorator{

    public GridlinesDecorator(IComponente grafico, boolean gridlines) {
        super(grafico);
        elementoDecorado.getGrafico().getCategoryPlot().setDomainGridlinesVisible(gridlines);
        elementoDecorado.getGrafico().getCategoryPlot().setRangeGridlinesVisible(gridlines);
    }
    
}
