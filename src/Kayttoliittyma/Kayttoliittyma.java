/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kayttoliittyma;

import AutoCADpopup.AutoCADpopup;
import ListaLuokat.ListaListCellRenderer;
import ListaLuokat.ListaMouseAdapter;
import ListaLuokat.SkriptiListaCellRenderer;
import ListaLuokat.SkriptiListaMouseAdapter;
import Tulostus.Tulostettava;
import Tulostus.TulostusAsetukset;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Kayttoliittyma extends javax.swing.JFrame {

    public static ArrayList<Tulostettava> Tulostettavat = new ArrayList<>();
    public static ArrayList<String> Nimet = new ArrayList<>();
    public static ArrayList<File> Tiedostot = new ArrayList<>();
    public static ArrayList<File> PageSetupit = new ArrayList<>();
    public static ArrayList<File> Skriptit = new ArrayList<>();
    public static ArrayList<String> SkriptiNimet = new ArrayList<>();
    private String tiedostoSijainti = null;
    final File f = new File(Kayttoliittyma.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    public static String KansioPolku = "";
    private String KansioPolkuPohjat = "";
    public static TulostusAsetukset vakioAsetukset;
    public static Asetukset asetuksetPopup;
    public static String CADsijainti = "";
    private String BlockiNimet = "";
    private String BlockiAttr = "";
    private String BlockiTiedot = "";
    private final SkriptiListaMouseAdapter SLMA;
    
    public Kayttoliittyma() {
        String ClassPolku = f.getPath();
        KansioPolku = ClassPolku.substring(0, ClassPolku.lastIndexOf("\\"));
        KansioPolku = KansioPolku.substring(0,KansioPolku.lastIndexOf("\\"));
        KansioPolkuPohjat = KansioPolku+"\\Pohjat";   
        initComponents();
        this.setResizable(false);
        vakioAsetukset = new TulostusAsetukset(new File(KansioPolku+"\\TulostusAsetukset.txt"));
        asetuksetPopup = new Asetukset(this, true);
        JList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TarkistaAutoCAD();
        try{
            CADsijainti = new BufferedReader(new FileReader(KansioPolku+"\\AutoCAD.txt")).readLine();
        }catch(IOException e){
            System.out.println(e);
        }
        File pageDir = new File(Kayttoliittyma.KansioPolku+"\\PageSetupit\\");
        PageSetupit.addAll(Arrays.asList(pageDir.listFiles()));
        PaivitaScriptit();
        SLMA = new SkriptiListaMouseAdapter(ListaSkriptit, Muotti);
        ListaSkriptit.addMouseListener(SLMA);
        ListaSkriptit.setCellRenderer(new SkriptiListaCellRenderer());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Editori = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        Muotti = new javax.swing.JTextArea();
        NappulaTeeScripti = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Scripti = new javax.swing.JTextArea();
        NappulaTallennaPohja = new javax.swing.JButton();
        NappulaSelaaPohjat = new javax.swing.JButton();
        NappulaTalennaScripti = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListaSkriptit = new javax.swing.JList();
        NappulaPoista = new javax.swing.JButton();
        NappulaUusi = new javax.swing.JButton();
        Blockit = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TekstikenttaBlockit = new javax.swing.JTextField();
        TekstikenttaAttrib = new javax.swing.JTextField();
        TekstikenttaTieto = new javax.swing.JTextField();
        NappulaOkBlockit = new javax.swing.JButton();
        UusiTiedosto = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        TekstikenttaUusiNimi = new javax.swing.JTextField();
        NappulaOkNimi = new javax.swing.JButton();
        NappulaSelaa = new javax.swing.JButton();
        NappulaTyhjenna = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JList = new javax.swing.JList();
        NappulaTulostusAsetukset = new javax.swing.JButton();
        NappulaTulosta = new javax.swing.JButton();
        NappulaEditori = new javax.swing.JButton();
        PDFMuunnos = new javax.swing.JButton();
        TeePDF = new javax.swing.JButton();
        NappulaPaivitaBlockit = new javax.swing.JButton();
        NappulaBlockiAsetukset = new javax.swing.JButton();

        Editori.setTitle("Editori");

        Muotti.setColumns(20);
        Muotti.setRows(5);
        jScrollPane2.setViewportView(Muotti);

        NappulaTeeScripti.setText("Tee scripti");
        NappulaTeeScripti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaTeeScriptiActionPerformed(evt);
            }
        });

        Scripti.setColumns(20);
        Scripti.setRows(5);
        jScrollPane3.setViewportView(Scripti);

        NappulaTallennaPohja.setText("Tallenna pohja");
        NappulaTallennaPohja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaTallennaPohjaActionPerformed(evt);
            }
        });

        NappulaSelaaPohjat.setText("Selaa");
        NappulaSelaaPohjat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaSelaaPohjatActionPerformed(evt);
            }
        });

        NappulaTalennaScripti.setText("Tallenna scripti");
        NappulaTalennaScripti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaTalennaScriptiActionPerformed(evt);
            }
        });

        ListaSkriptit.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(ListaSkriptit);

        NappulaPoista.setText("Poista");
        NappulaPoista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaPoistaActionPerformed(evt);
            }
        });

        NappulaUusi.setText("Uusi");
        NappulaUusi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaUusiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditoriLayout = new javax.swing.GroupLayout(Editori.getContentPane());
        Editori.getContentPane().setLayout(EditoriLayout);
        EditoriLayout.setHorizontalGroup(
            EditoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditoriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EditoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditoriLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(NappulaSelaaPohjat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NappulaTeeScripti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NappulaTalennaScripti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NappulaPoista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NappulaUusi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NappulaTallennaPohja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        EditoriLayout.setVerticalGroup(
            EditoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditoriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EditoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addGroup(EditoriLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NappulaUusi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NappulaTallennaPohja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NappulaTeeScripti)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NappulaTalennaScripti)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NappulaSelaaPohjat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NappulaPoista)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel1.setText("Blockien nimet");

        jLabel2.setText("Attribuutin tagi");

        jLabel3.setText("Uusi tieto");

        NappulaOkBlockit.setText("OK");
        NappulaOkBlockit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaOkBlockitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BlockitLayout = new javax.swing.GroupLayout(Blockit.getContentPane());
        Blockit.getContentPane().setLayout(BlockitLayout);
        BlockitLayout.setHorizontalGroup(
            BlockitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlockitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BlockitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NappulaOkBlockit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BlockitLayout.createSequentialGroup()
                        .addGroup(BlockitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(BlockitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TekstikenttaBlockit)
                            .addComponent(TekstikenttaTieto, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(TekstikenttaAttrib))))
                .addContainerGap())
        );
        BlockitLayout.setVerticalGroup(
            BlockitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlockitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BlockitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TekstikenttaBlockit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BlockitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TekstikenttaAttrib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BlockitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TekstikenttaTieto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NappulaOkBlockit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Anna tiedostolle nimi:");

        NappulaOkNimi.setText("OK");
        NappulaOkNimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaOkNimiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UusiTiedostoLayout = new javax.swing.GroupLayout(UusiTiedosto.getContentPane());
        UusiTiedosto.getContentPane().setLayout(UusiTiedostoLayout);
        UusiTiedostoLayout.setHorizontalGroup(
            UusiTiedostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UusiTiedostoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UusiTiedostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TekstikenttaUusiNimi)
                    .addComponent(NappulaOkNimi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UusiTiedostoLayout.setVerticalGroup(
            UusiTiedostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UusiTiedostoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TekstikenttaUusiNimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NappulaOkNimi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NappulaSelaa.setText("Selaa");
        NappulaSelaa.setPreferredSize(new java.awt.Dimension(120, 23));
        NappulaSelaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaSelaaActionPerformed(evt);
            }
        });

        NappulaTyhjenna.setText("Tyhjennä");
        NappulaTyhjenna.setPreferredSize(new java.awt.Dimension(120, 23));
        NappulaTyhjenna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaTyhjennaActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(JList);

        NappulaTulostusAsetukset.setText("Tulostusasetukset");
        NappulaTulostusAsetukset.setPreferredSize(new java.awt.Dimension(90, 23));
        NappulaTulostusAsetukset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaTulostusAsetuksetActionPerformed(evt);
            }
        });

        NappulaTulosta.setText("Tulosta");
        NappulaTulosta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaTulostaActionPerformed(evt);
            }
        });

        NappulaEditori.setText("Editori");
        NappulaEditori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaEditoriActionPerformed(evt);
            }
        });

        PDFMuunnos.setText("Muunna .pdf");
        PDFMuunnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PDFMuunnosActionPerformed(evt);
            }
        });

        TeePDF.setText("Tee .pdf");
        TeePDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeePDFActionPerformed(evt);
            }
        });

        NappulaPaivitaBlockit.setText("Päivitä blockit");
        NappulaPaivitaBlockit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaPaivitaBlockitActionPerformed(evt);
            }
        });

        NappulaBlockiAsetukset.setText("Blockiasetukset");
        NappulaBlockiAsetukset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NappulaBlockiAsetuksetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NappulaSelaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NappulaTyhjenna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(NappulaTulostusAsetukset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NappulaBlockiAsetukset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NappulaTulosta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NappulaEditori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PDFMuunnos, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(TeePDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NappulaPaivitaBlockit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NappulaTyhjenna, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NappulaSelaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NappulaEditori)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NappulaTulosta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PDFMuunnos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TeePDF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NappulaPaivitaBlockit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NappulaTulostusAsetukset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NappulaBlockiAsetukset))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void PaivitaScriptit(){
        File pohjat = new File(KansioPolkuPohjat+"\\");
        Skriptit.clear();
        SkriptiNimet.clear();
        ListaSkriptit.removeAll();
        Skriptit.addAll(Arrays.asList(pohjat.listFiles()));
        System.out.println("Skriptejä löydetty: "+Skriptit.size());
        for(File i : Skriptit){
            SkriptiNimet.add(i.getName());
        }
        ListaSkriptit.setListData(SkriptiNimet.toArray());
    }
    
    private void TarkistaAutoCAD(){
        try{
            BufferedReader br1 = new BufferedReader(new FileReader(KansioPolku+"\\AutoCAD.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader(KansioPolku+"\\User.txt"));
            if(br1.readLine() == null || !br2.readLine().equals(System.getProperty("user.name"))){
                AutoCADpopup popup = new AutoCADpopup();
                this.addWindowFocusListener(new FocusKuuntelija(popup.getMenu(), this));
                popup.getMenu().setLocation(this.getX()+this.getWidth()/2-popup.getMenu().getPreferredSize().width/2,
                        this.getY()+this.getHeight()/2-popup.getMenu().getPreferredSize().height/2);
            }
            br1.close();
            br2.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    private void NappulaSelaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaSelaaActionPerformed
        JList.setCellRenderer(new ListaListCellRenderer());
        JFileChooser chooser = new JFileChooser();       
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(tiedostoSijainti != null){
            chooser.setCurrentDirectory(new File(tiedostoSijainti));
        }       
        FileNameExtensionFilter filtteri1 = new FileNameExtensionFilter(".dwg", "dwg");
        chooser.setFileFilter(filtteri1);
        chooser.setMultiSelectionEnabled(true);
        int vastaus = chooser.showDialog(this, null);
        switch(vastaus){
            case JFileChooser.APPROVE_OPTION:
                Tulostettavat.clear();
                Tiedostot.clear();
                Nimet.clear();
                try{
                    for(File i : chooser.getSelectedFiles()){
                        Tulostettavat.add(new Tulostettava(i));
                        Tiedostot.add(i);
                        Nimet.add(i.getName());
                    }
                    JList.addMouseListener(new ListaMouseAdapter(JList));
                    JList.setListData(Nimet.toArray());
                    tiedostoSijainti = Tiedostot.get(0).getPath().substring(0, Tiedostot.get(0).getPath().lastIndexOf("\\"));
                }catch(Exception e){
                    System.out.println(e);
                }
            default:
                
        }
    }//GEN-LAST:event_NappulaSelaaActionPerformed

    private void NappulaTyhjennaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaTyhjennaActionPerformed
        JList.setModel(new DefaultListModel());
    }//GEN-LAST:event_NappulaTyhjennaActionPerformed

    private void NappulaTeeScriptiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaTeeScriptiActionPerformed
        Scripti.setText(TeekriptiTeksti(Muotti.getText()));
        Scripti.setCaretPosition(0);
    }//GEN-LAST:event_NappulaTeeScriptiActionPerformed

    private void NappulaTallennaPohjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaTallennaPohjaActionPerformed
        if(SLMA.getAvattu() != null){
            try{
            String teksti = Muotti.getText();
            JFileChooser chooser = new JFileChooser();          
            chooser.setCurrentDirectory(new File(KansioPolkuPohjat));
            chooser.showSaveDialog(this);
            String polku = chooser.getSelectedFile().getPath();
            File tiedosto = new File(polku);
            Scanner scanner;
            try (FileWriter writer = new FileWriter(tiedosto)) {
                scanner = new Scanner(teksti);
                String newLine = System.getProperty("line.separator");
                while(scanner.hasNextLine()){
                    writer.append(scanner.nextLine()+newLine);
                }
            }
            scanner.close();
            }catch(HeadlessException | IOException e){
                System.out.println(e);
            }
        }else{
            Kirjoita(SLMA.getAvattu(),Muotti.getText());
        }  
    }//GEN-LAST:event_NappulaTallennaPohjaActionPerformed

    private void NappulaTulostusAsetuksetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaTulostusAsetuksetActionPerformed
        asetuksetPopup.NaytaVakio();
    }//GEN-LAST:event_NappulaTulostusAsetuksetActionPerformed

    public static String LueTiedosto(File tiedosto){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(tiedosto));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }
        String teksti = "";
        String line;
        try {
            while((line = br.readLine()) != null){
                teksti = teksti + line+"\n";
            }
        } catch (IOException ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teksti;
    }
    
    private String TeekriptiTeksti(String teksti){
        String Aloitus = "";
        String KeskiosaUusi = "";
        String Lopetus = "";
        String ViewAloitus = "";
        String ViewLopetus = "";
        try (Scanner scanner = new Scanner(teksti)) {
            String Keskiosa = "";
            boolean AloitusValmis = true;
            boolean KeskiosaValmis = false;
            boolean ViewAloitusValmis = true;
            boolean ViewLopetusValmis = true;
            if(teksti.contains("@AloitusLoppu")){
                AloitusValmis = false;
            }
            if(teksti.contains("@ViewAloitusLoppu")){
                ViewAloitusValmis = false;
                ViewLopetusValmis = false;
            }
            while(scanner.hasNextLine()){
                String rivi = scanner.nextLine();
                if(AloitusValmis && ViewAloitusValmis && KeskiosaValmis && ViewLopetusValmis){
                    Lopetus = Lopetus+rivi+"\n";
                }
                else if(AloitusValmis && ViewAloitusValmis && KeskiosaValmis && !ViewLopetusValmis){
                    if(rivi.contains("@ViewLopetusLoppu")){
                        ViewLopetusValmis = true;
                    }else{
                        ViewLopetus = ViewLopetus+rivi+"\n";
                    }
                }
                else if(AloitusValmis && ViewAloitusValmis && !KeskiosaValmis){
                    if(rivi.equals("@KeskiosaLoppu")){
                        KeskiosaValmis = true;
                    }else{
                        Keskiosa = Keskiosa+rivi+"\n";
                    }
                }
                else if(AloitusValmis && !ViewAloitusValmis){
                    if(rivi.equals("@ViewAloitusLoppu")){
                        ViewAloitusValmis = true;
                    }else{
                        ViewAloitus = ViewAloitus+rivi+"\n";
                    }
                }
                else if(!AloitusValmis){
                    if(rivi.equals("@AloitusLoppu")){
                        AloitusValmis = true;
                    }else{
                        Aloitus = Aloitus+rivi+"\n";
                    }
                }
            }
            if(Keskiosa.contains("@Nimi") || Keskiosa.contains("@Orientaatio") || Keskiosa.contains("@Ensimmäinen")||
                    Keskiosa.contains("@Paperi") || Keskiosa.contains("@Alue") || Keskiosa.contains("@Tulostin") ||
                    Keskiosa.contains("@Polku") || Keskiosa.contains("@Pääte") || Keskiosa.contains("@Mitat") ||
                    Keskiosa.contains("@Väri") || Keskiosa.contains("@ViewNimi") || Keskiosa.contains("@Tagit") ||
                    Keskiosa.contains("@Tiedot") || Keskiosa.contains("@Blockit") || Keskiosa.contains("@Tiedostosijainti") ||
                    Keskiosa.contains("@PageSetup") || Keskiosa.contains("@Kansiopolku") || Keskiosa.contains("@ViewNumero")){
                for(Tulostettava i : Tulostettavat){
                    String UusiKorvattu = Korvaa(i, Keskiosa);
                    String KeskiosaView = "";
                    if(UusiKorvattu.contains("@ViewNumero")){
                        ArrayList<Integer> pois = i.getAsetukset().getPoissuljetut();
                        for(int k = 1; k <= i.getAsetukset().getViewLukumaara(); k++){
                            if(!pois.contains(k)){
                                KeskiosaView = KeskiosaView+UusiKorvattu.replace("@ViewNumero", ""+k);
                            }
                        }
                        KeskiosaUusi = KeskiosaUusi + Korvaa(i, ViewAloitus) + KeskiosaView + Korvaa(i, ViewLopetus);
                    }else{
                        KeskiosaUusi = KeskiosaUusi + UusiKorvattu;
                    }
                    
                }
            }
        }
        if(Aloitus.contains("@Tiedostosijainti") || Aloitus.contains("@EnsimmäinenNimi") || Aloitus.contains("@EnsimmäinenPääte") || Aloitus.contains("@Kansiopolku")){
            Aloitus = Korvaa(Tulostettavat.get(0), Aloitus);
        }if(Lopetus.contains("@Tiedostosijainti") || Lopetus.contains("@EnsimmäinenNimi") || Lopetus.contains("@EnsimmäinenPääte") || Lopetus.contains("@Kansiopolku")){
            Lopetus = Korvaa(Tulostettavat.get(0), Lopetus);
        }
        
        return Aloitus+KeskiosaUusi+Lopetus;
    }
    
    private String Korvaa(Tulostettava i, String teksti){
        String KeskiosaKorvattu = teksti.replace("@Nimi", i.getAsetukset().getNimi());
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@Orientaatio",i.getAsetukset().getOrientaatio());
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@Paperi", i.getAsetukset().getPaperi());
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@Alue", i.getAsetukset().getAlue());
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@Tulostin", i.getAsetukset().getTulostin());
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@Polku", i.getAsetukset().getPolku());
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@Pääte", i.getAsetukset().getPaate());
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@Mitat", i.getAsetukset().getPaperinKoko());
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@ViewNimi", i.getAsetukset().getViewNimi());
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@Väri", i.getAsetukset().getVari());
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@PageSetupSijainti", KansioPolku+"\\PageSetupit\\");
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@PageSetup", i.getAsetukset().getPageSetup());
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@EnsimmäinenNimi", Tulostettavat.get(0).getAsetukset().getNimi());
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@EnsimmäinenPääte", Tulostettavat.get(0).getAsetukset().getPaate());
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@Tagit", BlockiAttr);
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@Blockit", BlockiNimet);
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@Tiedot", BlockiTiedot);
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@Tiedostosijainti", tiedostoSijainti);
        KeskiosaKorvattu = KeskiosaKorvattu.replace("@Kansiopolku", KansioPolku);
        return KeskiosaKorvattu;
    }
    
    private void luoSkritpti(String Skripti, String paate){
        File tiedosto;
        if(paate.equals("dsd")){
            tiedosto = new File(KansioPolku+"\\Tulostus.dsd");
            File Publish = new File(KansioPolku+"\\Scripti.scr");
            String publishSkripti = TeekriptiTeksti(LueTiedosto(new File(KansioPolkuPohjat+"\\Publish.txt")));
            Kirjoita(Publish, publishSkripti);
        }else{
            tiedosto = new File(KansioPolku+"\\Scripti.scr");
        }  
        Kirjoita(tiedosto, Skripti);
    }
    
    private void Kirjoita(File tiedosto, String Skripti){
        Scanner scanner;
        try(FileWriter writer = new FileWriter(tiedosto)){
            scanner = new Scanner(Skripti);
            String newLine = System.getProperty("line.separator");
            while(scanner.hasNextLine()){
                writer.append(scanner.nextLine()+newLine);
                }
            }catch(IOException e){
                System.out.println(e);
            }
        System.out.println("Scripti luotu "+tiedosto.getPath());
    }
    
    private void luoBatch(){
        try{
            File batch = new File(KansioPolku+"\\run.bat");
            DataOutputStream dos;
            try (FileOutputStream fos = new FileOutputStream(batch)) {
                dos = new DataOutputStream(fos);
                dos.writeBytes("\""+CADsijainti+"\" /b %1");
            }
            dos.close();
        }catch(IOException e){
            System.out.println(e);
        }
        System.out.println("batch luotu "+KansioPolku+"\\run.bat");
    }
    
    private void CMD(){
        String komento = "cmd /c start "+KansioPolku+"\\run.bat "+KansioPolku+"\\Scripti.scr";
        try {
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(komento);
            System.out.println("CMD komento ajettu");
        } catch (IOException ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Aja(String Pohja, String paate){
        String Skripti = TeekriptiTeksti(Pohja);
        if(paate.equals("dsd")){
            luoSkritpti(Skripti,paate);
            paate = "scr";
            Skripti = TeekriptiTeksti(LueTiedosto(new File(KansioPolkuPohjat+"\\Publish.txt")));
            luoSkritpti(Skripti, paate);
        }else{
            luoSkritpti(Skripti, paate);
        }
        luoBatch();
        CMD();  
    }
    
    private void NappulaTulostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaTulostaActionPerformed
        String Pohja = LueTiedosto(new File(KansioPolkuPohjat+"\\Tulostus.txt"));
        String paate = "scr";
        Aja(Pohja, paate);
    }//GEN-LAST:event_NappulaTulostaActionPerformed

    private void NappulaTalennaScriptiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaTalennaScriptiActionPerformed
        try{
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(tiedostoSijainti));
            chooser.showSaveDialog(this);
            String polku = chooser.getSelectedFile().getPath();
            File tiedosto = new File(polku);
            Scanner scanner;
            try (FileWriter writer = new FileWriter(tiedosto)) {
                scanner = new Scanner(Scripti.getText());
                String newLine = System.getProperty("line.separator");
                while(scanner.hasNextLine()){
                    writer.append(scanner.nextLine()+newLine);
                }
            }
            scanner.close();
        }catch(HeadlessException | IOException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_NappulaTalennaScriptiActionPerformed

    private void NappulaEditoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaEditoriActionPerformed
        Editori.pack();
        Editori.setVisible(true);
    }//GEN-LAST:event_NappulaEditoriActionPerformed

    private void PDFMuunnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PDFMuunnosActionPerformed
        String Pohja = LueTiedosto(new File(KansioPolkuPohjat+"\\DWG to PDF.txt"));
        String paate = "scr";
        Aja(Pohja, paate);
    }//GEN-LAST:event_PDFMuunnosActionPerformed

    private void TeePDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeePDFActionPerformed
        String Pohja = LueTiedosto(new File(KansioPolkuPohjat+"\\BatchPlot.txt"));
        String paate = "dsd";
        Aja(Pohja, paate);
    }//GEN-LAST:event_TeePDFActionPerformed

    private void NappulaOkBlockitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaOkBlockitActionPerformed
        BlockiNimet = TekstikenttaBlockit.getText();
        BlockiAttr = TekstikenttaAttrib.getText();
        BlockiTiedot = TekstikenttaTieto.getText();
        Blockit.setVisible(false);
        Blockit.dispose();
    }//GEN-LAST:event_NappulaOkBlockitActionPerformed

    private void NappulaBlockiAsetuksetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaBlockiAsetuksetActionPerformed
        TekstikenttaBlockit.setText(BlockiNimet);
        TekstikenttaAttrib.setText(BlockiAttr);
        TekstikenttaTieto.setText(BlockiTiedot);
        Blockit.pack();
        Blockit.setVisible(true);
    }//GEN-LAST:event_NappulaBlockiAsetuksetActionPerformed

    private void NappulaPaivitaBlockitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaPaivitaBlockitActionPerformed
        String pohja = LueTiedosto(new File(KansioPolkuPohjat+"\\BlockEdit.txt"));
        String paate = "scr";
        Aja(pohja, paate);
    }//GEN-LAST:event_NappulaPaivitaBlockitActionPerformed

    private void NappulaSelaaPohjatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaSelaaPohjatActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        chooser.setCurrentDirectory(new File(KansioPolkuPohjat));
        chooser.showOpenDialog(this);
        File Valittu = chooser.getSelectedFile();
        System.out.println(Valittu.getPath());
        try{
            try (Scanner scanner = new Scanner(Valittu)) {
                String teksti = "";
                while(scanner.hasNextLine()){
                    teksti = teksti + scanner.nextLine()+"\n";
                }
                Muotti.setText(teksti);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_NappulaSelaaPohjatActionPerformed

    private void NappulaPoistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaPoistaActionPerformed
        Object[] valinnat = {"Kyllä","Ei"};
        if(JOptionPane.showOptionDialog(Editori, "Poistetaanko tiedosto "+ListaSkriptit.getSelectedValue().toString()+"? Tiedosto poistuu pysyvästi!"
                , "Tiedoston poisto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, valinnat,valinnat[1]) == 0){
            int indeksi = ListaSkriptit.getSelectedIndex();
            System.out.println("Poistetaan: "+Skriptit.get(indeksi).getName());
            Skriptit.get(indeksi).delete();
            SkriptiNimet.remove(indeksi);
            Skriptit.remove(indeksi);
            PaivitaScriptit();
        }
        
    }//GEN-LAST:event_NappulaPoistaActionPerformed

    private void NappulaUusiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaUusiActionPerformed
        UusiTiedosto.pack();
        UusiTiedosto.setVisible(true);
    }//GEN-LAST:event_NappulaUusiActionPerformed

    private void NappulaOkNimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NappulaOkNimiActionPerformed
        UusiTiedosto.setVisible(false);
        File tiedosto = new File(KansioPolkuPohjat+"\\"+TekstikenttaUusiNimi.getText());
        try {
            tiedosto.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }
        UusiTiedosto.dispose();
        System.out.println("Uusi tiedosto luotu: "+tiedosto.getPath());
        PaivitaScriptit();
    }//GEN-LAST:event_NappulaOkNimiActionPerformed

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
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                System.out.println(info);
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Kayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kayttoliittyma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JFrame Blockit;
    private javax.swing.JFrame Editori;
    private javax.swing.JList JList;
    private javax.swing.JList ListaSkriptit;
    private javax.swing.JTextArea Muotti;
    private javax.swing.JButton NappulaBlockiAsetukset;
    private javax.swing.JButton NappulaEditori;
    private javax.swing.JButton NappulaOkBlockit;
    private javax.swing.JButton NappulaOkNimi;
    private javax.swing.JButton NappulaPaivitaBlockit;
    private javax.swing.JButton NappulaPoista;
    private javax.swing.JButton NappulaSelaa;
    private javax.swing.JButton NappulaSelaaPohjat;
    private javax.swing.JButton NappulaTalennaScripti;
    private javax.swing.JButton NappulaTallennaPohja;
    private javax.swing.JButton NappulaTeeScripti;
    private javax.swing.JButton NappulaTulosta;
    private javax.swing.JButton NappulaTulostusAsetukset;
    private javax.swing.JButton NappulaTyhjenna;
    private javax.swing.JButton NappulaUusi;
    private javax.swing.JButton PDFMuunnos;
    private javax.swing.JTextArea Scripti;
    private javax.swing.JButton TeePDF;
    private javax.swing.JTextField TekstikenttaAttrib;
    private javax.swing.JTextField TekstikenttaBlockit;
    private javax.swing.JTextField TekstikenttaTieto;
    private javax.swing.JTextField TekstikenttaUusiNimi;
    private javax.swing.JFrame UusiTiedosto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
