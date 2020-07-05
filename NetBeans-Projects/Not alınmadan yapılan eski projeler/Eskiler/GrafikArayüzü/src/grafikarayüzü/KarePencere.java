package grafikarayüzü;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class KarePencere extends JFrame implements ActionListener{
    
    int x,y,h,l; // h = Yükseklik l = Genişlik
    boolean kontrol;
   
    public KarePencere(){
        super(); // Üst class'ın constructer'inin yapıtkları yapılsın
        x = 100; y =100; h = 100; l =100;
        kontrol = true;
        Timer zaman = new Timer(20,this); // Kaç milisaniyede bir göstersin.
        // ! İnsan gözü saniyede 24'den fazla yinelenenleri sürekli gibi varsayar. 1s = 1000ms -> 1000/40=25
        // Her 40ms'de bir this (actionlistener)'i tetikleyecek.
        zaman.start(); // Tetikleyiciyi başlatma
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g); // Üst class'ın paint fonksiyonun yaptıklarını yapsın.
        // super.paint(g); olmazsa bir sürü kare çizer, olursa tek bir kare çizer.
        g.drawRect(x, y, h, l);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x < 600 && y < 400 && kontrol){
            x++;
            y++;
        }
        else{
            kontrol = false;
            x--; y--;
            if(x == 30 || y == 30)
                kontrol = true;
        }
        /*
        x++;
        y++;
        */
        repaint(); // Ekranı yineleme
    }
}
