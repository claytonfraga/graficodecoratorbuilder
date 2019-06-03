/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraficoDecorator.decorators;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;

/**
 *
 * @author Thiago
 */
public class LegendaDecorator extends GraficoDecorator{

    public LegendaDecorator(IComponente grafico, boolean visivel) {
        super(grafico);
        elementoDecorado.getGrafico().getLegend().setVisible(visivel);
    }
    
   
    
}
