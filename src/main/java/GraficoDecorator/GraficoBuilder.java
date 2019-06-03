/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraficoDecorator;

import GraficoDecorator.decorators.IComponente;
import GraficoDecorator.decorators.AnotacaoProporcionalDecorator;
import GraficoDecorator.decorators.AnotacaoTotalDecorator;
import GraficoDecorator.decorators.CorBarrasDecorator;
import GraficoDecorator.decorators.EixosDecorator;
import GraficoDecorator.decorators.GridlinesDecorator;
import GraficoDecorator.decorators.LegendaDecorator;
import GraficoDecorator.decorators.TituloDecorator;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Thiago
 */
public class GraficoBuilder {

    private IComponente grafico;
    private DefaultCategoryDataset dados;

    public GraficoBuilder(DefaultCategoryDataset dados) {
        this.dados = dados;
        this.grafico = new GraficoBarras();

    }

    public void criaGraficoDeBarrasVertical() {
        grafico.setGrafico(ChartFactory.createBarChart("", "", "", dados, PlotOrientation.VERTICAL, true, true, false));
        setLegenda(false);
        setGridlinesVisiveis(false);
    }

    public void criaGraficoDeBarrasHorizontal() {
        grafico.setGrafico(ChartFactory.createBarChart("", "", "", dados, PlotOrientation.HORIZONTAL, true, true, false));
        setLegenda(false);
        setGridlinesVisiveis(false);

    }

    public void setLegenda(boolean visivel) {
        grafico = new LegendaDecorator(grafico, visivel);
    }

    public void setLabelEixos(String eixoClasses, String eixoValores) {
        grafico = new EixosDecorator(grafico, eixoClasses, eixoValores);
    }

    public void setGridlinesVisiveis(boolean visivel) {
        grafico = new GridlinesDecorator(grafico, visivel);
    }

    public void setBarColors(ArrayList<Color> cores) {
        grafico = new CorBarrasDecorator(grafico, cores);
    }

    public void setAnotacoesTotal(boolean visivel) {
        grafico = new AnotacaoTotalDecorator(grafico, visivel);
    }

    public void setAnotacoesProporcional(boolean visivel) {
        grafico = new AnotacaoProporcionalDecorator(grafico, visivel);
    }

    public IComponente getGrafico() {
        return this.grafico;
    }

    public ChartPanel getPanel() {
        return new ChartPanel(grafico.getGrafico());
    }
}
