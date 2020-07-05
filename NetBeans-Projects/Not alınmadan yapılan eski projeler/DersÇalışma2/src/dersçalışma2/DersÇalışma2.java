
package dersçalışma2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DersÇalışma2 {
    static int otxt=0;

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Ders Çalışma2");
        frame.setLayout(null);
        frame.setSize(250,250);
        frame.setLocation(540,160);
        
        
        JFrame hesapfr = new JFrame("Hesap Makinesi");
        JFrame mhesapfr = new JFrame("<o>");
        hesapfr.setSize(255,255);
        hesapfr.setLocation(540,160);
        hesapfr.setLayout(null);
        
        JLabel l_output = new JLabel();
        l_output.setText(String.valueOf(otxt));
        l_output.setForeground(Color.yellow);
        l_output.setLocation(0,10);
        l_output.setHorizontalAlignment(2);
        
        JButton çıkış = new JButton("Çıkış");
        çıkış.setSize(120,20);
        çıkış.setLocation(65,180);
        çıkış.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent a){
                        System.exit(1);
                    }
                }
        );
        
        JButton çıkış1 = new JButton("Çıkış");
        çıkış1.setSize(120,20);
        çıkış1.setLocation(65,180);
        çıkış1.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent a){
                        hesapfr.setVisible(false);
                        otxt=0;
                        l_output.setText(String.valueOf(otxt));
                        frame.setVisible(true);
                    }
                }
        );
        /*çıkış.addMouseListener(
                new MouseAdapter(){
                    public void mouseEntered(MouseEvent b){
                        Random r = new Random();
                        //frame.remove(çıkış);
                        //frame.setVisible(true);
                        çıkış.setLocation(65,r.nextInt(150)+20);
                    }
                }
        );*/
        frame.add(çıkış);
        hesapfr.add(çıkış1);
        //frame.add(hesapfr);
       
        JButton buton1 = new JButton("Hesap Makinesi");
        buton1.setSize(180,20);
        buton1.setLocation(35,30);
        buton1.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent a){
                        hesapfr.setVisible(true);
                        frame.setVisible(false);
                    }
                }
        );
        buton1.addMouseListener(
                new MouseAdapter(){
                    public void mouseEntered(MouseEvent e){
                        mhesapfr.setSize(128,128);
                        mhesapfr.setLocation(800,160);
                        mhesapfr.setVisible(true);
                    }
                    public void mouseExited(MouseEvent e){
                        mhesapfr.setVisible(false);
                    }
                }
                
        );
        frame.add(buton1);
        
        JPanel output = new JPanel();
        
       
        
        
        output.add(l_output);
        
        output.setBackground(Color.BLUE);
        output.setForeground(Color.yellow);
        output.setSize(220,20);
        output.setLocation(10,10);
        hesapfr.add(output);
        
        JButton n_7 = new JButton("7");
        n_7.setSize(45,40);
        n_7.setLocation(10,40);
        n_7.setHorizontalAlignment(0);
        n_7.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent a){
                        otxt=otxt+7;
                        l_output.setText(String.valueOf(otxt));
                       
                    }
                }
                
        );
        hesapfr.add(n_7);
        
        
        
        frame.setVisible(true);
    }
    
}
