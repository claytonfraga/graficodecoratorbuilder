package grafico.builder;

import grafico.decorator.LegendaDecorator;
import grafico.decorator.OrientacaoDecorator;
import org.jfree.chart.plot.PlotOrientation;

public class GraficoBarraHorizontalBuilder extends GraficoBuilder {

    @Override
    public void alteraOrientacao() throws CloneNotSupportedException {
        grafico = new OrientacaoDecorator(grafico, PlotOrientation.HORIZONTAL);
    }

    @Override
    public void insereLegenda() throws CloneNotSupportedException {
        grafico = new LegendaDecorator(grafico, true);
    }

}
