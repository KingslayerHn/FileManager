
package filemanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Lesterarte
 */
public class Principal extends javax.swing.JFrame {
    
        ArrayList<fieldStructure> listaCampos= new ArrayList();
        ArrayList<String> Registros = new ArrayList();
        Workbook wb;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(this); 
        File path = new File("tables");
        String[] listaArchivos = path.list();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnfile = new javax.swing.JButton();
        btnCampos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRegistros = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnExportar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnIndex = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Adobe Gothic Std B", 1, 24)); // NOI18N
        jLabel3.setText("BIENVENIDOS");

        btnfile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filemanager/Icons/file.png"))); // NOI18N
        btnfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfileActionPerformed(evt);
            }
        });

        btnCampos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filemanager/Icons/field.png"))); // NOI18N
        btnCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCamposActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ARCHIVO");

        btnRegistros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filemanager/Icons/users.png"))); // NOI18N
        btnRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("CAMPOS");

        btnExportar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filemanager/Icons/export.png"))); // NOI18N
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("REGISTROS");

        btnIndex.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filemanager/Icons/index.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("INDICES");

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filemanager/Icons/salir.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("EXPORTAR");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("SALIR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIndex)
                            .addComponent(btnfile))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCampos)
                            .addComponent(btnExportar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalir)
                            .addComponent(btnRegistros))
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(56, 56, 56))))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel5)
                .addGap(75, 75, 75)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(76, 76, 76))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnfile, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfileActionPerformed
        new Archivo().setVisible(true);
              
    }//GEN-LAST:event_btnfileActionPerformed
     public String seleccionarArchivo(){
        File path = new File("tables");
        String[] listaArchivos = path.list();
        JComboBox cmbJOptionPane = new JComboBox(listaArchivos);
        JOptionPane.showMessageDialog( null, cmbJOptionPane, "Mostrar Datos Archivo", JOptionPane.QUESTION_MESSAGE);
        return (String)cmbJOptionPane.getSelectedItem();    
    }
    private void btnCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCamposActionPerformed
        File listaArchivos = new File("tables");
        String[] lista = listaArchivos.list();
        if(lista.length == 0){
            JOptionPane.showMessageDialog(null, "No puede agregar campos"
                    + " si no hay archivos donde Guardarlos!!");
        }else{
            JCampos jcampos = new JCampos();
            jcampos.setVisible(true);
            
        }
    }//GEN-LAST:event_btnCamposActionPerformed

    private void btnRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrosActionPerformed
        File listaArchivos = new File("tables");
        String[] lista = listaArchivos.list();
        if(lista.length == 0){
            JOptionPane.showMessageDialog(null, "No puede agregar Reistros"
                    + " si no hay archivos donde Guardarlos!!");
        }else{
            JRegistros registros = new JRegistros();
            registros.setVisible(true);
 
        }
    }//GEN-LAST:event_btnRegistrosActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
            
      
        String archivo = seleccionarArchivo();  
        File nuevoArchivo = new File("tables\\"+archivo);
        try {
            moverseFinalCampos(nuevoArchivo);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String bytesLeidosBuffer = new String(leerArchivoBuffer("tables\\"+archivo, moverseHastaFinalCampos, 10000));
            if (!(bytesLeidosBuffer.equals(" "))){
                String [] registrosSeparados = bytesLeidosBuffer.split("\\\n");
                for (int i = 0; i < registrosSeparados.length-1; i++) {
                    Registros.add(registrosSeparados[i]);
                }  
            }
            ExportarXlsx();
                
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                
        }       
    }//GEN-LAST:event_btnExportarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
     
    public void ExportarXlsx() throws FileNotFoundException, IOException{
        int numeroFilas = Registros.size();
        
        wb = new XSSFWorkbook();
        Sheet hojaCalculo = wb.createSheet("Registros");
        System.out.println("hasta aqui de maravilla");
        for (int i = 0; i < numeroFilas; i++){
            Row fila = hojaCalculo.createRow(i);
            String Linea = Registros.get(i);
            String contarCampos[] = Linea.split("\\|");            
            for (int j = 0; j < contarCampos.length; j++) {
                Cell celda = fila.createCell(j);
                celda.setCellValue(contarCampos[j]);
            }   
        } 
        wb.write(new FileOutputStream("ExportarExcel.xlsx"));
    }
     
    public byte[] leerArchivoBuffer(String file, int post, int size) throws IOException{
        byte[]  leerBytes;
        try (RandomAccessFile archivo = new RandomAccessFile(file,"r")) {
            archivo.seek(post);
            leerBytes = new byte[size];
            archivo.read(leerBytes);
        }
        return leerBytes;           
    }
     public void moverseFinalCampos(File archivo) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea ;
            
            while((linea = br.readLine()) != null){
                moverseHastaFinalCampos+=linea.length()+2;
                if(linea.equals("#")){
                    break;
                }
            }
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCampos;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnIndex;
    private javax.swing.JButton btnRegistros;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
    private ArrayList<File> archivosExistentes;
    private int moverseHastaFinalCampos = 0;

    
}
