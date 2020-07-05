package grafiksel.java;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Dizayn {
    public Dizayn(){
        JFrame.setDefaultLookAndFeelDecorated(true); // Yeni tarz java
        JFrame frame = new JFrame ("Çaycı uygulaması");
        
        JPanel boxes = new JPanel();
        JLabel label = new JLabel("Çayınız nasıl olmalı");
        boxes.add(label);
        
        JButton çıkış = new JButton("Çıkmak için basınız");
        çıkış.setSize(240,20);
        çıkış.setLocation(0,240);
        çıkış.setHorizontalAlignment(0);
        çıkış.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e1){
                        JOptionPane jop1 = new JOptionPane();
                        // jop1.showMessageDialog(null,"İyi günler :)");
                        System.exit(0);
                    }
                }
                
        );
        frame.add(çıkış);
        
        ImageIcon süticon = new ImageIcon("C:\\Users\\Yunus Emre AK\\Documents\\NetBeansProjects\\Grafiksel Java\\src\\images\\süt.png");
        Image sütimg = süticon.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        süticon = new ImageIcon(sütimg);
        
        ImageIcon şekericon = new ImageIcon ("C:\\Users\\Yunus Emre AK\\Documents\\NetBeansProjects\\Grafiksel Java\\src\\images\\şeker.jpg");
        Image şekerimg = şekericon.getImage().getScaledInstance(20, 20,Image.SCALE_SMOOTH);
        şekericon = new ImageIcon(şekerimg);
        
        JCheckBox sütcb = new JCheckBox("süt",false); // İsim, resim, işaretlenmiş olsun mu ?
        JCheckBox şekercb = new JCheckBox("şeker",false); // default değeri false'tur
        // ActionListener ekle
        boxes.add(sütcb);
        boxes.add(şekercb);
        
        frame.add(boxes);
        frame.setSize(250,300);
        frame.setVisible(true);
        
        
    }
}
