/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ListaLuokat;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ListaListCellRenderer extends JLabel implements ListCellRenderer{
    
    public static String Muutettu;
    
    public ListaListCellRenderer(){
        setOpaque(true);
        Muutettu = "";
    }
    
    @Override
    public Component getListCellRendererComponent(JList lista, Object value, int index, boolean valittu, boolean Focus){        
        setText(value.toString());
        if(lista.getSelectedIndex() == index){
            setForeground(Color.white);
            setBackground(Color.blue);
        }else if(Muutettu.contains(value.toString())){
            setBackground(Color.green);
            setForeground(Color.black);
        }else{
            setBackground(Color.white);
            setForeground(Color.black);
        }
        return this;
    }
}
