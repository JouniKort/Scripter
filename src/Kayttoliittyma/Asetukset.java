/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kayttoliittyma;

import Tulostus.Tulostettava;
import Tulostus.TulostusAsetukset;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.standard.Media;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Seiska
 */
public class Asetukset extends javax.swing.JDialog {

    private boolean Vakio = false;
    private TulostusAsetukset asetukset = null;
    private Tulostettava tulostettava = null;
    private final PrintService[] printServices;
    private final ArrayList<String> PaperiLista = new ArrayList<>(Arrays.asList("iso-a4","iso-a3","iso-a2","iso-a1","iso-a0"));
    private final ArrayList<String> PaperiListaLyhennykset = new ArrayList<>(Arrays.asList("A4","A3","A2","A1","A0"));
    
    public Asetukset(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        printServices = PrintServiceLookup.lookupPrintServices(null, null);
        System.out.println("Tulostimia: " + printServices.length);
        for (PrintService printer : printServices)
            jComboBox1.addItem(printer.getName());
        jSpinner1.setModel(new SpinnerNumberModel(0, 0, 100, 1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelTulostin = new javax.swing.JLabel();
        LabelPaperi = new javax.swing.JLabel();
        LabelOrientaatio = new javax.swing.JLabel();
        LabelAlue = new javax.swing.JLabel();
        NappulaOK = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        LabelVari = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        LabelViewLkm = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jTextField1 = new javax.swing.JTextField();
        LabelPoissulje = new javax.swing.JLabel();
        LabelPageSetup = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        LabelViewNimi = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LabelTulostin.setText("Tulostin");

        LabelPaperi.setText("Paperi");

        LabelOrientaatio.setText("Orientaatio");

        LabelAlue.setText("Alue");

        NappulaOK.setText("OK");
        NappulaOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaOKActionPerformed(evt);
            }
        });

        jComboBox1.setPreferredSize(new java.awt.Dimension(170, 20));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setPreferredSize(new java.awt.Dimension(170, 20));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Landscape", "Portrait" }));
        jComboBox3.setPreferredSize(new java.awt.Dimension(170, 20));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Layout", "Display", "Limits", "Extents", "Window" }));
        jComboBox4.setPreferredSize(new java.awt.Dimension(170, 20));

        LabelVari.setText("Väri");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "monochrome.ctb", "Grayscale.ctb", "Fill Patterns.ctb", "DWF Virtual Pens.ctb", "acad.ctb", "none" }));
        jComboBox5.setPreferredSize(new java.awt.Dimension(170, 20));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        LabelViewLkm.setText("Viewien lkm.");

        jSpinner1.setPreferredSize(new java.awt.Dimension(35, 20));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        LabelPoissulje.setText("Poissulje");

        LabelPageSetup.setText("Pagesetup");

        jComboBox6.setPreferredSize(new java.awt.Dimension(170, 20));

        LabelViewNimi.setText("Viewin nimi");

        jTextField2.setText("View");
        jTextField2.setMaximumSize(new java.awt.Dimension(170, 20));
        jTextField2.setPreferredSize(new java.awt.Dimension(170, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelOrientaatio)
                                    .addComponent(LabelAlue)
                                    .addComponent(LabelPaperi)
                                    .addComponent(LabelTulostin)
                                    .addComponent(LabelVari))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelViewLkm)
                                    .addComponent(LabelPageSetup))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                            .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LabelPoissulje, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1))))
                            .addComponent(LabelViewNimi))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(NappulaOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTulostin)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPaperi)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelOrientaatio)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelAlue)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelVari)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPageSetup)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelViewLkm)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPoissulje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelViewNimi)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NappulaOK)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AsetaArvot(){
        System.out.println("PageSetuppeja: "+Kayttoliittyma.PageSetupit.size());
        jComboBox6.removeAllItems();
        for(File i : Kayttoliittyma.PageSetupit){
            jComboBox6.addItem(i.getName());
        }
        String TulostinArvo = Kayttoliittyma.vakioAsetukset.getTulostin();
        String OrientaationArvo = Kayttoliittyma.vakioAsetukset.getOrientaatio();
        String AlueArvo = Kayttoliittyma.vakioAsetukset.getAlue();
        String VariArvo = Kayttoliittyma.vakioAsetukset.getVari();
        int maara = 0;
        String poissuljetut = "";
        String PageSetupArvo = "";
        if(asetukset != null){
            TulostinArvo = asetukset.getTulostin();
            OrientaationArvo = asetukset.getOrientaatio();
            AlueArvo = asetukset.getAlue();
            VariArvo = asetukset.getVari();
            maara = asetukset.getViewLukumaara();
            poissuljetut = asetukset.getPoissuljetutString();
            PageSetupArvo = asetukset.getPageSetup();
        }
        for(int i = 0; i<printServices.length; i++){
            if(printServices[i].getName().equals(TulostinArvo)){
                jComboBox1.setSelectedIndex(i);
                AsetaPaperi(printServices[i]);
                break;
            }
        }
        for(int i = 0; i<jComboBox3.getItemCount(); i++){
            if(jComboBox3.getItemAt(i).toString().equals(OrientaationArvo)){
                jComboBox3.setSelectedIndex(i);
                break;
            }
        }
        for(int i = 0; i<jComboBox4.getItemCount(); i++){
            if(jComboBox4.getItemAt(i).toString().equals(AlueArvo)){
                jComboBox4.setSelectedIndex(i);
                break;
            }
        }
        for(int i = 0; i<jComboBox5.getItemCount(); i++){
            if(jComboBox5.getItemAt(i).toString().equals(VariArvo)){
                jComboBox5.setSelectedIndex(i);
                break;
            }
        }
        for(int i = 0; i<jComboBox6.getItemCount(); i++){
            if(jComboBox6.getItemAt(i).toString().equals(PageSetupArvo)){
                jComboBox6.setSelectedIndex(i);
                break;
            }
        }
        jSpinner1.setValue(maara);
        jTextField1.setText(poissuljetut);
    }
    
    private void AsetaPaperi(PrintService service){
        jComboBox2.removeAllItems();
        Media[] media = (Media[])service.getSupportedAttributeValues(Media.class, null, null);
        String PaperiArvo = Kayttoliittyma.vakioAsetukset.getPaperi();
        if(asetukset != null){
            PaperiArvo = asetukset.getPaperi();
        }
        int indeksi = 0;
        for (Media media1 : media) {
            String paperi = media1.toString();
            if(PaperiLista.contains(paperi)){
                jComboBox2.addItem(PaperiListaLyhennykset.get(PaperiLista.indexOf(paperi)));
                if(PaperiListaLyhennykset.get(PaperiLista.indexOf(paperi)).equals(PaperiArvo)){
                    jComboBox2.setSelectedIndex(indeksi);
                }
                indeksi++;
                
            }
        }
    }
    
    private void NappulaOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaOKActionPerformed
        if(Vakio){
            File Tiedosto = new File(Kayttoliittyma.KansioPolku+"\\TulostusAsetukset.txt");
            try {
                try (PrintWriter writer = new PrintWriter(Tiedosto)) {
                    String newLine = System.getProperty("line.separator");
                    writer.write("Tulostin "+jComboBox1.getSelectedItem().toString()+newLine);
                    writer.write("Paperi "+jComboBox2.getSelectedItem().toString()+newLine);
                    writer.write("Orientaatio "+jComboBox3.getSelectedItem().toString()+newLine);
                    writer.write("Alue "+jComboBox4.getSelectedItem().toString()+newLine);  
                    writer.write("Vari "+jComboBox5.getSelectedItem().toString()+newLine);
                    writer.write("PageSetup "+jComboBox6.getSelectedItem().toString()+newLine);
                }             
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Asetukset.class.getName()).log(Level.SEVERE, null, ex);
            }
            Kayttoliittyma.vakioAsetukset.PaivitaVakiot();
            if(!Kayttoliittyma.Tulostettavat.isEmpty()){
                for(Tulostettava i : Kayttoliittyma.Tulostettavat){
                    if(!i.getAsetukset().getOmatAsetukset())
                        i.getAsetukset().HaeAsetukset();
                }
            }      
        }else{
            boolean AsetuksetMuutettu = tulostettava.getAsetukset().AsetuksetMuutettu(jComboBox1.getSelectedItem().toString(),jComboBox2.getSelectedItem().toString(),
                    jComboBox3.getSelectedItem().toString(), jComboBox4.getSelectedItem().toString(),jComboBox5.getSelectedItem().toString(),
                    (int)jSpinner1.getValue(),jTextField1.getText(), jComboBox6.getSelectedItem().toString(), jTextField2.getText());
            if(AsetuksetMuutettu){
                System.out.println("Asetukset muutettu");
                ListaLuokat.ListaListCellRenderer.Muutettu = ListaLuokat.ListaListCellRenderer.Muutettu + tulostettava.getNimi();
                asetukset.AsetaOmat(jComboBox1.getSelectedItem().toString(),jComboBox2.getSelectedItem().toString(),
                        jComboBox3.getSelectedItem().toString(),jComboBox4.getSelectedItem().toString(),jComboBox5.getSelectedItem().toString(),
                        (int)jSpinner1.getValue(), jTextField1.getText(), jComboBox6.getSelectedItem().toString(),jTextField2.getText());
            }else{
                System.out.println("Asetuksia ei muutettu");
            }
        }
        Vakio = false;
        asetukset = null;
        tulostettava = null;
        this.setVisible(false);
    }//GEN-LAST:event_NappulaOKActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(this.isVisible() || Vakio){
            for(PrintService i : printServices){
                if(i.getName().equals(jComboBox1.getSelectedItem().toString())){
                    AsetaPaperi(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    public void NaytaVakio(){
        Vakio = true;
        AsetaArvot();
        this.setVisible(true);
    }
    
    public void NaytaYksilo(Tulostettava tulostettava){
        this.tulostettava = tulostettava;
        if(tulostettava.getAsetukset() != null){
            this.asetukset = tulostettava.getAsetukset();
            System.out.println("Asetukset löydetty");
            AsetaArvot();
        }else{
            AsetaArvot();
        }
        this.setVisible(true);
    }
    
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
            java.util.logging.Logger.getLogger(Asetukset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asetukset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asetukset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asetukset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Asetukset dialog = new Asetukset(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelAlue;
    private javax.swing.JLabel LabelOrientaatio;
    private javax.swing.JLabel LabelPageSetup;
    private javax.swing.JLabel LabelPaperi;
    private javax.swing.JLabel LabelPoissulje;
    private javax.swing.JLabel LabelTulostin;
    private javax.swing.JLabel LabelVari;
    private javax.swing.JLabel LabelViewLkm;
    private javax.swing.JLabel LabelViewNimi;
    private javax.swing.JButton NappulaOK;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
