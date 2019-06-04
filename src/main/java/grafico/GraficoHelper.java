package grafico;

import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.CategoryTextAnnotation;

public class GraficoHelper {

    public static List<Integer> getCategoryTextAnnotation(JFreeChart chart, String texto) {
        ArrayList<Integer> posicaoRotulos = new ArrayList<>();

        for (int i = 0; i < chart.getCategoryPlot().getAnnotations().size(); i++) {
            CategoryTextAnnotation anotacao = (CategoryTextAnnotation) chart.getCategoryPlot().getAnnotations().get(i);
            if (anotacao.getText().contains(texto)) {
                posicaoRotulos.add(i);
            }

        }
        return posicaoRotulos;
    }

}
