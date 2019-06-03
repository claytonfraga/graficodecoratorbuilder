/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import javax.swing.JButton;
import view.ColorChooserButton.ColorChangedListener;

/**
 *
 * @author Thiago
 */
public class CoresView extends javax.swing.JFrame {

    /**
     * Creates new form CoresView
     */
    public CoresView() {
        initComponents();
        this.setLocationRelativeTo(this.getParent());
        addBotaoCores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Escolha de Cores");
        setPreferredSize(new java.awt.Dimension(250, 200));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void addBotaoCores() {

        colorChooser = new ColorChooserButton(Color.WHITE);
        colorChooser.addColorChangedListener(new ColorChangedListener() {
            @Override
            public void colorChanged(Color newColor) {
                // do something with newColor ...
            }
        });

        colorChooser2 = new ColorChooserButton(Color.BLUE);
        colorChooser2.addColorChangedListener(new ColorChangedListener() {
            @Override
            public void colorChanged(Color newColor) {
                // do something with newColor ...
            }
        });
        this.setSize(250, 200);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        this.add(new Label("Escolha as cores dos Grupos:"), c);

        //Label botao 1
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        this.add(new Label("Grupo 1:"), c);

        //colorButton 1
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        this.add(colorChooser, c);

        //Label botao 2
        c.gridx = 0;
        c.gridy = 2;
        this.add(new Label("Grupo 2: "), c);

        //colorButton 2
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        this.add(colorChooser2, c);

        c.insets = new Insets(10, 10, 10, 10);
        //botao confirmar
        c.gridx = 0;
        c.gridy = 3;
        botaoConfirmar = new JButton("Confirmar");
        this.add(botaoConfirmar, c);

        //botao cancelar
        c.gridx = 1;
        c.gridy = 3;
        botaoCancelar = new JButton("Cancelar");
        this.add(botaoCancelar, c);

    }
    private JButton botaoConfirmar;
    private JButton botaoCancelar;
    private ColorChooserButton colorChooser;
    private ColorChooserButton colorChooser2;

    public ColorChooserButton getColorChooser() {
        return colorChooser;
    }

    public ColorChooserButton getColorChooser2() {
        return colorChooser2;
    }

    public JButton getBotaoConfirmar() {
        return botaoConfirmar;
    }

    public JButton getBotaoCancelar() {
        return botaoCancelar;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
