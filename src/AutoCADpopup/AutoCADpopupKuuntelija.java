package AutoCADpopup;

import Kayttoliittyma.Kayttoliittyma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JPopupMenu;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AutoCADpopupKuuntelija implements ActionListener{
    
    private final File AutoCADpolku = new File(Kayttoliittyma.KansioPolku+"\\AutoCAD.txt");
    private final File User = new File(Kayttoliittyma.KansioPolku+"\\User.txt");
    private final ArrayList<File> polut = new ArrayList<>();
    private final JPopupMenu popup;
    
    public AutoCADpopupKuuntelija(JPopupMenu popup){
        this.popup = popup;
    }
    
    public void LisaaLista(File file){
        polut.add(file);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(!polut.isEmpty()){
            for(File i : polut){
                if(i.getPath().contains(ae.getActionCommand())){
                    try(PrintWriter writer = new PrintWriter(AutoCADpolku)){
                        writer.write(i.getPath());
                        Kayttoliittyma.CADsijainti = i.getPath();
                        AsetaUser();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(AutoCADpopupKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }else if(ae.getActionCommand().equals("Yhtäkään AutoCADia ei läydetty")){
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setMultiSelectionEnabled(false);
            chooser.setFileFilter(new FileNameExtensionFilter(".exe", "exe"));
            popup.setVisible(false);
            int vastaus = chooser.showDialog(null, null);
            switch(vastaus){
                case JFileChooser.APPROVE_OPTION:
                    try(PrintWriter writer = new PrintWriter(AutoCADpolku)){
                        writer.write(chooser.getSelectedFile().getPath());
                        Kayttoliittyma.CADsijainti = chooser.getSelectedFile().getPath();
                        AsetaUser();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(AutoCADpopupKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
                    }
                default:
                    return;
            }
        }
        popup.setVisible(false);
    }
    
    private void AsetaUser() throws FileNotFoundException{
        try(PrintWriter writer = new PrintWriter(User)){
            System.out.println("Käyttäjä asetettu: "+System.getProperty("user.name"));
            writer.write(System.getProperty("user.name"));
        }
    }
}
