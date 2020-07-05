
package diktörgenlervetimer;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer; // Sadece JFrame'de çalışır.

public class Dörtgenler extends JPanel implements ActionListener {
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        
        frame.setVisible(true);
        frame.setSize(640,480);
        // Programdan x'ya basılınca otomatik olarak kapanmasını sağlıyor.
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        Dörtgenler d1 = new Dörtgenler();
        // Panel'i frame'e eklemek için.
        frame.add(d1);
    }
    private int f_yineleme = 1;
    
    private Timer timer = new Timer(f_yineleme,this); // Jframe olmazsa program kendini durdurur.
    private LinkedList<Rectangle> list = new LinkedList<Rectangle>();
    private Random rastgele = new Random();
    
    private int en_çokX = 640;
    private int en_çokY = 480;
    private int en_çokH = 300;
    private int en_çokW = 5;
    private int en_azH = 5;
    private int en_azW = 0;
    
    public Dörtgenler(){
        timer.start();
        
    }
    private void rastgeleDikdörtgen(){ 
        int x = rastgele.nextInt(en_çokX);
        int y = rastgele.nextInt(en_çokY);
        int w = rastgele.nextInt(en_çokW - en_azW) + en_azW;
        int h = rastgele.nextInt(en_çokH - en_azH) + en_azH;
        
        yeniDikdörtgen(x, y, w, h);
    }
            
    private void yeniDikdörtgen(int x, int y, int w, int h){
        boolean eklensin_mi = true;
     
        Rectangle dikdörtgen = new Rectangle(x, y, w, h);
        Iterator<Rectangle> it = list.iterator();        
        
        while(it.hasNext()){
            Rectangle r = it.next();
            // r ve dikdörtgen'in yerleri farketmiyor. 
            if(dikdörtgen.intersects(r)){
                // Eğer keşisme varsa, yeni dörtgen eklenmesin.
                eklensin_mi = false;
            }
        }
        // LinkedList'e dikdörtgenler ekleniyor, eğer kesişme yoksa.
        if(eklensin_mi)
            list.add(dikdörtgen);
        else
            // Eğer eklenmiyorsa, vakit kaybetmemek için tekrar başa gönderilir ve timer süresi kadar
            // ekleme yapar, ama ilerleyen aşamalarda program kasmaya başlar çünkü ekleyeceği yer kalmayacak.
            // Ve hata vermeye başlar.
            rastgeleDikdörtgen();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Iterator<Rectangle> it = list.iterator();
        // Eğer devamı varsa devam et.
        while (it.hasNext()){
            // Iterator'un sıradaki elemanını return ediyor ve atıyoruz.
            Rectangle r = it.next();
            // İçi dolu dikdörtgen çizmek için fill (doldurmak).
            g.fillRect(
                    (int)r.getX(), // Bilgieri iterator(yenileyici)'den alıyor.
                    (int)r.getY(),
                    (int)r.getWidth(),
                    (int)r.getHeight()
            );
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rastgeleDikdörtgen();
        // Ekranı yineleme
        repaint();
        
    }
    
}
