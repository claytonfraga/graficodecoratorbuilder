/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import GraficoDecorator.GraficoBuilder;
import GraficoDecorator.decorators.IComponente;
import GraficoDecorator.decorators.TituloDecorator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.data.category.DefaultCategoryDataset;
import presenter.command.AddTituloCommand;
import view.TituloView;

/**
 *
 * @author Thiago
 */
public class TituloViewPresenter {

    private TituloView tela;
    private IComponente grafico;

    public TituloViewPresenter(IComponente grafico) {
        tela = new TituloView();
        tela.setVisible(true);
        this.grafico = grafico;

        exibeTitulo();
        tela.getBtnConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionaTitulo();
                tela.dispose();
            }
        });

        tela.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.dispose();
            }
        });

    }

    public void exibeTitulo() {
        if (!grafico.getGrafico().getTitle().getText().equals("")) {
            tela.getTxtFieldTitulo().setText(grafico.getGrafico().getTitle().getText());
        }
    }

    public void adicionaTitulo() {
        String novoTitulo = tela.getTxtFieldTitulo().getText();
        new AddTituloCommand(grafico, novoTitulo).execute();

    }
}
