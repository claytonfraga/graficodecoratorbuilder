/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraficoDecorator.decorators;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;

/**
 *
 * @author Thiago
 */
public class TituloDecorator extends GraficoDecorator{

    public TituloDecorator(IComponente grafico, String titulo) {
        super(grafico);
        elementoDecorado.getGrafico().setTitle(titulo);
    }
    
    
}
