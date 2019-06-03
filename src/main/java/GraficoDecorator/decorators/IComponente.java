/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraficoDecorator.decorators;

import GraficoDecorator.GraficoBarrasMemento;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Thiago
 */
public interface IComponente {
    public JFreeChart getGrafico();
    public void setGrafico(JFreeChart grafico);
    public double getIntervaloCount(int intervalo);
    public double getIntervaloProporcao(int intervalo);
    public double getAlturaMaximaIntervalo(int intervalo);
    public GraficoBarrasMemento criaMemento();
    public void restauraEstado(GraficoBarrasMemento m);
}
