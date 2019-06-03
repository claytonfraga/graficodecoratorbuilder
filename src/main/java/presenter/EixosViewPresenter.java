/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import GraficoDecorator.decorators.IComponente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presenter.command.AddTituloEixosCommand;
import presenter.command.SetLegendaCommand;
import view.EixosView;

/**
 *
 * @author Thiago
 */
public class EixosViewPresenter {
    private EixosView tela;
    private IComponente grafico;
    
    public EixosViewPresenter(IComponente grafico) {
        tela = new EixosView();
        tela.setVisible(true);
        this.grafico=grafico;
        exibeTitulos();
        tela.getBtnConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionaTitulos();
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
    
    public void exibeTitulos() {
        String eixoHorizontal = grafico.getGrafico().getCategoryPlot().getDomainAxis().getLabel();
        String eixoVertical = grafico.getGrafico().getCategoryPlot().getRangeAxis().getLabel();
        if (!eixoHorizontal.equals("")){
            tela.getTxtFieldEixoHorizontal().setText(eixoHorizontal);
        }
        if (!eixoVertical.equals("")) {
            tela.getTxtFieldEixoVertical().setText(eixoVertical);
        }
        
    }
    
    public void adicionaTitulos() {
        String labelHorizontal = tela.getTxtFieldEixoHorizontal().getText();
        String labelVertical = tela.getTxtFieldEixoVertical().getText();
        new AddTituloEixosCommand(grafico, labelHorizontal, labelVertical).execute();
    }
}
