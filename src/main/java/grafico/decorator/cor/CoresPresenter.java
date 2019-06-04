package grafico.decorator.cor;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import grafico.decorator.IGrafico;

/**
 *
 * @author Thiago
 */
final class CoresPresenter {

    private CoresView tela;
    private IGrafico grafico;
    private Color cor1;
    private Color cor2;
    ArrayList<Color> cores = new ArrayList();

    public CoresPresenter(IGrafico grafico) {
        this.grafico = grafico;
        tela = new CoresView();
        exibeCores();
        tela.getBotaoConfirmar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnConfirma();
                } catch (CloneNotSupportedException ex) {
                    JOptionPane.showMessageDialog(null, "Falha" + ex.getMessage());
                }
                tela.dispose();
            }
        });

        tela.getBotaoCancelar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                tela.dispose();
            }
        });
        tela.setVisible(true);
    }

    private void exibeCores() {
        cor1 = (Color) grafico.getGrafico().getCategoryPlot().getRenderer().getSeriesPaint(0);
        cor2 = (Color) grafico.getGrafico().getCategoryPlot().getRenderer().getSeriesPaint(1);
        tela.getColorChooser().setSelectedColor(cor1);
        tela.getColorChooser2().setSelectedColor(cor2);
    }

    private void btnConfirma() throws CloneNotSupportedException {
        cores.add(tela.getColorChooser().getSelectedColor());
        cores.add(tela.getColorChooser2().getSelectedColor());
    }

    public ArrayList<Color> getCores() {
        return cores;
    }
}
