package ListaLuokat;

import static Kayttoliittyma.Kayttoliittyma.Nimet;
import static Kayttoliittyma.Kayttoliittyma.Tiedostot;
import java.awt.Desktop;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JList;

public class ListaMouseAdapter implements MouseListener{
    
    private final JList JList;
    private final ListaPopup popup;
    
    public ListaMouseAdapter(JList JList){
        this.JList = JList;
        popup = new ListaPopup(JList);
    }
    
    @Override
    public void mouseExited(MouseEvent e){
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e){
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e){
        Point pos = JList.indexToLocation(Kayttoliittyma.Kayttoliittyma.Nimet.size()-1);
        if(pos.y+15 >= e.getPoint().y){
            if(e.getButton() == MouseEvent.BUTTON3){
                JList.setSelectedIndex(JList.locationToIndex(e.getPoint()));
                popup.NaytaMenu(e.getX(), e.getY());
            }
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        Point pos = JList.indexToLocation(Kayttoliittyma.Kayttoliittyma.Nimet.size()-1);
        if(pos.y+15 >= e.getPoint().y){
            if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2){
                String valittu = (String)JList.getSelectedValue();
                for(int i = 0 ; i < Nimet.size(); i++){
                    if(Tiedostot.get(i).getName().equals(valittu)){
                        try{
                            Desktop.getDesktop().open(Tiedostot.get(i));
                        }catch(Exception exception){
                            System.out.println(exception);
                        }                             
                    }
                } 
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        
    }       
}