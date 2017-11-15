package ListaLuokat;

import static Kayttoliittyma.Kayttoliittyma.Nimet;
import static Kayttoliittyma.Kayttoliittyma.Tiedostot;
import static Kayttoliittyma.Kayttoliittyma.Tulostettavat;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;

public class ListaPopupListener implements ActionListener{
    
    private final JList lista;
    
    public ListaPopupListener(JList lista){
        this.lista = lista;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        switch (ae.getActionCommand()) {
            case "Poista":
                String Poistettava = (String)lista.getSelectedValue();
                for(int i = 0; i < Nimet.size() ; i++){
                    if(Nimet.get(i).equals(Poistettava)){
                        System.out.println(Nimet.get(i)+" "+Tiedostot.get(i)+" "+Tulostettavat.get(i)+" poistetaan");
                        Nimet.remove(i);
                        Tiedostot.remove(i);
                        Tulostettavat.remove(i);
                    }
                }
                lista.setListData(Nimet.toArray());
                lista.clearSelection();
                break;
            case "Avaa":
                {
                    String valittu = (String)lista.getSelectedValue();
                    for(int i = 0 ; i < Nimet.size(); i++){
                        if(Tiedostot.get(i).getName().equals(valittu)){
                            try{
                                Desktop.getDesktop().open(Tiedostot.get(i));
                            }catch(IOException exception){                             
                                System.out.println(exception);
                            }
                        }
                    }
                    break;
                }
            case "Asetukset":{
                String valittu = (String)lista.getSelectedValue();
                    for(int i = 0 ; i < Nimet.size(); i++){
                        if(Tulostettavat.get(i).getNimi().equals(valittu)){
                            System.out.println("Avataan asetukset tiedostolle "+Tulostettavat.get(i).getNimi());
                            Kayttoliittyma.Kayttoliittyma.asetuksetPopup.NaytaYksilo(Tulostettavat.get(i));
                            break;
                        }
                    }
                break;
            }      
            case "Tiedostosijainti":{
                String valittu = (String)lista.getSelectedValue();
                for(int i = 0; i < Tulostettavat.size(); i++){
                    if(Tulostettavat.get(i).getNimi().equals(valittu)){
                        try {
                            Runtime.getRuntime().exec("explorer.exe /select,"+Tulostettavat.get(i).getTiedosto().getPath());
                            break;
                        } catch (IOException ex) {
                            Logger.getLogger(ListaPopupListener.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                break;
            }
        }
    }
}
