
package dönençizgi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Çizgi extends JPanel implements ActionListener{
    
    int y_frekans = 1;
    Timer zamanlayıcı = new Timer(y_frekans, this);
    
    int x;
    int y;
    int merkezX;
    int merkezY;
    int uzunluk = 40;
    int i = 10;
    int j = 10;
    // Daha kesin çizim için rasyonel sayı alındı.
    double açı = 0;
    
    public Çizgi(int x, int y){
        super();
        
        this.x = x;
        this.y = y;
        this.merkezX = (int)x / 2;
        this.merkezY = (int)y / 2;
        // Zamanlayıcı'yı başlatmak.
        zamanlayıcı.start();
    }
    @Override
    public void paint(Graphics g){
        // Paint ve paintcomponents farkı'na bak.
        super.paint(g);
        
        g.drawLine(0,merkezY, x, merkezY);
        g.drawLine(merkezX, 0, merkezX, y);
        // Yapılacak işlemin rengi. K / Y / M
        g.setColor(new Color(255, 0, 0)); // Işık renklerinin karışı (Direk Color.Red de olur)
        
        g.drawLine(merkezX, merkezY, merkezX + i, merkezY - j);
        g.drawLine(merkezX, merkezY, merkezX - i, merkezY + j); 
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // i'nin konumu r.cos@ j'nin konumu r.sin@
        i = (int)(uzunluk * Math.cos(açı));
        j = (int)(uzunluk * Math.sin(açı));
        // Dönme hızı pi'yaparsak dönmez gibi gözükür 
        açı += (Math.PI * 0.01);
        
        repaint();
    }
}
