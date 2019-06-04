package grafico.decorator.rotulo;

import grafico.decorator.IGrafico;

/**
 *
 * @author Thiago
 */
public final class PercentualDecorator extends RotuloDecorator {

    public PercentualDecorator(IGrafico grafico, boolean visivel) throws CloneNotSupportedException {
        super(grafico, visivel);
        setAnotacoes(visivel);
    }

    @Override
    public void alteraRotulo(boolean visivel) {
        renderer.setBaseItemLabelGenerator(new PercentualLabelGenerator(visivel));
    }

}
