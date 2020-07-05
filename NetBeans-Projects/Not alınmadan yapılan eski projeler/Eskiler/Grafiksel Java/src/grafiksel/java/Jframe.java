package grafiksel.java;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Jframe extends JFrame {
    public Jframe(){
        JFrame şema = new JFrame();
        şema.setTitle("İlk şemamız"); // Şema / Program 'ın adı (sol üstteki)
        şema.setSize(500,500); // Boyutu
        
        şema.setLocation(450,150); // Açılma konumu (Ortada)
        şema.setLayout(new FlowLayout()); // Çerçeve, objelerin sıralaması ile ilgili komut
       
        JLabel etiket1 = new JLabel("İlk etiketimiz"); // etiket ekleme
        etiket1.setToolTipText("Deneme etiketi"); // Mausu üzerine getirince çıkan yazı
        JTextField alan1 = new JTextField(); // Text giriş kutusu oluşturma
        alan1.setText("Buraya metin giriniz"); // Kutunun içine bir şey yazma.
        şema.add(alan1); // Şema'ya ekleme
        şema.add(etiket1); // Şema'ya ekleme
                
        şema.setVisible(true); // Ekranda gözükmesini sağlıyor.
    }
}
