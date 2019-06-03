/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JCheckBox;

/**
 *
 * @author Thiago
 */
public class MainViewMemento {
    private boolean titulo;
    private boolean legenda;
    private boolean eixos;
    private boolean rotuloPercentual;
    private boolean rotuloValor;
    private boolean corBarras;
    private boolean grade;
    
    public MainViewMemento(MainView tela) {
        titulo = tela.getTitulo().isSelected();
        legenda = tela.getLegenda().isSelected();
        eixos = tela.getEixos().isSelected();
        rotuloPercentual = tela.getRotulosProporcional().isSelected();
        rotuloValor = tela.getRotulosTotal().isSelected();
        corBarras = tela.getCorBarrasGrupo().isSelected();
        grade = tela.getGrade().isSelected();
    }

    public boolean isTitulo() {
        return titulo;
    }

    public boolean isLegenda() {
        return legenda;
    }

    public boolean isEixos() {
        return eixos;
    }

    public boolean isRotuloPercentual() {
        return rotuloPercentual;
    }

    public boolean isRotuloValor() {
        return rotuloValor;
    }

    public boolean isCorBarras() {
        return corBarras;
    }

    public boolean isGrade() {
        return grade;
    }

    public void setTitulo(boolean titulo) {
        this.titulo = titulo;
    }

    public void setLegenda(boolean legenda) {
        this.legenda = legenda;
    }

    public void setEixos(boolean eixos) {
        this.eixos = eixos;
    }

    public void setRotuloPercentual(boolean rotuloPercentual) {
        this.rotuloPercentual = rotuloPercentual;
    }

    public void setRotuloValor(boolean rotuloValor) {
        this.rotuloValor = rotuloValor;
    }

    public void setCorBarras(boolean corBarras) {
        this.corBarras = corBarras;
    }

    public void setGrade(boolean grade) {
        this.grade = grade;
    }
    
    
    
}
