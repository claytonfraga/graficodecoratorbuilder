package grafico.builder;

import java.util.Map;
import grafico.decorator.IGrafico;

public class GraficoDiretor {

    private Map<String, Double> dadosSumarizados;

    public GraficoDiretor(Map<String, Double> dadosSumarizados) {
        this.dadosSumarizados = dadosSumarizados;
    }

    public IGrafico criar(GraficoBuilder builder) throws CloneNotSupportedException {
        builder.criaDados(dadosSumarizados);
        builder.criaGrafico();
        builder.alteraOrientacao();
        builder.insereLegenda();
        return builder.getGrafico();
    }

}
