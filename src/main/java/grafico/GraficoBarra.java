package grafico;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import grafico.decorator.IGrafico;

/**
 *
 * @author Thiago
 */
public class GraficoBarra implements IGrafico {

    private JFreeChart grafico;

    public final static String CORDEFAULT1 = "0xFF4354";
    public final static String CORDEFAULT2 = "0x0085C4";

    public GraficoBarra(DefaultCategoryDataset dataset) {
        grafico = ChartFactory.createBarChart("", "", "", dataset, PlotOrientation.VERTICAL, true, true, true);
        grafico.getLegend().setVisible(false);
        grafico.getCategoryPlot().setDomainGridlinesVisible(false);
        grafico.getCategoryPlot().setRangeGridlinesVisible(false);

        ArrayList<Color> cores = new ArrayList();
        cores.add(Color.decode(CORDEFAULT1));
        cores.add(Color.decode(CORDEFAULT2));
        for (int i = 0; i < cores.size(); i++) {
            Color c = cores.get(i);
            grafico.getCategoryPlot().getRenderer().setSeriesPaint(i, c);
        }
    }

    @Override
    public JFreeChart getGrafico() {
        return this.grafico;
    }

    @Override
    public double getIntervaloCount(int intervalo) {
        CategoryDataset dataset = grafico.getCategoryPlot().getDataset();

        double total = 0;
        for (int i = 0; i < dataset.getRowCount(); i++) {
            total = total + dataset.getValue(i, intervalo).doubleValue();
        }

        return total;
    }

    @Override
    public double getIntervaloProporcao(int intervalo) {

        double totalIntervalo = getIntervaloCount(intervalo);
        double total = 0;
        for (int i = 0; i < grafico.getCategoryPlot().getDataset().getColumnCount(); i++) {
            total += getIntervaloCount(i);
        }
        return totalIntervalo / total;
    }

    @Override
    public double getAlturaMaximaIntervalo(int intervalo) {
        ArrayList<Double> valores = new ArrayList();
        for (int i = 0; i < grafico.getCategoryPlot().getDataset().getRowCount(); i++) {
            valores.add(grafico.getCategoryPlot().getDataset().getValue(i, intervalo).doubleValue());
        }
        return Collections.max(valores);
    }

    @Override
    public IGrafico remover() {
        return this;
    }
}
