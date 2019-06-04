package grafico.decorator.rotulo;

import grafico.decorator.IGrafico;

/**
 *
 * @author Thiago
 */
public final class AnotacaoTotalProporcionalDecorator extends RotuloDecorator {

    public AnotacaoTotalProporcionalDecorator(IGrafico grafico, boolean visivel) throws CloneNotSupportedException {
        super(grafico, visivel);
    }

    @Override
    public void alteraRotulo(boolean visivel) {
        renderer.setBaseItemLabelGenerator(new PercentualTotalLabelGenerator(visivel));
    }

}
