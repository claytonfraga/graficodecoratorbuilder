package grafico.decorator;

import org.jfree.chart.JFreeChart;

/**
 *
 * @author Thiago
 */
public abstract class GraficoDecorator implements IGrafico {

    protected IGrafico elementoDecorado;
    protected JFreeChart novoGrafico;

    public GraficoDecorator(IGrafico grafico) {
        elementoDecorado = grafico;
    }

    @Override
    public JFreeChart getGrafico() {
        return elementoDecorado.getGrafico();

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
    public IGrafico remover() {
        return elementoDecorado;
    }

}
