package ListaLuokat;

import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

public class ListaPopup {
    
    private final JPopupMenu menu;
    private final JList lista;
    
    public ListaPopup(JList lista){
        this.lista = lista;
        ListaPopupListener listener = new ListaPopupListener(lista);
        menu = new JPopupMenu();
        JMenuItem Poista = new JMenuItem("Poista");
        JMenuItem Avaa = new JMenuItem("Avaa");
        JMenuItem Asetukset = new JMenuItem("Asetukset");
        JMenuItem Sijainti = new JMenuItem("Tiedostosijainti");
        Asetukset.addActionListener(listener);
        Avaa.addActionListener(listener);
        Poista.addActionListener(listener);
        Sijainti.addActionListener(listener);
        menu.add(Avaa);
        menu.add(Asetukset);
        menu.add(Sijainti);
        menu.add(Poista);
    }
    
    public void AsetaMenu(){
        lista.setComponentPopupMenu(menu);
    }
    
    public void NaytaMenu(int xPos, int yPos){
        menu.show(lista, xPos, yPos);
    }
}
