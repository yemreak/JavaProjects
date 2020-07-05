package ilközgünprogram;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class İlkÖzgünProgram {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Kimi düşünüyorsun ?");
        frame.setLayout(null); // Buton'un konumunu ayarlamak için önemli
        
        
        
        JButton buton1 = new JButton("Başlamak İçin Tıklayınız");
        buton1.setSize(180,20);
        buton1.setLocation(30,30);
        buton1.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent a){
                        String isim = JOptionPane.showInputDialog("İsminiz nedir?");
                        JLabel aetiket1 = new JLabel("Sayın "+isim+" düşüdüğünüz kişi :");
                        aetiket1.setSize(220,20);
                        aetiket1.setForeground(Color.BLACK);
                        aetiket1.setLocation(10,60);
                        frame.add(aetiket1);
                        ImageIcon silan = new ImageIcon("C:\\Users\\Yunus Emre AK\\Documents\\NetBeansProjects\\İlkÖzgünProgram\\src\\resimler\\silan.png");
                        JLabel düşünülen = new JLabel(silan);
                        düşünülen.setLocation(90,80);
                        düşünülen.setSize(54,76);
                        frame.add(düşünülen);
                         
                        
                        
                    }
                }
        );
        frame.add(buton1);
        
        
        JLabel etiket1 = new JLabel("Güvenli Çıkış İçin Basınız -----> ");
        etiket1.setSize(210,22);
        etiket1.setLocation(0,2);
        etiket1.setHorizontalAlignment(0);
        etiket1.setForeground(Color.red);
        frame.add(etiket1);
        
        ImageIcon çıkışicon = new ImageIcon("C:\\Users\\Yunus Emre AK\\Documents\\NetBeansProjects\\İlkÖzgünProgram\\src\\resimler\\exit.png");
        JButton çıkış = new JButton(çıkışicon);
        çıkış.setSize(22,22);
        çıkış.setLocation(200,2);
        çıkış.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        System.exit(1);
                    }
                }
        );
        frame.add(çıkış);
        
        frame.setLocation(560,240);
        frame.setSize(240,240);
        frame.setVisible(true);
        frame.setResizable(false);        
    }
    
}
