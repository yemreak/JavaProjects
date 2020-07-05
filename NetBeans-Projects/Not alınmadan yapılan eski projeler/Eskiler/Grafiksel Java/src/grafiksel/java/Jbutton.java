package grafiksel.java;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Jbutton {
    public Jbutton(){
        JFrame frame = new JFrame("Faker !");
        
        JPanel GUI= new JPanel();
        GUI.setLayout(null);
        
        JPanel düğmeler = new JPanel();
        düğmeler.setLayout(null);
        düğmeler.setLocation(10,10);
        düğmeler.setSize(250,275);
        GUI.add(düğmeler);
        
        JButton jb1 = new JButton();
        jb1.setText("Buna basma");
        jb1.setSize(120,20);
        jb1.setLocation(70,20);
        jb1.setHorizontalAlignment(0);
        
        // Tıklandığında yapılması gerekenler
        jb1.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JOptionPane jop1 = new JOptionPane();
                        jop1.showMessageDialog(null,"Küstüm ben bye -,-");
                        System.exit(0);                    }
            }
        );
        
        düğmeler.add(jb1);
      
        final JButton jb2 = new JButton();
        jb2.setText("Bunun yakınından bile geçme");
        jb2.setSize(200,20);
        jb2.setLocation(30,45);
        jb2.setHorizontalAlignment(0);
        final Color varsayılan =jb2.getBackground();
        // Mause geldiğinde yapılacaklar
        jb2.addMouseListener(
                new MouseAdapter(){
                    public void mouseEntered(MouseEvent m1){
                        jb2.setBackground(Color.red);
                        super.mouseEntered(m1);
                    }
                    public void mouseExited(MouseEvent m1){
                        jb2.setBackground(varsayılan);
                        super.mouseExited(m1);
                    }
                }
        );
        
       düğmeler.add(jb2);
        
        JButton jb_1 = new JButton();
        jb_1.setText("Kaçarım gelme :D");
        jb_1.setLocation(10,0);
        jb_1.setSize(240,20);
        jb_1.setHorizontalAlignment(0);
        düğmeler.add(jb_1);
        
        Random rastgele= new Random();
        jb_1.addMouseListener(
                new MouseAdapter(){
                    public void mouseEntered(MouseEvent m2){
                        jb_1.setLocation(rastgele.nextInt(10),rastgele.nextInt(250));
                        super.mouseEntered(m2);
                    }
                }
        );
        
        ImageIcon ic1 = new ImageIcon("C:\\Users\\Yunus Emre AK\\Documents\\NetBeansProjects\\Grafiksel Java\\src\\images\\key.gif");
        // resim ekleme
        JButton jb3 = new JButton(ic1); // Yazı yerine resim koymak
        jb3.setSize(110,70);
        jb3.setLocation(70,75);
        jb3.setHorizontalAlignment(0);
        düğmeler.add(jb3);
        
        JButton jb4 = new JButton("sağ",ic1);
        jb4.setSize(110,70);
        jb4.setLocation(10,155);
        düğmeler.add(jb4);
        
        JButton jb5 = new JButton("sol",ic1);
        jb5.setText(jb5.getText().toUpperCase());
        jb5.setSize(110,70);
        jb5.setLocation(130,155);
        jb5.setHorizontalTextPosition(SwingConstants.LEFT);
        düğmeler.add(jb5);
        
        
        frame.setSize(290,300);
        frame.setContentPane(GUI); // GUI'yi içine ekliyoruz
        frame.setResizable(false); // Yeniden boyutlanabilir mi?
        frame.setVisible(true); // Görünürlük
    }
}
