package grafico.decorator.rotulo;

import grafico.decorator.GraficoDecorator;
import java.awt.Color;
import java.awt.Paint;
import org.jfree.chart.ChartColor;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.category.BarRenderer;
import grafico.decorator.IGrafico;

/**
 *
 * @author Thiago
 */
public abstract class RotuloDecorator extends GraficoDecorator {

    protected BarRenderer renderer;

    public RotuloDecorator(IGrafico grafico, boolean visivel) throws CloneNotSupportedException {
        super(grafico);
        setAnotacoes(visivel);
    }

    public final void setAnotacoes(boolean visivel) throws CloneNotSupportedException {
        renderer = new BarRenderer();

        Color cor1 = (Color) elementoDecorado.getGrafico().getCategoryPlot().getRenderer().getSeriesPaint(0);
        Color cor2 = (Color) elementoDecorado.getGrafico().getCategoryPlot().getRenderer().getSeriesPaint(1);

        Paint serie1 = new ChartColor(cor1.getRed(), cor1.getGreen(), cor1.getBlue());
        Paint serie2 = new ChartColor(cor2.getRed(), cor2.getGreen(), cor2.getBlue());

        renderer.setSeriesPaint(0, serie1);
        renderer.setSeriesPaint(1, serie2);
        renderer.setBaseItemLabelsVisible(true);

        alteraRotulo(visivel);

        novoGrafico = (JFreeChart) elementoDecorado.getGrafico().clone();

        novoGrafico.getCategoryPlot().setRenderer(renderer);

    }

    @Override
    public JFreeChart getGrafico() {
        return novoGrafico;
    }

    public abstract void alteraRotulo(boolean visivel);

}
