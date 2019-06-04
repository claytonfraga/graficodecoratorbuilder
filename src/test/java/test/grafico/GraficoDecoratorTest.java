package test.grafico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import grafico.CarregaDados;
import grafico.builder.GraficoBarraVerticalBuilder;
import grafico.builder.GraficoDiretor;
import grafico.decorator.GridlinesDecorator;
import grafico.decorator.IGrafico;
import grafico.decorator.LegendaDecorator;
import grafico.decorator.titulo.TituloDecorator;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Clayton
 */
public class GraficoDecoratorTest {

    private CarregaDados carregaDados;

    public GraficoDecoratorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException, CloneNotSupportedException {
        carregaDados = new CarregaDados("src/main/resources/pessoas.csv", ",", "sexo");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void grafico1() throws CloneNotSupportedException {
        GraficoDiretor diretor = new GraficoDiretor(carregaDados.getDadosSumarizados());
        IGrafico grafico = diretor.criar(new GraficoBarraVerticalBuilder());
    }

    @Test
    public void grafico2() throws CloneNotSupportedException {
        GraficoDiretor diretor = new GraficoDiretor(carregaDados.getDadosSumarizados());
        IGrafico grafico = diretor.criar(new GraficoBarraVerticalBuilder());
        grafico = new LegendaDecorator(grafico, true);
        grafico = new GridlinesDecorator(grafico, true);
    }
}
