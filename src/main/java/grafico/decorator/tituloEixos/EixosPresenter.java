package grafico.decorator.tituloEixos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import grafico.decorator.IGrafico;

/**
 *
 * @author Thiago
 */
final class EixosPresenter {

    private EixosView tela;
    private IGrafico grafico;
    private String eixoX;
    private String eixoY;

    public EixosPresenter(IGrafico grafico) {
        tela = new EixosView();
        this.grafico = grafico;
        exibeTitulos();
        tela.getBtnConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    adicionaTitulos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Falha: " + ex.getMessage());
                }

                tela.dispose();
            }
        });

        tela.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.dispose();
            }
        });

        tela.setVisible(true);
    }

    private void exibeTitulos() {
        String eixoHorizontal = grafico.getGrafico().getCategoryPlot().getDomainAxis().getLabel();
        String eixoVertical = grafico.getGrafico().getCategoryPlot().getRangeAxis().getLabel();
        if (!eixoHorizontal.equals("")) {
            tela.getTxtFieldEixoHorizontal().setText(eixoHorizontal);
        }
        if (!eixoVertical.equals("")) {
            tela.getTxtFieldEixoVertical().setText(eixoVertical);
        }

    }

    private void adicionaTitulos() throws CloneNotSupportedException {
        String labelHorizontal = tela.getTxtFieldEixoHorizontal().getText();
        String labelVertical = tela.getTxtFieldEixoVertical().getText();
        eixoX = labelHorizontal;
        eixoY = labelVertical;
    }

    public String getEixoX() {
        return eixoX;
    }

    public String getEixoY() {
        return eixoY;
    }

}
