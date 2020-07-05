package grafikarayüzü;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SuDalgası extends JPanel implements ActionListener, MouseListener, KeyListener{
    
    int x,y,h,l,yineleme,artış;
    Timer zaman;
    Çember[] çemberler;
    int maxÇember = 20; // Doğrudan buradan da belirtilebiliyor.
    int sayıÇember = 0; // Çember sayısı
    int mevcutÇember =0;
    public SuDalgası(){
        super();
        yineleme = 40;
        çemberler = new Çember[maxÇember];
        zaman = new Timer(yineleme, this);
        zaman.start();
        x = 100; y =100; h = 0; l =0;
        artış = 2;
        addMouseListener(this);
        // addKeyListener(this); sadece Frame'lerden eklenirse çalışır, odak noktasını belli etmek için;
        // Örneğin; 2 tane kutu var ben klavyeden veri girersem hangi kutuya yazıcağım bilinmez, ilk önce kutuya tıklaıyp odaklanmam lazım
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g); // Bu kısım olmazsa, eskisi silinir.
        for(int i = 0; i < sayıÇember; i++){
            çemberler[i].ekranÇiz(g);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < sayıÇember; i++){
            çemberler[i].genişle(artış);
        }
        repaint();
        /*
        // Gerekli formüller düşünüldüğünde , yapılması gerek işlemler.
        x -= artış/2; // Oval büydüğü için büyümenin yarısı kadar sağa ve sola çekersek merkezde kalır.
        y -= artış/2;
        h += artış;
        l += artış;
        repaint();
        */
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Çember yeniÇember = new Çember(e.getX(),e.getY(),0);
        if(mevcutÇember == maxÇember)
            mevcutÇember = 0;
            çemberler[mevcutÇember] = yeniÇember;
            if(sayıÇember < maxÇember)
                sayıÇember++;
            mevcutÇember++;
            
       
        /*
        x = e.getX();
        y = e.getY();
        h =0; l =0;
        repaint();
        /*
        x = e.getX() + l/2;
        y = e.getY() + h/2;
        */
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        zaman.start();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        zaman.stop();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == e.VK_UP){
            artış++;
        }
        else if(e.getKeyCode() == e.VK_DOWN){
            artış--;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }
    
    
}
