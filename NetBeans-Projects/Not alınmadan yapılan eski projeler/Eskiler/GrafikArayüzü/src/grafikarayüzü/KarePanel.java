package grafikarayüzü;
/*
Bu şekilde, programın panellerini tek tek yenileriz, ve ekleme olayını kolaylaştırmış oluyoruz
*/
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class KarePanel extends JPanel implements ActionListener{

    int x,y,h,l;
    Timer zaman;
    
    public KarePanel(){
        super();
        zaman = new Timer(40, this); // 40s'de bir action'u tetikle
        zaman.start(); // Tetiklemeyi başlat
        x = 100; y = 100; h = 100; l = 100;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g); // Paneller'de Component kullanılır.
        g.drawRect(x, y, h, l);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        x++;
        y++;
        repaint(); // Yineleme 
    }
    
    
}
