package grafico.presenter;

import grafico.CarregaDados;
import grafico.GraficoBarra;
import grafico.builder.GraficoBarraHorizontalBuilder;
import grafico.builder.GraficoBarraVerticalBuilder;
import grafico.builder.GraficoDiretor;
import grafico.decorator.rotulo.PercentualDecorator;
import grafico.decorator.rotulo.AnotacaoTotalDecorator;
import grafico.decorator.rotulo.AnotacaoTotalProporcionalDecorator;
import grafico.decorator.cor.CorBarrasDecorator;
import grafico.decorator.tituloEixos.EixosDecorator;
import grafico.decorator.GridlinesDecorator;
import grafico.decorator.LegendaDecorator;
import grafico.decorator.titulo.TituloDecorator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import view.MainView;
import grafico.decorator.IGrafico;

/**
 *
 * @author Thiago
 */
public final class MainViewPresenter {

    private MainView view;
    private IGrafico grafico;
    private JPanel painelGrafico;
    private int tipoGrafico;
    private CarregaDados carregaDados;
    GraficoDiretor diretor;

    public MainViewPresenter() throws CloneNotSupportedException, IOException {
        carregaDados = new CarregaDados("src/main/resources/pessoas.csv", ",", "sexo");
        view = new MainView();
        painelGrafico = new JPanel();
        view.add(painelGrafico);
        tipoGrafico = 0;
        plotaGraficoInicial();

        view.getTitulo().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    adicionaTitulo();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha:" + e.getMessage());
                }
            }
        });

        view.getLegenda().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    adicionaLegenda();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha:" + e.getMessage());
                }
            }
        });

        view.getEixos().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    adicionaTituloEixos();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha:" + e.getMessage());
                }
            }
        });
        view.getRotulosProporcional().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                try {
                    setAnotacoesProporcional();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }

            }
        });

        view.getRotulosTotal().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    setAnotacoesTotal();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }
            }
        });

        view.getRotulosTotalPercentual().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                try {
                    setAnotacoesTotalProporcional();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }

            }
        });

        view.getCorBarrasGrupo().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    setCores();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }
            }
        });

        view.getGrade().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    setGrades();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }
            }
        });

        view.getComboBoxTipoBarra().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    setTipoGrafico();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }
            }
        });
        view.getBtnDesfazer().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnDesfazer();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }

            }
        });
        view.getBtnRestaurarPadrao().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnRestaurarPadrao();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }
            }
        });
        view.setVisible(true);

    }

    private void plotaGraficoInicial() throws CloneNotSupportedException, IOException {

        diretor = new GraficoDiretor(carregaDados.getDadosSumarizados());
        grafico = diretor.criar(new GraficoBarraVerticalBuilder());
        atualizaTela(grafico);
    }

    private void atualizaTela(IGrafico grafico) {
        painelGrafico.removeAll();
        painelGrafico.add(new ChartPanel(grafico.getGrafico()));
        painelGrafico.updateUI();
        view.pack();
    }

    private void adicionaTitulo() throws CloneNotSupportedException {
        grafico = new TituloDecorator(grafico, view.getTitulo().isSelected());

        atualizaTela(grafico);
    }

    private void adicionaLegenda() throws CloneNotSupportedException {
        boolean selecionado = view.getLegenda().isSelected();
        if (selecionado) {
            grafico = new LegendaDecorator(grafico, true);
        } else {
            grafico = new LegendaDecorator(grafico, false
            );
        }
        atualizaTela(grafico);
    }

    private void adicionaTituloEixos() throws CloneNotSupportedException {
        grafico = new EixosDecorator(grafico, view.getEixos().isSelected());
        atualizaTela(grafico);
    }

    private void setGrades() throws CloneNotSupportedException {
        grafico = new GridlinesDecorator(grafico, view.getGrade().isSelected());
        atualizaTela(grafico);
    }

    private void setAnotacoesProporcional() throws CloneNotSupportedException {
        grafico = new PercentualDecorator(grafico, view.getRotulosProporcional().isSelected());
        atualizaTela(grafico);
    }

    private void setAnotacoesTotalProporcional() throws CloneNotSupportedException {
        grafico = new AnotacaoTotalProporcionalDecorator(grafico, view.getRotulosTotalPercentual().isSelected());
        atualizaTela(grafico);

    }

    private void setAnotacoesTotal() throws CloneNotSupportedException {
        grafico = new AnotacaoTotalDecorator(grafico, view.getRotulosTotal().isSelected());
        atualizaTela(grafico);
    }

    private void setCores() throws CloneNotSupportedException {
        if (!view.getCorBarrasGrupo().isSelected()) {
            ArrayList<Color> cores = new ArrayList();
            cores.add(Color.decode(GraficoBarra.CORDEFAULT1));
            cores.add(Color.decode(GraficoBarra.CORDEFAULT2));
            grafico = new CorBarrasDecorator(grafico, cores);
        } else {
            grafico = new CorBarrasDecorator(grafico, null);
        }
        atualizaTela(grafico);

    }

    private void setTipoGrafico() throws CloneNotSupportedException {
        int tipo = view.getComboBoxTipoBarra().getSelectedIndex();
        if (tipo != tipoGrafico) {
            tipoGrafico = tipo;
            painelGrafico.removeAll();
            if (tipo == 0) {
                this.grafico = diretor.criar(new GraficoBarraVerticalBuilder());
            } else {
                this.grafico = diretor.criar(new GraficoBarraHorizontalBuilder());
            }
            atualizaTela(grafico);
        }
    }

    private void btnDesfazer() {
        grafico = grafico.remover();
        atualizaTela(grafico);
    }

    private void btnRestaurarPadrao() throws CloneNotSupportedException, IOException {
        plotaGraficoInicial();
    }
}
