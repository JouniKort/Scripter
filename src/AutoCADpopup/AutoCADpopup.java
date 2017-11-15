package AutoCADpopup;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class AutoCADpopup {

    private final File ProgFil = new File("C:\\Program Files\\Autodesk\\");
    private final ArrayList<File> exet = new ArrayList<>();
    private final ArrayList<File> CADit = new ArrayList<>();
    private final ArrayList<JMenuItem> Itemit = new ArrayList<>();
    private final JPopupMenu popup = new JPopupMenu();
    private final AutoCADpopupKuuntelija kuuntelija = new AutoCADpopupKuuntelija(popup);
    
    public AutoCADpopup(){
        if(ProgFil.exists()){
            for(File i : ProgFil.listFiles()){
                if(i.getName().contains("AutoCAD")){
                    for(File k : i.listFiles()){
                        if(k.getName().equals("acad.exe")){
                            exet.add(k);
                            CADit.add(i);
                            System.out.println(i.getPath());
                        }
                        if(k.getName().equals("acadlt.exe")){
                            exet.add(k);
                            CADit.add(i);
                            System.out.println(i.getPath());
                        }
                    }
                }
            }
            if(!CADit.isEmpty()){
                int index = 0;
                for(File i : CADit){
                    Itemit.add(new JMenuItem(i.getName()));
                    popup.add(Itemit.get(index));
                    kuuntelija.LisaaLista(exet.get(index));
                    Itemit.get(index).addActionListener(kuuntelija);
                    index++;
                }
            }else{
                LisaaViesti();
            }  
        }else{
            LisaaViesti();
        }
        popup.setPreferredSize(new Dimension(240, 30*Itemit.size()));
    }
    
    private void LisaaViesti(){
        Itemit.add(new JMenuItem("Yhtäkään AutoCADia ei läydetty"));
        popup.add(Itemit.get(0));
        Itemit.get(0).addActionListener(kuuntelija);
    }
    
    public JPopupMenu getMenu(){
        return popup;
    }
}
