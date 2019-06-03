/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraficoDecorator.decorators;

import GraficoDecorator.decorators.GraficoDecorator;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public class CorBarrasDecorator extends GraficoDecorator {

    public CorBarrasDecorator(IComponente grafico, ArrayList<Color> cores) {
        super(grafico);
        setCores(cores);
    }

    public void setCores(ArrayList<Color> cores) {
       
        if (cores == null) {
            
                elementoDecorado.getGrafico().getCategoryPlot().getRenderer().setSeriesPaint(0, Color.BLUE);
                elementoDecorado.getGrafico().getCategoryPlot().getRenderer().setSeriesPaint(1, Color.BLUE);
                elementoDecorado.getGrafico().getCategoryPlot().getRenderer().setSeriesPaint(2, Color.BLUE);
            
        } else {
            int i = 0;
            for (Color c : cores) {
                elementoDecorado.getGrafico().getCategoryPlot().getRenderer().setSeriesPaint(i++, c);
            }
        }

    }

}
