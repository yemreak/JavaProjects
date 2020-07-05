package grafiksel.java;
import javax.swing.JOptionPane;
public class Joptionpane {
    public Joptionpane(){
    String isim = JOptionPane.showInputDialog("Lütfen isim giriniz");
        JOptionPane.showMessageDialog(null,"İsminiz "+isim);
        
        int değer1=Integer.parseInt(JOptionPane.showInputDialog("Bir sayı giriniz ->"));
        int değer2=Integer.parseInt(JOptionPane.showInputDialog("Tekrar sayı giriniz ->"));
        JOptionPane.showMessageDialog(null, "Çarpım sonucu = "+değer1*değer2);
    }
}
