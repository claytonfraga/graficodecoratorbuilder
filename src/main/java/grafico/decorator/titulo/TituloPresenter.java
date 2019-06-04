package grafico.decorator.titulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import grafico.decorator.IGrafico;

/**
 *
 * @author Thiago
 */
final class TituloPresenter {

    private TituloView tela;
    private IGrafico grafico;
    private String titulo;

    public TituloPresenter(IGrafico grafico) {
        tela = new TituloView();
        this.grafico = grafico;

        exibeTitulo();
        tela.getBtnConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    adicionaTitulo();
                    tela.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());

                }
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

    private void exibeTitulo() {
        if (!grafico.getGrafico().getTitle().getText().equals("")) {
            tela.getTxtFieldTitulo().setText(grafico.getGrafico().getTitle().getText());
        }
    }

    private void adicionaTitulo() throws CloneNotSupportedException {
        titulo = tela.getTxtFieldTitulo().getText();
    }

    public String getTitulo() {
        return titulo;
    }

}
