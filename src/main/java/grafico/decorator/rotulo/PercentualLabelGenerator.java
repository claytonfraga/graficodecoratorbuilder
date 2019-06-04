package grafico.decorator.rotulo;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractCategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.data.category.CategoryDataset;

final class PercentualLabelGenerator extends AbstractCategoryItemLabelGenerator implements CategoryItemLabelGenerator {

    private static final long serialVersionUID = 1L;
    private final boolean showLabel;

    PercentualLabelGenerator(boolean showLabel) {
        super("", NumberFormat.getIntegerInstance());
        this.showLabel = showLabel;
    }

    @Override
    public String generateLabel(CategoryDataset dataset, int row, int column) {

        double total = 0;

        for (int i = 0; i < dataset.getColumnCount(); i++) {
            for (int j = 0; j < dataset.getRowCount(); j++) {
                total += (double) dataset.getValue(j, i);
            }
        }

        Number value = Double.NaN;
        if (showLabel) {
            value = dataset.getValue(row, column);
        }

        DecimalFormat df = new DecimalFormat("##.##%");
        double percent = value.doubleValue() / total;
        String formattedPercent = df.format(percent);
        

        return value == null || value.intValue() == 0 ? null : formattedPercent;
    }

}
