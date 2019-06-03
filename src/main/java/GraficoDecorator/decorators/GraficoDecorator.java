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
public abstract class GraficoDecorator implements IComponente {

    protected IComponente elementoDecorado;

    public GraficoDecorator(IComponente grafico) {
        elementoDecorado = grafico;
    }

    @Override
    public JFreeChart getGrafico() {
        return elementoDecorado.getGrafico();

    }

    @Override
    public void setGrafico(JFreeChart grafico) {
        this.elementoDecorado.setGrafico(grafico);
    }

    @Override
    public double getIntervaloCount(int intervalo) {
        return this.elementoDecorado.getIntervaloCount(intervalo);
    }

    @Override
    public double getIntervaloProporcao(int intervalor) {
        return this.elementoDecorado.getIntervaloProporcao(intervalor);
    }

    @Override
    public double getAlturaMaximaIntervalo(int intervalo) {
        return elementoDecorado.getAlturaMaximaIntervalo(intervalo);
    }

    @Override
    public GraficoBarrasMemento criaMemento() {
        return elementoDecorado.criaMemento();
    }

    @Override
    public void restauraEstado(GraficoBarrasMemento m) {
        elementoDecorado.restauraEstado(m);
    }
}
