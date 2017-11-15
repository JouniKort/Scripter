package Tulostus;

import java.io.File;

public class Tulostettava {
    
    private final String nimi;
    private final File tiedosto;
    private TulostusAsetukset asetukset = null;
    
    public Tulostettava(File tiedosto){
        this.tiedosto = tiedosto;
        nimi = tiedosto.getName();
        System.out.println("Uusi tulostettava "+nimi);
        asetukset = new TulostusAsetukset(tiedosto);
    }
    
    public String getNimi(){
        return nimi;
    }
    
    public File getTiedosto(){
        return tiedosto;
    }
    
    public TulostusAsetukset getAsetukset(){
        return asetukset;
    }
    
    public void TeeAsetukset(String Tulostin, String Paperi, String Orientaatio, String Alue, String vari, int maara, String pois, String PageSetup, String ViewNimi){     
        asetukset.AsetaOmat(Tulostin, Paperi, Orientaatio, Alue, vari, maara, pois, PageSetup, ViewNimi);
    }
}
