
package grafikarayüzü;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class YeniKarePanel extends JPanel  implements ActionListener, KeyListener{
    
    Dörtgen a, çerçeve;
    Dörtgen[] diğerleri;
    
    int adım = 5;
    int sayıDiğerleri = 30;
    
    Timer tetikleyici1;
    Random rastgele;
        
    public YeniKarePanel(){
        
        super();
        
        tetikleyici1 = new Timer(40, this);
        tetikleyici1.start(); // tetikleyiciyi başlatma
        
        rastgele = new Random();
        
        a = new Dörtgen(0, 0, 20, 20, 0, 0);
        çerçeve = new Dörtgen(0, 0, 630, 445, 0, 0);
        diğerleri = new Dörtgen[sayıDiğerleri];
          
        for(int i = 0; i < sayıDiğerleri; i++){
            
            diğerleri[i] = new Dörtgen(rastgele.nextInt(570) + 40, rastgele.nextInt(385) + 40, 20, 20, rastgele.nextInt(10) + 1, rastgele.nextInt(10) + 1);
        }
        
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        a.ekranÇiz(g);
        çerçeve.ekranÇiz(g);
        
        for(int i = 0; i < sayıDiğerleri; i++){
            
            diğerleri[i].ekranÇiz(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i = 0; i < sayıDiğerleri; i++){
            
            diğerleri[i].hareketEt(a, diğerleri, sayıDiğerleri);
        }
        
        repaint(); // Yenileme
    }

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
    
        if(e.getKeyCode() == e.VK_UP){
            
            a.hareketEt(0, -adım, diğerleri, sayıDiğerleri);
        }
        else if(e.getKeyCode() == e.VK_DOWN){
            
            a.hareketEt(0, adım, diğerleri, sayıDiğerleri);
        }
        else if(e.getKeyCode() == e.VK_LEFT){
            
            a.hareketEt(-adım, 0, diğerleri, sayıDiğerleri);
        }
        else if(e.getKeyCode() == e.VK_RIGHT){
            
            a.hareketEt(adım, 0, diğerleri, sayıDiğerleri);
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }
    
    
}
