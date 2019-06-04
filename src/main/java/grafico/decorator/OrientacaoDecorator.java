package grafico.decorator;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

public class OrientacaoDecorator extends GraficoDecorator {

    public OrientacaoDecorator(IGrafico grafico, PlotOrientation orientacao) throws CloneNotSupportedException {
        super(grafico);
        novoGrafico = (JFreeChart) elementoDecorado.getGrafico().clone();
        novoGrafico.getCategoryPlot().setOrientation(orientacao);
    }

    @Override
    public JFreeChart getGrafico() {
        return novoGrafico;
    }

}
