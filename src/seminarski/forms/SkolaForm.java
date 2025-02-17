/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package seminarski.forms;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import seminarski.controller.Controller;
import seminarski.domain.*;
/**
 *
 * @author pc
 */
public class SkolaForm extends javax.swing.JDialog {

    /**
     * Creates new form SkolaForm
     */
    public SkolaForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        forInsert();
        setLocationRelativeTo(null);
        setTitle("Unos nove skole");
    }
    
    
     public SkolaForm(java.awt.Frame parent, boolean modal,Skola sk) {
        super(parent, modal);
        initComponents();
        forView(sk);
        setLocationRelativeTo(null);
        setTitle("Detaljan prikaz skole");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtGrad = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnObrisi = new javax.swing.JButton();
        btnIzmena = new javax.swing.JButton();
        btnPromeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblId.setText("id");

        jLabel1.setText("naziv");

        txtNaziv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNazivActionPerformed(evt);
            }
        });

        jLabel2.setText("grad");

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnIzmena.setText("Izmena");
        btnIzmena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmenaActionPerformed(evt);
            }
        });

        btnPromeni.setText("Promeni");
        btnPromeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGrad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnSacuvaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPromeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIzmena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObrisi)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnObrisi)
                    .addComponent(btnIzmena)
                    .addComponent(btnPromeni))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNazivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNazivActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNazivActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        Skola skola=new Skola();
        skola.setNaziv(txtNaziv.getText());
        skola.setGrad(txtGrad.getText());
        int odg=JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da sacuvate novu skolu?","Potvrda",JOptionPane.YES_NO_OPTION);
        if(odg==0){
            skola.setId(Controller.getInstance().kreirajSkola(skola));
            if(skola.getId()!=0){
                JOptionPane.showMessageDialog(this, "Uspesno sacuvano");
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "Greska prilikom cuvanja!","Greska",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Nece biti sacuvano");
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        Skola sk=new Skola();
        sk.setId(Long.parseLong(txtId.getText()));
        sk.setNaziv(txtNaziv.getText());
        sk.setGrad(txtGrad.getText());
        int odg=JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da obrisete skolu?","Potvrda",JOptionPane.YES_NO_OPTION);
        if(odg==0){
            
            ArrayList<Takmicenje> takmicenje_brisanje=Controller.getInstance().vratiListuTakmicenja(sk);
            ArrayList<StavkaTakmicenja> stvake_brisanje=new ArrayList<StavkaTakmicenja>();
            for(Takmicenje t:takmicenje_brisanje){
                ArrayList<StavkaTakmicenja> li=Controller.getInstance().vratiListuStavkiTakmicenja(t);
                for(StavkaTakmicenja sss:li){
                    stvake_brisanje.add(sss);
                }
            }
            for(Takmicenje tt:takmicenje_brisanje){
                if(Controller.getInstance().obrisiSala(tt)){
                }
            }
            
            for(StavkaTakmicenja st:stvake_brisanje){
                if(Controller.getInstance().obrisiStavkuStavke(st)){
                }
            }
            for(Takmicenje t:takmicenje_brisanje){
                if(Controller.getInstance().obrisiStavkuTakmicenja(t)){
                }
            }
            
            if(Controller.getInstance().obrisiTakmicenje(sk)){
                if(Controller.getInstance().obrisiSkola(sk)){
                    JOptionPane.showMessageDialog(this, "Uspesno obrisano");
                    this.setVisible(false);
                    new PrikaSkolaForm(null, true).setVisible(true);
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Nece biti obrisano");
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed
       btnIzmena.setVisible(true);
       btnPromeni.setVisible(false);
       txtNaziv.setEnabled(true);
    }//GEN-LAST:event_btnPromeniActionPerformed

    private void btnIzmenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmenaActionPerformed
        Skola skolaZaIzmenu=new Skola();
        skolaZaIzmenu.setId(Long.parseLong(txtId.getText()));
        skolaZaIzmenu.setNaziv(txtNaziv.getText());
        int odg=JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da sacuvate izmene?","Potvrda",JOptionPane.YES_NO_OPTION);
        if(odg==0){
            if(Controller.getInstance().promeniSkola(skolaZaIzmenu)){
                JOptionPane.showMessageDialog(this, "Uspesno izmenjeno");
                this.setVisible(false);
                new PrikaSkolaForm(null, true).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Greska prilikom cuvanja izmena u bazi","Greska",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Nece biti izmenjeno!");
        }
    }//GEN-LAST:event_btnIzmenaActionPerformed

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
            java.util.logging.Logger.getLogger(SkolaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SkolaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SkolaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SkolaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SkolaForm dialog = new SkolaForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    
    private void forInsert(){
        txtId.setVisible(false);
        lblId.setVisible(false);
        btnObrisi.setVisible(false);
        btnIzmena.setVisible(false);
        btnPromeni.setVisible(false);
    }
    
    private void forView(Skola sk){
        btnSacuvaj.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        txtId.setText(sk.getId()+"");
        txtNaziv.setText(sk.getNaziv());
        txtGrad.setText(sk.getGrad());
        txtNaziv.setEnabled(false);
        txtGrad.setEnabled(false);
        txtId.setEnabled(false);
        btnIzmena.setVisible(false);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmena;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtGrad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables
}
