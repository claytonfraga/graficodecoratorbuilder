package grafico.builder;

import grafico.GraficoBarra;
import grafico.decorator.rotulo.AnotacaoTotalDecorator;
import java.util.ArrayList;
import java.util.Map;
import org.jfree.data.category.DefaultCategoryDataset;
import grafico.decorator.IGrafico;

public abstract class GraficoBuilder {

    protected IGrafico grafico;
    protected DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    public final void criaDados(Map<String, Double> dadosSumarizados) {
        ArrayList<String> categorias = new ArrayList<>(dadosSumarizados.keySet());

        for (int i = 0; i < categorias.size(); i++) {
            dataset.addValue(dadosSumarizados.get(categorias.get(i)), categorias.get(i).split(",")[0], categorias.get(i).split(",")[1]);
        }
    }

    public final void criaGrafico() throws CloneNotSupportedException {
        grafico = new GraficoBarra(dataset);
        grafico = new AnotacaoTotalDecorator(grafico, true);
    }

    public abstract void alteraOrientacao() throws CloneNotSupportedException;
    public abstract void insereLegenda() throws CloneNotSupportedException;

    public final IGrafico getGrafico() {
        return grafico;
    }

}
