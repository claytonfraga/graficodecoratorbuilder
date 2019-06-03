/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Thiago
 */
public class EixosView extends javax.swing.JFrame {

    /**
     * Creates new form EixosView
     */
    public EixosView() {
        initComponents();
        this.setLocationRelativeTo(this.getParent());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFieldEixoHorizontal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFieldEixoVertical = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Digite o Título do eixo Horizontal:");

        txtFieldEixoHorizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldEixoHorizontalActionPerformed(evt);
            }
        });

        jLabel2.setText("Digite o Título do eixo Vertical:");

        txtFieldEixoVertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldEixoVerticalActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Confirmar");

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFieldEixoHorizontal)
                        .addComponent(jLabel2)
                        .addComponent(txtFieldEixoVertical))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldEixoHorizontal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldEixoVertical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldEixoHorizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldEixoHorizontalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldEixoHorizontalActionPerformed

    private void txtFieldEixoVerticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldEixoVerticalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldEixoVerticalActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtFieldEixoHorizontal;
    private javax.swing.JTextField txtFieldEixoVertical;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnConfirmar() {
        return btnConfirmar;
    }

    public JTextField getTxtFieldEixoHorizontal() {
        return txtFieldEixoHorizontal;
    }

    public JTextField getTxtFieldEixoVertical() {
        return txtFieldEixoVertical;
    }
}
