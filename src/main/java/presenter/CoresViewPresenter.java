/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import GraficoDecorator.decorators.IComponente;
import java.awt.Color;
import java.util.ArrayList;
import presenter.command.setCoresCommand;
import view.CoresView;

/**
 *
 * @author Thiago
 */
public class CoresViewPresenter {
    private CoresView tela;
    private IComponente grafico;

    public CoresViewPresenter(IComponente grafico) {
        this.grafico = grafico;
        tela = new CoresView();
        tela.setVisible(true);
        exibeCores();
        tela.getBotaoConfirmar().addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnConfirma();
                    tela.dispose();
                }
            });
        
        tela.getBotaoCancelar().addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    
                    tela.dispose();
                }
            });
        
    }
    
    public void exibeCores() {
        Color cor1 = (Color) grafico.getGrafico().getCategoryPlot().getRenderer().getSeriesPaint(0);
        Color cor2 = (Color)grafico.getGrafico().getCategoryPlot().getRenderer().getSeriesPaint(1);
        tela.getColorChooser().setSelectedColor(cor1);
        tela.getColorChooser2().setSelectedColor(cor2);
    }
    
    public void btnConfirma() {
        ArrayList<Color> cores = new ArrayList();
        cores.add(tela.getColorChooser().getSelectedColor());
        cores.add(tela.getColorChooser2().getSelectedColor());
        new setCoresCommand(grafico, cores).execute();
    }
    
    
}
