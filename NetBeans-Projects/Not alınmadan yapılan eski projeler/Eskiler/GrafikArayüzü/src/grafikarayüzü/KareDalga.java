
package grafikarayüzü;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class KareDalga extends JPanel implements KeyListener{
    
    Dörtgen a,çerçeve;
    Dörtgen[] diğerleri;
    
    int adım = 5;
    int sayıDörtgen = 5;
    
    public KareDalga(){
        
        super();
        
        addKeyListener(this);
        
        System.out.println(this.getWidth());
        
        a = new Dörtgen(240,120, 20, 20);
        çerçeve = new Dörtgen(0, 0, 630, 445);
        diğerleri = new Dörtgen[10];
        diğerleri[0] = new Dörtgen(10,10,20,20);
        diğerleri[1] = new Dörtgen(50,40,20,20);
        diğerleri[2] = new Dörtgen(220, 30, 20, 20);
        diğerleri[3] = new Dörtgen(110, 210, 20, 20);
        diğerleri[4] = new Dörtgen(110, 110, 20, 20);
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        a.ekranÇiz(g);
        çerçeve.ekranÇiz(g);
        
        for(int i = 0; i < sayıDörtgen; i++){
            
            diğerleri[i].ekranÇiz(g);
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == e.VK_UP){
            
            a.hareketEt(0, -adım, diğerleri, sayıDörtgen);
        }
        
        else if(e.getKeyCode() == e.VK_DOWN){
            
            a.hareketEt(0, adım, diğerleri, sayıDörtgen);
        }
        
        else if(e.getKeyCode() == e.VK_RIGHT){
            
            a.hareketEt(adım, 0, diğerleri, sayıDörtgen);           
        }
        else if(e.getKeyCode() == e.VK_LEFT){
            
            a.hareketEt(-adım, 0, diğerleri, sayıDörtgen);
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }
  
}

