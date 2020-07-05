package grafikarayüzü;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JFrame;

public class BizimPencere extends JFrame implements MouseListener,KeyListener{
    // MouseListener eklendiği için, bütün MouseListener method'ları class'a dahil oldu, ve override edilecek.
    private Random rnd;
    private int x1,y1,x2,y2;
    private String yazı;
    
    public BizimPencere(){
        super(); // JFrame'ye bağlı olduğu için, JFrame constructer'ını da kullanmak zorundayız.
        // Aksi halde JFrame yapısındaki bazı özellikleri kullanamaz oluruz.
        x1 = 0; y1 = 0; x2 = 0; y2 = 0;
        rnd = new Random();
        yazı = "o";
        addMouseListener(this); // MouseListener'imiz zaten class'ın içinde olduğu için this yazıyoruz içine
        addKeyListener(this); // // KeyListener'imiz zaten class'ın içinde olduğu için this yazıyoruz içine
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g); // Jframe.paint(g); gibi bir şey oluyor.
        // Tamamen yeni bir şey olmasın, üzerine bir şeyler katmak istersek, süper kullanıyoruz.
        g.drawString(yazı,x1,y1); // String ekleme yazı Başlangıç(x,y)
        g.drawLine(x1,y1,x2,y2); // Çizgi çizme Başlangıç(x,y) Bitiş(x,y)
         
        /*
         * for (int i = 0; i < 100; i++){
         *     g.drawLine(rnd.nextInt(640),rnd.nextInt(480),rnd.nextInt(640),rnd.nextInt(480));
         *     // Ekran her yenilendiğinde(repaint) farklı bir çizgiler olur.
           }
         */
        
        /*
         *  g.drawRect(160, 120, 320, 240);
         * // Diktörtgen çizer , sırasıyla ; Konum(x,y) Büyüklük(x,y);
         * g.drawRect(320, 240, 160, 240);
         * g.drawLine(0,0,200,300);
         * // Çizgi çizer , sırasıyla ; Konum(x,y) Büyüklük(x,y); veya Başlangıç konumu(x,y) bitiş konumu(x,y);
         */
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Fare'yle basıp çektiğimiz zaman.
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                // Eğer basılan buton ilk butonsa(sol tuş)
                x1 = e.getX(); // Fare'nin x konumu alır
                y1 = e.getY(); // Fare'nin y konumu alır
                break;
            case MouseEvent.BUTTON2:
                // Eğer Basılan buton orta tuşsa
                x2 = e.getX(); // Fare'nin x konumu alır
                y2 = e.getY(); // Fare'nin y konumu alır
                break;
            case MouseEvent.BUTTON3:
                // Eğer basılan buton sağ tuşsa
                x2 = e.getX(); // Fare'nin x konumu alır
                y2 = e.getY(); // Fare'nin y konumu alır
                break;
            default:
                break;
        }
        repaint(); // Ekranı yineleme
    }

    @Override
    public void mousePressed(MouseEvent e) {
    // Fare'yle bastığımız (çekmeye gerek yok) zaman
    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    // Fare'yle basmayı bıraktığımız zaman
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    // Fare belli bir alana girdiği zaman
    x1 = e.getPoint().x;
    y1 = e.getPoint().y;
    repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
    // Fare belli bir alandan çıktığı zaman    
    }

    @Override
    public void keyTyped(KeyEvent e) {
    // Tuş basılıp kaldırıldığı zaman
       /* keyTyped'da çalışmıyor bu
        if(e.getKeyCode() != e.VK_BACK_SPACE){
            System.out.println("-> "+ e.getKeyCode() +" " + e.VK_BACK_SPACE);
            yazı = yazı + e.getKeyChar();
        }
        repaint(); // Ekranı yenileme
        */
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
    // Tuşa basıldığı zaman
        if(e.getKeyCode() == e.VK_BACK_SPACE){ // Eğer kod , backspace'e eşitse
            if(yazı.length() > 0)
            yazı = yazı.substring(0,yazı.length()-1); // substring siringin belli bir bölümünü kesmemizi sağlıyor
            // 0 'dan uzunluk-1 'e kadar olsun diyorun son karakter siliniyor.
        }
        
        else if(e.getKeyCode() != e.VK_SHIFT){
              yazı = yazı + e.getKeyChar(); // Basılan karakteri alıyor
        }
        repaint(); // Ekranı yenileme
    }
    @Override
    public void keyReleased(KeyEvent e) {
    // Tuş bırakıldığı zaman    
    }
}
