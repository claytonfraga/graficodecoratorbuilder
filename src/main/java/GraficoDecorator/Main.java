/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraficoDecorator;

import presenter.MainViewPresenter;

/**
 *
 * @author Thiago
 */
public class Main {

    public static void main(String[] args) {
        
        
        new MainViewPresenter();
        
        // cria o conjunto de dados
//        DefaultCategoryDataset ds = new DefaultCategoryDataset();
//        ds.addValue(40.5, "maximo", "dia 1");
//        ds.addValue(38.2, "maximo", "dia 2");
//        ds.addValue(37.3, "maximo", "dia 3");
//        ds.addValue(31.5, "maximo", "dia 4");
//        ds.addValue(35.7, "maximo", "dia 5");
//        ds.addValue(42.5, "maximo", "dia 6");
//
//        // cria o gráfico
//        JFreeChart grafico = ChartFactory.createLineChart("Meu Grafico", "Dia",
//                "Valor", ds, PlotOrientation.VERTICAL, true, true, false);

   
        
        
        
        //System.out.println(dataset.getValue(1,0));
        
        
//        builder.criaGraficoDeBarrasVertical();
//        
//        builder.adicionaTitulo("Titulo pelo decorator");
//        builder.setLegenda(false);
//        builder.setLabelEixos("Tipos Decorator", "Valores Decorator");
//        
//        ArrayList<Color> cores = new ArrayList();
//        cores.add(Color.BLUE);
//        cores.add(Color.BLACK);
//        builder.setBarColors(cores);
//        builder.setAnotacoesProporcional();
//        
//        IComponente grafico = builder.getGrafico();
//        CategoryTextAnnotation anotacao = (CategoryTextAnnotation)(grafico.getGrafico().getCategoryPlot().getAnnotations().get(1));
//        System.out.println(anotacao.getCategory());
//        System.out.println(grafico.getIntervaloCount(0));
//        System.out.println(grafico.getIntervaloProporcao(0));
        
        //JFreeChart graficoJ = grafico.getGrafico();
     
        /* Tentativa de Adicionar Notação abaixo: */
        //String valorCategoria0 = "Proporção: "+String.valueOf(grafico.getIntervaloProporcao(0))+" %";
        //graficoJ.getCategoryPlot().addAnnotation(new CategoryTextAnnotation(valorCategoria0, (Comparable)graficoJ.getCategoryPlot().getCategories().get(0),10.0), true);
        //grafico.getLegend().setVisible(false);
        /* create chart */
        //JFreeChart grafico = ChartFactory.createBarChart(title, "heights", "Number Of Persons", dataset, PlotOrientation.VERTICAL, true, true, false);

//        /* Get instance of CategoryPlot */
//        CategoryPlot plot = grafico.getCategoryPlot();
//
//        /* Change Bar colors */
//        BarRenderer renderer = (BarRenderer) plot.getRenderer();
//
//        renderer.setSeriesPaint(0, Color.red);
//        renderer.setSeriesPaint(1, Color.green);
//        renderer.setSeriesPaint(2, Color.blue);
//
//        renderer.setDrawBarOutline(false);
//        renderer.setItemMargin(0);
//        
//        /* Fazendo as Modificações do gráfico */
//        
//        //Mudando o Titulo:
//        grafico.setTitle("Titulo");
//
//        //Remove a legenda
//        grafico.getLegend().setVisible(false);
//
//        //Setando o titulo dos eixos
//        plot.getDomainAxis().setLabel("Domain Axes"); //Eixo X
//        plot.getRangeAxis().setLabel("Range Axis"); // Eixo y
//        
//        //Setando as gridlines
//        plot.setDomainGridlinesVisible(false);
//        plot.setRangeGridlinesVisible(false);
//        
        
        
        /* create and display chart on frame */
//        ChartFrame frame = new ChartFrame("JFreeChart Demo", grafico.getGrafico());
//        frame.setVisible(true);
//        frame.pack();
//        
       

    }

}
