/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AgregarRegistros extends javax.swing.JDialog {

    ArrayList<fieldStructure> listaCampos = new ArrayList<>();
    public AgregarRegistros(java.awt.Frame parent, boolean modal, ArrayList<fieldStructure> campos) {
        super(parent, modal);
        listaCampos = campos;
        initComponents();
        this.setLocationRelativeTo(this);
        dibujarCampos();
    }
    public void dibujarCampos(){
        
        //crear nueva vista en el Jpanel de Jdialog
        
        JPanel.setLayout(new GridLayout(14,2));
               
        //crear las labels de los campos
        JLabel nombreCampos[] = new JLabel[listaCampos.size()];
        JTextField nombreText[] = new JTextField[listaCampos.size()];
        for (int i = 0; i < nombreCampos.length; i++) {
            nombreCampos[i] = new JLabel(listaCampos.get(i).getFieldName());
            nombreText[i] = new JTextField(listaCampos.get(i).getSizeField());
            JPanel.add(nombreCampos[i]);
            JPanel.add(nombreText[i]);
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGuardarRegistro = new javax.swing.JButton();
        JPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        BtnGuardarRegistro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnGuardarRegistro.setText("Guardar Registro");
        BtnGuardarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanelLayout = new javax.swing.GroupLayout(JPanel);
        JPanel.setLayout(JPanelLayout);
        JPanelLayout.setHorizontalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );
        JPanelLayout.setVerticalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnGuardarRegistro)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(BtnGuardarRegistro)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnGuardarRegistroActionPerformed

      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGuardarRegistro;
    private javax.swing.JPanel JPanel;
    // End of variables declaration//GEN-END:variables
}
