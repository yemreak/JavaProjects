
package dönençizgi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class İçiDoluÇokgen extends JPanel implements ActionListener, KeyListener{
    
    int[] i = new int[4];
    int[] j = new int[4];
    double açı = 0;
    
    int Px, Py; // Pencere boyutları
    int merkezX, merkezY; // Pencere merkezi koordinatları.
    int r = 50; // İç teğet çemberinin yarı çapı.
    int y_frekans = 100;
    
    Timer  yenileyici = new Timer(1000 / y_frekans, this);
    
    //Polygon anakare;
    
    public İçiDoluÇokgen(int x, int y){
        super();
        
        this.Px = x;
        this.Py = y;
        this.merkezX = x / 2;
        this.merkezY = y / 2;
        
        yenileyici.start();
        
        
    }
    public void koordinatEkseniEkle(Graphics g){
        g.setColor(Color.GRAY);
        
        g.drawLine(0, merkezY, Px, merkezY);
        g.drawLine(merkezX, 0, merkezX, Px);
    }
    
    public void konumAyarla(){
        for(int a = 0; a < 4; a++){
            if((a % 4) == 0 || (a % 4) == 3)
                i[a] = (int)(merkezX + r * Math.cos(açı - (Math.PI / 2) * (a % 2)));
            else
                i[a] = (int)(merkezX - r * Math.cos(açı - (Math.PI / 2) * (a % 2)));
            if((a % 4) < 2)
                j[a] = (int)(merkezY - r * Math.sin(açı + (Math.PI / 2) * (a % 2)));
            else
                j[a] = (int)(merkezY + r * Math.sin(açı + (Math.PI / 2) * (a % 2)));
        }
        
    }
    
    public void rastgeleKonumAyarla(){
        for(int a = 0; a < 4; a++){
            if((a % 4) == 0 || (a % 4) == 3)
                i[a] = (int)(merkezX + r * Math.cos(açı - (Math.PI / 2) * (a % 2)));
            else
                i[a] = (int)(merkezX - r * Math.cos(açı - (Math.PI / 2) * (a % 2)));
            if((a % 4) < 2)
                j[a] = (int)(merkezY - r * Math.sin(açı + (Math.PI / 2) * (a % 2)));
            else
                j[a] = (int)(merkezY + r * Math.sin(açı + (Math.PI / 2) * (a % 2)));
        }
    }
    
    public void içiDoluÇokgenEkle(Graphics g){
        konumAyarla();
        
       //anakare = new Polygon(i, j, 4);
        
        g.fillPolygon(i,j,4);
    }
    public void açıAyarla(int x){
        açı += x * Math.PI / 180; 
    }
    
    @Override 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        koordinatEkseniEkle(g);
        içiDoluÇokgenEkle(g);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        açıAyarla(1);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }
}
