package ListaLuokat;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class SkriptiListaCellRenderer  extends JLabel implements ListCellRenderer{
    
    public SkriptiListaCellRenderer(){
        setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList lista, Object value, int index, boolean valittu, boolean Focus){
        setText(value.toString());
        System.out.println(SkriptiListaMouseAdapter.Nimi);
        setBackground(Color.white);
        setForeground(Color.black);
        if(value.toString().equals(SkriptiListaMouseAdapter.Nimi)){
            setBackground(Color.green);
            setForeground(Color.black);
        }else if(lista.getSelectedIndex() == index){
            setBackground(Color.blue);
            setForeground(Color.white);
        }
        return this;
    }
}