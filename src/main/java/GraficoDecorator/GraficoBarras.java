/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraficoDecorator;

import GraficoDecorator.decorators.IComponente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Thiago
 */
public class GraficoBarras implements IComponente{
    private  JFreeChart grafico;
   

    public GraficoBarras(JFreeChart grafico) {
        this.grafico = grafico;
        
    }
    
    public GraficoBarras() {
        
    }

    @Override
    public JFreeChart getGrafico() {
        return grafico;
    }

 
    
    @Override
    public void setGrafico(JFreeChart graficoBarras) {
        this.grafico=graficoBarras;
    }
    
    @Override
    public double getIntervaloCount(int intervalo) {
        CategoryDataset dataset = grafico.getCategoryPlot().getDataset();
        
        double total = 0;
        for(int i=0;i<dataset.getRowCount();i++) {
            total = total + dataset.getValue(i, intervalo).doubleValue();
        }
        
        return total;
    }
    
    @Override
    public double getIntervaloProporcao(int intervalo) {
        
        double totalIntervalo = getIntervaloCount(intervalo);
        double total = 0;
        for(int i=0;i<grafico.getCategoryPlot().getDataset().getColumnCount();i++) {
            total += getIntervaloCount(i);
        }
        return totalIntervalo/total;
    }

    @Override
    public double getAlturaMaximaIntervalo(int intervalo) {
        ArrayList<Double> valores = new ArrayList();
        for(int i=0;i<grafico.getCategoryPlot().getDataset().getRowCount();i++) {
            valores.add(grafico.getCategoryPlot().getDataset().getValue(i, intervalo).doubleValue());
        }
        return Collections.max(valores);
    }
    
    @Override
    public GraficoBarrasMemento criaMemento() {
        try {
            return new GraficoBarrasMemento((JFreeChart)grafico.clone());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(GraficoBarras.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
    
    @Override
    public void restauraEstado(GraficoBarrasMemento m) {
       this.grafico=m.grafico;
    }
}
