/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import GraficoDecorator.GraficoBarrasMemento;
import GraficoDecorator.GraficoBuilder;
import GraficoDecorator.decorators.IComponente;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import presenter.command.AddTituloCommand;
import presenter.command.AddTituloEixosCommand;
import presenter.command.SetLegendaCommand;
import presenter.command.addNotacaoProporcionalCommand;
import presenter.command.addNotacaoTotalCommand;
import presenter.command.setCoresCommand;
import presenter.command.setGradesCommand;
import view.MainView;
import view.MainViewMemento;

/**
 *
 * @author Thiago
 */
public class MainViewPresenter {

    private MainView tela;
    private IComponente grafico;
    private JPanel painelGrafico;
    private String corDefault1 = "0xFF4354";
    private String corDefault2 = "0x0085C4";

    private int tipoGrafico;

    public MainViewPresenter() {
        tela = new MainView();
        tela.setVisible(true);
        painelGrafico = new JPanel();
        tela.add(painelGrafico);
        tipoGrafico = 0;
        plotaGraficoInicial();

        tela.getTitulo().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionaTitulo();
            }
        });

        tela.getLegenda().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                adicionaLegenda();

            }
        });

        tela.getEixos().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                adicionaTituloEixos();

            }
        });
        tela.getRotulosProporcional().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                setAnotacoesProporcional();

            }
        });
        tela.getRotulosTotal().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                setAnotacoesTotal();

            }
        });
        tela.getCorBarrasGrupo().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                setCores();

            }
        });

        tela.getGrade().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
          
                setGrades();

            }
        });

        tela.getComboBoxTipoBarra().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTipoGrafico();

            }
        });
        tela.getBtnDesfazer().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesfazer();
            }
        });
        tela.getBtnRestaurarPadrao().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarPadrao();
            }
        });

    }

    public void plotaGraficoInicial() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "Altura Estudantes", "menos de 1,60");
        dataset.addValue(20, "Altura Estudantes", "1,60 a 1,65");
        dataset.addValue(30, "Altura Estudantes", "1,65 a 1,70");
        dataset.addValue(16, "Altura Estudantes", "1,70 a 1,75");
        dataset.addValue(9, "Altura Estudantes", "1,75 a 1,85");

        dataset.addValue(4, "Altura Professores", "menos de 1,60");
        dataset.addValue(3, "Altura Professores", "1,60 a 1,65");
        dataset.addValue(10, "Altura Professores", "1,65 a 1,70");
        dataset.addValue(5, "Altura Professores", "1,70 a 1,75");
        dataset.addValue(1, "Altura Professores", "1,75 a 1,85");
        GraficoBuilder builder = new GraficoBuilder(dataset);
        builder.criaGraficoDeBarrasVertical();
        ArrayList<Color> cores = new ArrayList();
        cores.add(Color.decode(corDefault1));
        cores.add(Color.decode(corDefault2));
        builder.setBarColors(cores);
        grafico = builder.getGrafico();
        painelGrafico.add(builder.getPanel());
        tela.pack();

    }

    public void atualizaTela(IComponente grafico) {
        painelGrafico.removeAll();
        painelGrafico.add(new ChartPanel(grafico.getGrafico()));
        painelGrafico.updateUI();

    }

    public void adicionaTitulo() {
        boolean selecionado = tela.getTitulo().isSelected();
        MainViewMemento m = new MainViewMemento(tela);
        m.setTitulo(!selecionado);
        ZeladorView.adicionarMemento(m);

        if (!selecionado) {
            new AddTituloCommand(grafico, "").execute();
        } else {
            TituloViewPresenter tituloView = new TituloViewPresenter(grafico);
        }

    }

    public void adicionaLegenda() {
        boolean selecionado = tela.getLegenda().isSelected();
        MainViewMemento m = new MainViewMemento(tela);
        m.setLegenda(!selecionado);
        ZeladorView.adicionarMemento(m);
        
        if (selecionado) {
            new SetLegendaCommand(grafico, true).execute();
        } else {
            new SetLegendaCommand(grafico, false).execute();
        }
    }

    public void adicionaTituloEixos() {
        boolean selecionado = tela.getEixos().isSelected();
        MainViewMemento m = new MainViewMemento(tela);
        m.setEixos(!selecionado);
        ZeladorView.adicionarMemento(m);
        
        if (selecionado) {
            new EixosViewPresenter(grafico);
        } else {
            new AddTituloEixosCommand(grafico, "", "").execute();
        }
    }

    public void setGrades() {
        boolean selecionado = tela.getGrade().isSelected();
        MainViewMemento m = new MainViewMemento(tela);
        m.setGrade(!selecionado);
        ZeladorView.adicionarMemento(m);
        new setGradesCommand(grafico, tela.getGrade().isSelected()).execute();
    }

    public void setAnotacoesProporcional() {
        boolean selecionado = tela.getRotulosProporcional().isSelected();
        MainViewMemento m = new MainViewMemento(tela);
        m.setRotuloPercentual(!selecionado);
        ZeladorView.adicionarMemento(m);
        new addNotacaoProporcionalCommand(grafico, tela.getRotulosProporcional().isSelected()).execute();
    }

    public void setAnotacoesTotal() {
        boolean selecionado = tela.getRotulosTotal().isSelected();
        MainViewMemento m = new MainViewMemento(tela);
        m.setRotuloValor(!selecionado);
        ZeladorView.adicionarMemento(m);
        new addNotacaoTotalCommand(grafico, tela.getRotulosTotal().isSelected()).execute();
    }

    public void setCores() {
        boolean selecionado = tela.getCorBarrasGrupo().isSelected();
        MainViewMemento m = new MainViewMemento(tela);
        m.setCorBarras(!selecionado);
        ZeladorView.adicionarMemento(m);
        if (!selecionado) {
            ArrayList<Color> cores = new ArrayList();
            cores.add(Color.decode(corDefault1));
            cores.add(Color.decode(corDefault2));
            new setCoresCommand(grafico, cores).execute();
        } else {
            new CoresViewPresenter(grafico);
        }

    }

    public void setTipoGrafico() {
        int tipo = tela.getComboBoxTipoBarra().getSelectedIndex();
        if (tipo != tipoGrafico) {
            tipoGrafico = tipo;
            Dataset dados = grafico.getGrafico().getCategoryPlot().getDataset();
            GraficoBuilder builder = new GraficoBuilder((DefaultCategoryDataset) dados);
            painelGrafico.removeAll();
            if (tipo == 0) {
                builder.criaGraficoDeBarrasVertical();
                this.grafico = builder.getGrafico();
            } else {
                builder.criaGraficoDeBarrasHorizontal();
                this.grafico = builder.getGrafico();
            }
            painelGrafico.add(builder.getPanel());
            painelGrafico.updateUI();
            Zelador.adicionarMemento(grafico.criaMemento());
        }
    }

    public void btnDesfazer() {
        GraficoBarrasMemento ultimoEstado = Zelador.getUltimoEstadoSalvo();
        this.grafico.restauraEstado(ultimoEstado);
        restauraMemento(ZeladorView.getUltimoEstado());
        atualizaTela(grafico);

    }

    public void restauraMemento(MainViewMemento m) {
        this.tela.getTitulo().setSelected(m.isTitulo());
        this.tela.getLegenda().setSelected(m.isLegenda());
        this.tela.getEixos().setSelected(m.isEixos());
        this.tela.getRotulosProporcional().setSelected(m.isRotuloPercentual());
        this.tela.getRotulosTotal().setSelected(m.isRotuloValor());
        this.tela.getCorBarrasGrupo().setSelected(m.isCorBarras());
        this.tela.getGrade().setSelected(m.isGrade());
    }
    
    public void btnRestaurarPadrao() {
        while(Zelador.estados.size()>=1) {
            btnDesfazer();
        }
    }
}
