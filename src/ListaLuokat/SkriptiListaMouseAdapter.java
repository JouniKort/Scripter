package ListaLuokat;

import static Kayttoliittyma.Kayttoliittyma.Skriptit;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JList;
import javax.swing.JTextArea;

public class SkriptiListaMouseAdapter implements MouseListener{
    
    private final JList JList;
    private final JTextArea muotti;
    public static String Nimi = "";
    private File Avattu = null;
    
    public SkriptiListaMouseAdapter(JList JList, JTextArea muotti){
        this.JList = JList;
        this.muotti = muotti;
    }
    
    @Override
    public void mouseExited(MouseEvent e){
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e){
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e){

    }
    
    @Override
    public void mousePressed(MouseEvent e){
        Point pos = JList.indexToLocation(Kayttoliittyma.Kayttoliittyma.SkriptiNimet.size()-1);
        if(pos.y+15 >= e.getPoint().y){
            if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2){
                String valittu = (String)JList.getSelectedValue();
                for(int i = 0; i<Skriptit.size(); i++){
                    if(Skriptit.get(i).getName().equals(valittu)){
                        try{
                            muotti.setText(Kayttoliittyma.Kayttoliittyma.LueTiedosto(Skriptit.get(i)));
                            System.out.println("Avataan: "+Skriptit.get(i).getName());
                            nollaaAvattu();
                            AsetaAvattu(Skriptit.get(i));
                            JList.repaint();
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
    
    private void AsetaAvattu(File tiedosto){
        Avattu = tiedosto;
        Nimi = tiedosto.getName();
    }
    
    public File getAvattu(){
        return Avattu;
    }
    
    public void nollaaAvattu(){
        Avattu = null;
        Nimi = "";
    }
}
