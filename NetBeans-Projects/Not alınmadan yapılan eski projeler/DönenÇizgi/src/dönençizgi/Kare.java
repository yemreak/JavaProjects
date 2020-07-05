
package dönençizgi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Kare extends JPanel implements ActionListener, KeyListener{
    
    Çizgi a = new Çizgi(640,480);
    
    private int Px, Py; // Pencerenin x,y koordinatları. 
    private int merkezX, merkezY, w, h;
    private int r = 50;// İç teğet çemberinin yarı çapı. 
    private int[] i = new int[4];  // Kare'nin koordinatları.
    private int[] j = new int[4]; // Kare'nin koordinatları.
    private int y_frekansı = 1000;
    private double açısal_hız = 0;
    
    private double açı = 0;
    
    private Timer yenileyici = new Timer(1000 / y_frekansı, this);
    
    public Kare(int x, int y){
        super();
        
        this.Px = x;
        this.Py = y;
        this.merkezX = x / 2;
        this.merkezY = y / 2;
        
        konumAyarla();
        
        yenileyici.start();
    }
    
    public void koordinatEkseniÇiz(Graphics g){
        g.setColor(Color.GRAY);
        
        g.drawLine(0, merkezY, Px, merkezY);
        g.drawLine(merkezX, 0, merkezX, Py);
        
        
    }
    
    public void kırmızıÇizgiEkle(Graphics g, int[] i, int[] j){
        g.setColor(Color.RED);
        
        konumAyarla();
        
        for(int a = 0; a < 4; a++){
            if(a != 3)
                g.drawLine(merkezX + i[a], merkezY - j[a], merkezX - i[a+1],merkezY + j[a+1]);
            else
                g.drawLine(merkezX + i[a], merkezY - j[a], merkezX - i[0],merkezY + j[0]);
        }
                
    }
    
    public void konumAyarla(){
        for(int a = 0; a < 4; a++){
            i[a] = (int)(r * Math.cos(açı + (a * 0.5 * Math.PI)));
            j[a] = (int)(r * Math.sin(açı + (a * 0.5 * Math.PI)));
        }
    }
    
    public void açıAyarla(double artış){
        // Artış 1'se açı 1'er derece olarak artar.
        açı += artış * Math.PI / 180;   
    }
    
    public void açısalHızGöstericiEkle(Graphics g){
        if(Math.abs(açısal_hız) % 90 < 45)
            g.drawString("Açısal Hız -> " + String.valueOf(-açısal_hız % 90), Px - 120, 10);
        else
             g.drawString("Açısal Hız -> " + String.valueOf(-açısal_hız % 90 - 90), Px - 120, 10);
    }
    
    @Override 
    public void paint(Graphics g){
        super.paint(g);
        a.paint(g);
        koordinatEkseniÇiz(g);
        açısalHızGöstericiEkle(g);
        
        kırmızıÇizgiEkle(g, i, j);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Açının kaçar derece artmasını istiyorsak onu yazıyoruz.
        açıAyarla(açısal_hız);
        // Ekranı yineleme.
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_LEFT)
            açısal_hız++;
        else if (e.getKeyCode() == e.VK_RIGHT)
            açısal_hız--;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
