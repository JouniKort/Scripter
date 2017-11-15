package Tulostus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TulostusAsetukset {
    
    private final File tiedosto;
    private static String Tulostin = "";
    private static String Paperi = "";
    private static String Orientaatio = "";
    private static String Alue = "";
    private static String Vari = "";
    private static String PageSetup = "";
    private String OmaTulostin = "";
    private String OmaPaperi = "";
    private String OmaOrientaatio = "";
    private String OmaAlue = "";
    private String OmaVari = "";
    private String OmaPageSetup = "";
    private int OmaViewMaara = 0;
    public static File Asetukset;
    private Scanner scanner;
    private boolean OmatAsetukset = false;
    private ArrayList<Integer> poissuljetut = new ArrayList<>();
    private String PoissuljetutString = "";
    private String OmaViewNimi = "View";
    
    public TulostusAsetukset(File tiedosto){
        this.tiedosto = tiedosto;
        System.out.println("Uusi TulostusAsetus tiedostolle "+ tiedosto.getName());
        PaivitaVakiot();
        HaeAsetukset();
    }
    
    public void PaivitaVakiot(){
        if(tiedosto.getName().equals("TulostusAsetukset.txt")){
            System.out.println("Päivitetään asetukset vakiot");
            Asetukset = tiedosto;
            Tulostin = "";
            try{
                scanner = new Scanner(Asetukset);
                while(scanner.hasNext()){
                    String rivi = scanner.next();
                    if(rivi.equals("Tulostin")){
                        while(true){
                            rivi = scanner.next();
                            if(rivi.equals("Paperi")){
                                Tulostin = Tulostin.substring(0, Tulostin.length()-1);
                                break;
                            }
                            Tulostin = Tulostin+rivi+" "; 
                        }        
                    } 
                    if(rivi.equals("Paperi")){
                        Paperi = scanner.next();
                    }                 
                    if(rivi.equals("Orientaatio")){
                        Orientaatio = scanner.next();
                    }
                    if(rivi.equals("Alue")){
                        Alue = scanner.next();
                    }
                    if(rivi.equals("Vari")){
                        Vari = scanner.next();
                    }
                    if(rivi.equals("PageSetup")){
                        PageSetup = scanner.next();
                    }
                }
                scanner.close();
            }catch(FileNotFoundException e){
                System.out.println(e);
            }
        }
        HaeAsetukset();
    }
    
    public void HaeAsetukset(){
        OmaTulostin = Tulostin;
        OmaPaperi = Paperi;
        OmaOrientaatio = Orientaatio;
        OmaAlue = Alue;
        OmaVari = Vari;
        OmaPageSetup = PageSetup;
    }
    
    public void AsetaOmat(String tulostin, String paperi, String orientaatio ,String alue, 
            String vari, int maara, String pois, String PageSetup, String ViewNimi){
        OmatAsetukset = true;
        OmaTulostin = tulostin;
        OmaPaperi = paperi;
        OmaOrientaatio = orientaatio;
        OmaAlue = alue;
        OmaVari = vari;
        OmaViewMaara = maara;
        OmaPageSetup = PageSetup;
        OmaViewNimi = ViewNimi;
        AsetaPoissuljetut(pois);
    }
    
    public boolean AsetuksetMuutettu(String tulostin, String paperi, String Orientaatio ,String alue, 
            String vari, int maara, String pois, String PageSetup, String ViewNimi){
        boolean Btulostin = true;
        boolean Bpaperi = true;
        boolean Borientaatio = true;
        boolean Balue = true;
        boolean Bvari = true;
        boolean Bmaara = true;
        boolean Bpois = true;
        boolean Bpagesetup = true;
        boolean BviewNimi = true;
        if(OmaTulostin.equals(tulostin)){
            Btulostin = false;
        }if(OmaPaperi.equals(paperi)){
            Bpaperi = false;
        }if(OmaOrientaatio.equals(Orientaatio)){
            Borientaatio = false;
        }if(OmaAlue.equals(alue)){
            Balue = false;
        }if(OmaVari.equals(vari)){
            Bvari = false;
        }if(OmaViewMaara == maara){
            Bmaara = false;
        }if(PoissuljetutString.equals(pois)){
            Bpois = false;
        }if(OmaPageSetup.equals(PageSetup)){
            Bpagesetup = false;
        }if(OmaViewNimi.equals(ViewNimi)){
            BviewNimi = false;
        }
        return Btulostin || Bpaperi || Borientaatio || Balue || Bvari || Bmaara || Bpois || Bpagesetup || BviewNimi;
    }
    
    public boolean getOmatAsetukset(){
        return OmatAsetukset;
    }
    
    public void AsetaPoissuljetut(String teksti){
        if(!teksti.trim().isEmpty()){
            System.out.println("Poissuljetut "+teksti);
            PoissuljetutString = teksti;
            poissuljetut.clear();
            String[] lista = teksti.split(",");
            for(String numero : lista){
                poissuljetut.add(Integer.parseInt(numero));
            }
        }
        
    }
    
    public String getPoissuljetutString(){
        return PoissuljetutString;
    }
    
    public ArrayList<Integer> getPoissuljetut(){
        return poissuljetut;
    }
    
    public String getNimi(){
        return tiedosto.getName().substring(0, tiedosto.getName().lastIndexOf("."));
    }
    
    public String getPaate(){
        return tiedosto.getName().substring(tiedosto.getName().lastIndexOf(".")+1, tiedosto.getName().length());
    }
    
    public int getViewLukumaara(){
        return OmaViewMaara;
    }
    
    public String getViewNimi(){
        return OmaViewNimi;
    }
    
    public String getTulostin(){
        return OmaTulostin;
    }
    
    public String getPaperi(){
        return OmaPaperi;
    }
    
    public String getVari(){
        return OmaVari;
    }
    
    public String getPaperinKoko(){
        String koko = "";
        switch(OmaPaperi){
            case "A0":
                koko = "(841.00 x 1189.00 MM)";
                break;
            case "A1":
                koko = "(594.00 x 841.00 MM)";
                break;
            case "A2":
                koko = "(420.00 x 594.00 MM)";
                break;
            case "A3":
                koko = "(297.00 x 420.00 MM)";
                break;
            case "A4":
                koko = "(210.00 x 297.00 MM)";
                break;
        }
        return koko;
    }
    
    public String getOrientaatio(){
        return OmaOrientaatio;
    }
    
    public String getAlue(){
        return OmaAlue;
    }
    
    public String getPolku(){
        return tiedosto.getPath();
    }
    
    public String getPageSetup(){
        return OmaPageSetup.substring(0,OmaPageSetup.lastIndexOf("."));
    }
}
