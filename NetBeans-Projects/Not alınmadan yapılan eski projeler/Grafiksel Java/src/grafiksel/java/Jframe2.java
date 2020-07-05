package grafiksel.java;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
public class Jframe2 {
    public Jframe2(){
        
        JFrame.setDefaultLookAndFeelDecorated(false); // Yeni görünüş olsun mu ?
        JFrame frame = new JFrame("Renklerle çalışma :)");// Programın adı
        
        JPanel GUI = new JPanel();
        GUI.setLayout(null); // Boş bir çerçeve karşılasın, içinde herhangi bir özellik olmayan
        GUI.setBackground(Color.blue);
        
        JPanel yazılar = new JPanel();
        yazılar.setLayout(null);
        yazılar.setBackground(Color.black);
        yazılar.setLocation(10,0);
        yazılar.setSize(150,30);
        GUI.add(yazılar);
        
        JLabel kırmızı = new JLabel("Kırmızı");
        // kırmızı.setText("Kırmızı"); da olur ama aynı şey.
        kırmızı.setForeground(Color.red);
        kırmızı.setLocation(0,0); // Konum
        kırmızı.setSize(50,30); // Boyut
        kırmızı.setHorizontalAlignment(0);
        // -> 0 , merkeze konumlandırmak 
        // -> 2 , sola yaslamak
        // -> 4 , sağa yaslamak için
        yazılar.add(kırmızı); // eklendi
        
        JLabel beyaz = new JLabel("Beyaz");
        beyaz.setForeground(Color.white);
        beyaz.setLocation(100,0);
        beyaz.setSize(50,30);
        beyaz.setHorizontalAlignment(0);
        yazılar.add(beyaz);
        
        JPanel renkler = new JPanel();
        renkler.setBackground(Color.blue);
        renkler.setLayout(null);
        renkler.setLocation(10,40);
        renkler.setSize(150,50);
        GUI.add(renkler); // Panel'e panel ekleniyor.
        
        JPanel kırmızıKutu = new JPanel();
        kırmızıKutu.setBackground(Color.red);
        kırmızıKutu.setLocation(0,0);
        kırmızıKutu.setSize(50,50);
        renkler.add(kırmızıKutu); // Panel'e panel eklendi.
        
        JPanel beyazKutu = new JPanel();
        beyazKutu.setBackground(Color.white);
        beyazKutu.setLocation(100,0);
        beyazKutu.setSize(50,50);
        renkler.add(beyazKutu);
        
        
        frame.setSize(190,150);
        frame.setContentPane(GUI); // GUI panelini ekledik
        frame.setResizable(false); // Tekrardan boyutlanabilsin mi?
        frame.setVisible(true);
    }
}
