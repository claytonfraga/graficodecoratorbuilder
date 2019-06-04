package grafico.decorator.rotulo;

import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractCategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.data.category.CategoryDataset;

final class TotalLabelGenerator extends AbstractCategoryItemLabelGenerator implements CategoryItemLabelGenerator {

    private static final long serialVersionUID = 1L;
    private final boolean showLabel;

    TotalLabelGenerator(boolean showLabel) {
        super("", NumberFormat.getIntegerInstance());
        this.showLabel = showLabel;
    }

    @Override
    public String generateLabel(CategoryDataset dataset, int row, int column) {
        Number value = Double.NaN;
        if (showLabel) {
            value = dataset.getValue(row, column);
        }
        return value == null || value.intValue() == 0 ? null : String.valueOf(value.intValue());
    }
}
