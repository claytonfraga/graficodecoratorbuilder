package grafico.decorator;

import org.jfree.chart.JFreeChart;

/**
 *
 * @author Thiago
 */
public class GridlinesDecorator extends GraficoDecorator {

    public GridlinesDecorator(IGrafico grafico, boolean gridlines) throws CloneNotSupportedException {
        super(grafico);
        novoGrafico = (JFreeChart) elementoDecorado.getGrafico().clone();

        novoGrafico.getCategoryPlot().setDomainGridlinesVisible(gridlines);
        novoGrafico.getCategoryPlot().setRangeGridlinesVisible(gridlines);
    }

    @Override
    public JFreeChart getGrafico() {
        return novoGrafico;
    }

}
