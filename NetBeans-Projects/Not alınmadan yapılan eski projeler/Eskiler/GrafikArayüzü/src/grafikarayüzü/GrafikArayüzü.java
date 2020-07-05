package grafikarayüzü;

import javax.swing.JFrame;

/*
 * Java'da Frame'lere Conteiner
           Panel'lere Component
   denir.
 */

public class GrafikArayüzü {
    
    public static void main(String[] args) {
        /*
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame pencere = new JFrame("Çarpışma");
        
        YeniKarePanel panel1 = new YeniKarePanel();
        
        pencere.addKeyListener(panel1);
        pencere.add(panel1);
        pencere.setSize(640,480);
        pencere.setVisible(true);
        */
        
        
        /*
        
        JFrame pencere = new JFrame("Kare İlerletme");
        KareDalga panel1 = new KareDalga();
        pencere.add(panel1);
        pencere.addKeyListener(panel1);
        pencere.setSize(640,480); 
        // Windows'ta x'konumundan en sondaki 5piksel gözükmüyor
        // 22 x ekseninde, 35 y ekseninden kayıp var
        pencere.setVisible(true);
        */
        JFrame pencere = new JFrame("Su Dalgası");
        SuDalgası panel1 = new SuDalgası();
        pencere.add(panel1); // Direk objeyi göderebiliyoruz, ama constructer'i ile kullanarak.
        pencere.addKeyListener(panel1);
        pencere.setSize(640,480);
        pencere.setVisible(true);
        
        /*
        KarePencere pencere1 = new KarePencere();
        pencere1.setSize(640,480);
        pencere1.setVisible(true);
        
        /*
        BizimPencere pencere1 = new BizimPencere();
        pencere1.setSize(640,480);
        pencere1.setVisible(true);
        */
    }
    
}
