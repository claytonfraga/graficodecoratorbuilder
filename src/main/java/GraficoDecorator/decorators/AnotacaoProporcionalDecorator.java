/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraficoDecorator.decorators;

import GraficoDecorator.decorators.GraficoDecorator;
import org.jfree.chart.annotations.CategoryTextAnnotation;

/**
 *
 * @author Thiago
 */
public class AnotacaoProporcionalDecorator extends GraficoDecorator {

    public AnotacaoProporcionalDecorator(IComponente grafico, boolean visivel) {
        super(grafico);
        setAnotacoes(visivel);
    }

    public void setAnotacoes(boolean visivel) {
        if (!visivel) {
            elementoDecorado.getGrafico().getCategoryPlot().clearAnnotations();
        } else {
            for (int i = 0; i < elementoDecorado.getGrafico().getCategoryPlot().getDataset().getColumnCount(); i++) {
                double alturaIntervalo = elementoDecorado.getAlturaMaximaIntervalo(i);
                Double valorProporcional = elementoDecorado.getIntervaloProporcao(i);
                String labelValor = String.format("%.0f", (valorProporcional * 100));

                CategoryTextAnnotation annotation = new CategoryTextAnnotation(labelValor + " %", (Comparable) elementoDecorado.getGrafico().getCategoryPlot().getCategories().get(i), alturaIntervalo);
                elementoDecorado.getGrafico().getCategoryPlot().addAnnotation(annotation);
            }
        }

    }
}
