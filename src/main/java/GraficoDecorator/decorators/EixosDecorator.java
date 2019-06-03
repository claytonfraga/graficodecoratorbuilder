/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraficoDecorator.decorators;

import org.jfree.chart.plot.CategoryPlot;

/**
 *
 * @author Thiago
 */
public class EixosDecorator extends GraficoDecorator {

    public EixosDecorator(IComponente grafico, String eixoClasses, String eixoValores) {
        super(grafico);
        CategoryPlot plot = elementoDecorado.getGrafico().getCategoryPlot();
        plot.getDomainAxis().setLabel(eixoClasses);
        plot.getRangeAxis().setLabel(eixoValores);
    }

}
