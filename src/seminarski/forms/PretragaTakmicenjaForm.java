/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package seminarski.forms;
import seminarski.domain.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import seminarski.controller.Controller;
import seminarski.table_model.StavkaTableModel;
import seminarski.table_model.StavkeStavkiTableModel;
import seminarski.table_model.TakmicenjeTableModel;
/**
 *
 * @author pc
 */
public class PretragaTakmicenjaForm extends javax.swing.JDialog {

    /**
     * Creates new form PrikazTakmicenjaForm
     */
    public PretragaTakmicenjaForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Pretraga takmicenja");
        btnDetalji1.setVisible(false);
        btnDetalji2.setVisible(false);
        btnRezultati.setVisible(false);
        this.remove(jScrollPane1);
        popuniComboPredmet();
        comboPredmet.addActionListener(event->{
            ArrayList<Takmicenje> list=Controller.getInstance().vratiListuTakmicenja((Predmet)comboPredmet.getSelectedItem());
            for(Takmicenje t:list){
                comboNivo.addItem(t.getNivo());
            }
            //comboNivo.setSelectedItem(null);
        });
        
        comboNivo.addActionListener(e->{
            Predmet p=(Predmet)comboPredmet.getSelectedItem();
            NivoTakmicenja nt=(NivoTakmicenja)comboNivo.getSelectedItem();
            ArrayList<StavkaTakmicenja> lista=Controller.getInstance().vratiListuStvaki(p, nt);
            for(StavkaTakmicenja st:lista){
                comboRazred.addItem(st.getRazred());
            }
            //comboRazred.setSelectedItem(null);
        });
        
        comboRazred.addActionListener(eve->{
            this.add(jScrollPane1);
            btnRezultati.setVisible(true);
            tableTakmicenje.setVisible(true);
            ArrayList<StavkaTakmicenja> list_stavka=Controller.getInstance().vratiListuStvaki((Predmet)comboPredmet.getSelectedItem(),(NivoTakmicenja)comboNivo.getSelectedItem());
            ArrayList<StavkaTakmicenja> konacna=new ArrayList<StavkaTakmicenja>();
            for(StavkaTakmicenja st:list_stavka){
                if(st.getRazred().equals((Razred)comboRazred.getSelectedItem())){
                    st.setRazred((Razred)comboRazred.getSelectedItem());
                    konacna.add(st);
                }
            }
            if(konacna.size()==1){
                StavkaTakmicenja stavka=konacna.getFirst();
                try{
                    tableTakmicenje.setModel(new StavkeStavkiTableModel(stavka));
                }catch(Exception ex){
                    tableTakmicenje.setVisible(false);
                    JOptionPane.showMessageDialog(this, "Nema rezultata pretrage","Obavestenje",JOptionPane.WARNING_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Negde je problem","Greska",JOptionPane.ERROR_MESSAGE);
            }
            
        });
        
         btnRezultati.addActionListener(t->{
             try{
                 TableModel tm=tableTakmicenje.getModel();
                 StavkeStavkiTableModel stm=(StavkeStavkiTableModel)tm;
                 int index=tableTakmicenje.getSelectedRow();
                 StavkaStavkeTakmicenja sst=stm.get(index);
                 this.setVisible(false);
                 new UnosRezultataForm(null, true, sst, sst.getStavka(), sst.getUcenik()).setVisible(true);
             }catch(ArrayIndexOutOfBoundsException exception){
                 JOptionPane.showMessageDialog(this, "Morate odabrati iz tabele","Greska",JOptionPane.ERROR_MESSAGE);
             }
         });
    }
    
    
    
    
    public PretragaTakmicenjaForm(java.awt.Frame parent, boolean modal,String izbor) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Pretraga takmicenja");
        this.remove(jScrollPane1);
        btnDetalji1.setVisible(false);
        btnDetalji2.setVisible(false);
        btnRezultati.setVisible(false);
        popuniComboNivo();
        popuniComboPredmet();
        popuniComboRazred();
        switch(izbor){
            case "nivo":
                lblPredmet.setVisible(false);
                comboPredmet.setVisible(false);
                lblRazred.setVisible(false);
                comboRazred.setVisible(false);
                comboNivo.addActionListener(event->{
                    this.add(jScrollPane1);
                    try{
                        btnDetalji1.setVisible(true);
                        tableTakmicenje.setVisible(true);
                        tableTakmicenje.setModel(new TakmicenjeTableModel((NivoTakmicenja)comboNivo.getSelectedItem()));
                        btnDetalji1.addActionListener(ee->{
                            try{
                                TableModel tm=tableTakmicenje.getModel();
                                TakmicenjeTableModel ttm=(TakmicenjeTableModel)tm;
                                int index=tableTakmicenje.getSelectedRow();
                                Takmicenje izabran=ttm.get(index);
                                try{
                                    btnDetalji1.setVisible(false);
                                    btnDetalji2.setVisible(true);
                                    tableTakmicenje.setVisible(true);
                                    tableTakmicenje.setModel(new StavkaTableModel(izabran));
                                    try{
                                        TableModel tmm=tableTakmicenje.getModel();
                                        StavkaTableModel stm=(StavkaTableModel)tmm;
                                        int iindex=tableTakmicenje.getSelectedRow();
                                        StavkaTakmicenja stavka_izabrana=stm.get(index);
                                        btnDetalji2.addActionListener(dog->{
                                            try{
                                                btnDetalji2.setVisible(false);
                                                tableTakmicenje.setVisible(true);
                                                tableTakmicenje.setModel(new StavkeStavkiTableModel(stavka_izabrana));
                                            }catch(Exception ev){
                                                JOptionPane.showMessageDialog(this, "Nema rezltata pretrage","Obavestenje",JOptionPane.ERROR_MESSAGE);
                                            }
                                        });
                                    }catch(ArrayIndexOutOfBoundsException e){
                                        JOptionPane.showMessageDialog(this, "Morate izabrati iz tabele","Greska",JOptionPane.ERROR_MESSAGE);
                                    }
                                }catch(Exception e){
                                    tableTakmicenje.setVisible(false);
                                    JOptionPane.showMessageDialog(this, "Nema rezultata pretrage","Greska",JOptionPane.ERROR_MESSAGE);
                                }
                            }catch(ArrayIndexOutOfBoundsException e){
                                JOptionPane.showMessageDialog(this, "Morate odabrati iz tabele","Greska",JOptionPane.ERROR_MESSAGE);
                            }
                        });
                    }catch(Exception ex){
                        tableTakmicenje.setVisible(false);
                        JOptionPane.showMessageDialog(this, "Nema rezultata pretrage","Obavestenje",JOptionPane.ERROR_MESSAGE);
                    }
                });
                break;
            case "predmet":
                lblNivo.setVisible(false);
                comboNivo.setVisible(false);
                lblRazred.setVisible(false);
                comboRazred.setVisible(false);
                comboPredmet.addActionListener(event->{
                    this.add(jScrollPane1);
                    try{
                        btnDetalji1.setVisible(true);
                        tableTakmicenje.setVisible(true);
                        tableTakmicenje.setModel(new TakmicenjeTableModel((Predmet)comboPredmet.getSelectedItem()));
                        btnDetalji1.addActionListener(a->{
                            try{
                                TableModel tm=tableTakmicenje.getModel();
                                TakmicenjeTableModel ttm=(TakmicenjeTableModel)tm;
                                int index=tableTakmicenje.getSelectedRow();
                                Takmicenje izabrann=ttm.get(index);
                                try{
                                    btnDetalji1.setVisible(false);
                                    btnDetalji2.setVisible(true);
                                    tableTakmicenje.setVisible(true);
                                    tableTakmicenje.setModel(new StavkaTableModel(izabrann));
                                    try{
                                        TableModel tmm=tableTakmicenje.getModel();
                                        StavkaTableModel stm=(StavkaTableModel)tmm;
                                        int iindex=tableTakmicenje.getSelectedRow();
                                        StavkaTakmicenja stavka_izabranaa=stm.get(index);
                                        btnDetalji2.addActionListener(b->{
                                            try{
                                                btnDetalji2.setVisible(false);
                                                tableTakmicenje.setVisible(true);
                                                tableTakmicenje.setModel(new StavkeStavkiTableModel(stavka_izabranaa));
                                            }catch(Exception ev){
                                                JOptionPane.showMessageDialog(this, "Nema rezltata pretrage","Obavestenje",JOptionPane.ERROR_MESSAGE);
                                            }
                                        });
                                    }catch(ArrayIndexOutOfBoundsException ex){
                                        JOptionPane.showMessageDialog(this, "Morate izabrati iz tabele","Greska",JOptionPane.ERROR_MESSAGE);
                                    }
                                }catch(Exception e){
                                    tableTakmicenje.setVisible(false);
                                    JOptionPane.showMessageDialog(this, "Nema rezultata pretrage","Greska",JOptionPane.ERROR_MESSAGE);
                                }
                            }catch(ArrayIndexOutOfBoundsException e){
                                JOptionPane.showMessageDialog(this, "Morate izabrati iz tabele","Greska",JOptionPane.ERROR_MESSAGE);
                            }
                        });
                    }catch(Exception ex){
                        tableTakmicenje.setVisible(false);
                        JOptionPane.showMessageDialog(this, "Nema rezultata pretrage","Obavestenje",JOptionPane.ERROR_MESSAGE);
                    }
                });
                break;
            case "razred":
                lblNivo.setVisible(false);
                comboNivo.setVisible(false);
                lblPredmet.setVisible(false);
                comboPredmet.setVisible(false);
                comboRazred.addActionListener(event->{
                this.add(jScrollPane1);
                    btnDetalji1.setVisible(true);
                    try{
                        tableTakmicenje.setVisible(true);
                        tableTakmicenje.setModel(new StavkaTableModel((Razred)comboRazred.getSelectedItem()));
                    }catch(Exception eex){
                        tableTakmicenje.setVisible(false);
                        JOptionPane.showMessageDialog(this, "Nema rezultata pretrage","Obezvestenje",JOptionPane.ERROR_MESSAGE);
                    }
                });
                btnDetalji1.addActionListener(ev->{
                    try{
                        TableModel tm=tableTakmicenje.getModel();
                        StavkaTableModel stm=(StavkaTableModel)tm;
                        int index=tableTakmicenje.getSelectedRow();
                        StavkaTakmicenja i=stm.get(index);
                        tableTakmicenje.setModel(new StavkeStavkiTableModel(i));
                    }catch(ArrayIndexOutOfBoundsException e){
                        JOptionPane.showMessageDialog(this, "Morate izabrati iz tabele","Greska",JOptionPane.ERROR_MESSAGE);
                    }
                });
                break;
        }
           
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableTakmicenje = new javax.swing.JTable();
        lblPredmet = new javax.swing.JLabel();
        comboPredmet = new javax.swing.JComboBox<>();
        lblNivo = new javax.swing.JLabel();
        comboNivo = new javax.swing.JComboBox<>();
        lblRazred = new javax.swing.JLabel();
        comboRazred = new javax.swing.JComboBox<>();
        btnDetalji1 = new javax.swing.JButton();
        btnRezultati = new javax.swing.JButton();
        btnDetalji2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableTakmicenje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableTakmicenje);

        lblPredmet.setText("odaberite predmet iz kog se takmicenje odnosi:");

        lblNivo.setText("odaberite nivo takmicenja:");

        lblRazred.setText("odaberite razred iz kog se organizuje takmicenje:");

        btnDetalji1.setText("Uvid u detalje");

        btnRezultati.setText("Unos rezultata");

        btnDetalji2.setText("Uvid u detalje");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNivo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRazred, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(lblPredmet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(comboRazred, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboNivo, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRezultati)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalji2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalji1)
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPredmet)
                    .addComponent(comboPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNivo)
                    .addComponent(comboNivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRazred)
                    .addComponent(comboRazred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetalji1)
                    .addComponent(btnRezultati)
                    .addComponent(btnDetalji2))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PretragaTakmicenjaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PretragaTakmicenjaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PretragaTakmicenjaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PretragaTakmicenjaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PretragaTakmicenjaForm dialog = new PretragaTakmicenjaForm(new javax.swing.JFrame(), true);
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
    
    private void popuniComboPredmet(){
        ArrayList<Predmet> list=Controller.getInstance().vratiListuSviPredmet();
        for(Predmet p:list){
            comboPredmet.addItem(p);
        }
        comboPredmet.setSelectedItem(null);
    }
    
    private void popuniComboNivo(){
        ArrayList<NivoTakmicenja> lista=Controller.getInstance().vratiListuSviNivoiTakmicenja();
        for(NivoTakmicenja n:lista){
            comboNivo.addItem(n);
        }
        comboNivo.setSelectedItem(null);
    }
    
    private void popuniComboRazred(){
        ArrayList<Razred> list=Controller.getInstance().vratiListuSviRazred();
        for(Razred r:list){
            comboRazred.addItem(r);
        }
        comboRazred.setSelectedItem(null);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji1;
    private javax.swing.JButton btnDetalji2;
    private javax.swing.JButton btnRezultati;
    private javax.swing.JComboBox<NivoTakmicenja> comboNivo;
    private javax.swing.JComboBox<Predmet> comboPredmet;
    private javax.swing.JComboBox<Razred> comboRazred;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNivo;
    private javax.swing.JLabel lblPredmet;
    private javax.swing.JLabel lblRazred;
    private javax.swing.JTable tableTakmicenje;
    // End of variables declaration//GEN-END:variables
}
