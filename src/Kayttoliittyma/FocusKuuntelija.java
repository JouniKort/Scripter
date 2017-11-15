package Kayttoliittyma;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JPopupMenu;

public class FocusKuuntelija implements WindowFocusListener{

    private final JPopupMenu popup;
    private final Kayttoliittyma window;
    
    public FocusKuuntelija(JPopupMenu popup, Kayttoliittyma window) {
        this.popup = popup;
        this.window = window;
    }
    
    @Override
    public void windowLostFocus(WindowEvent we){
        if(!popup.isVisible()){
            window.removeWindowFocusListener(this);
            System.out.println("WindowFocusListener poistettu");
            return;
        }else{
            popup.setVisible(false);
            System.out.println("Focus pois");
        } 
        
    }
    
    @Override
    public void windowGainedFocus(WindowEvent we){
        System.out.println("Focus");
         popup.setVisible(true);
    }
}
