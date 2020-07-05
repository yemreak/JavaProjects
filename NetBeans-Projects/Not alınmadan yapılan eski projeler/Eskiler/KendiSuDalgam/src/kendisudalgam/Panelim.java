
package kendisudalgam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panelim extends JPanel implements ActionListener,MouseListener{

    Çember[] çemberler;
    
    int sayıÇember = 0, maxÇember = 30, artış = 4;
    int x1,y1; // Başlangıç Konumları
    int x,y; // Panel uzunluğu ve genişliği
    int r=0; // Çember genişliği
    int t=40; // Yenilenme periyodu (ms)
    Timer tetikleyici;
    
    public Panelim(int x,int y){
        super();
        setSize(x,y);
        this.x = x;
        this.y = y;
        çemberler = new Çember[maxÇember];
        tetikleyici = new Timer(t,this);
        tetikleyici.start();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if((x1 < x || y1 < y) && (r < x || r < y)){
            this.x1 -= artış / 2;
            this.y1 -= artış / 2;
            this.r += artış;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        çemberler[sayıÇember] = new Çember(x1,y1,r);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    }
    
}
