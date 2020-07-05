package grafikarayüzü;

import javax.swing.JFrame;

public class PencereDene {
    
    JFrame pencere;
    
    public PencereDene(){
        
        pencere = new JFrame();
        pencere.setSize(640,480); // Genişlik ve yükseklir ayarlama.
        // pencere.setBounds(640, 80, 640, 480); // Açılma konumu (x,y) ve büyüklüğü (x,y) location ve size ayarlama veya Başlangıç konumu(x,y) bitiş konumu(x,y);
        
        pencere.setVisible(true); // Görünürlüğü ayarlar.
    }
}
