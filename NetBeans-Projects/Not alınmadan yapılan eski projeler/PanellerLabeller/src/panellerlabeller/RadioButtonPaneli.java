
package panellerlabeller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
 
// Bir grup seçenek içinden sadece bir tanesinin seçilmesi için kullanılıyor genelde, şıklı sorularda falan olur
public class RadioButtonPaneli extends JPanel implements ActionListener{
   
    JRadioButton rbuton1,rbuton2,rbuton3,rbuton4;
    JRadioButton r1,r2;
    // Radio butonları bir arada tutmak için gerek değişken
    ButtonGroup grup1,grup2;
    JLabel etiket1,etiket2;
    JButton buton1,buton2;
    
    public RadioButtonPaneli(){ 
        super();
        // Gruplar
        grup1 = new ButtonGroup(); // Sınıflar grubu
        grup2 = new ButtonGroup(); // Cinsiyetler grubu
        
        etiket1 = new JLabel("Sınıfınızı seçiniz :");
        etiket2 = new JLabel("Cinsiyetinizi seçiniz:");
        // Radya butonlar
        rbuton1 = new JRadioButton("1.Sınıf");
        rbuton2 = new JRadioButton("2. Sınıf");
        rbuton3 = new JRadioButton("3. Sınıf");
        rbuton4 = new JRadioButton("4. sınıf");
        
        r1 = new JRadioButton("Erkek");
        r2 = new JRadioButton("Kadın");
        
        buton1 = new JButton("Sınıfı Seç");
        buton1.addActionListener(this);
        // Bu üç radio buttonları aynı gruba verdiğğimiz zaman sadece bir tanesini seçmemizi sağlıyor.
        grup1.add(rbuton1);
        grup1.add(rbuton2);
        grup1.add(rbuton3);
        grup1.add(rbuton4);
        
        grup2.add(r1);
        grup2.add(r2);
        // Radio butonları ekrana yazdırabiliyoruz ama grup'u yazdıramıyoruz, bu sadece butonları düzenlemek için oluşturulan bir değişken.
        // add(grup1); olmaz !
        
        // Sınıf:
        add(etiket1);
        
        add(rbuton1);
        add(rbuton2);
        add(rbuton3);
        add(rbuton4);
        
        // Cinsiyet:
        add(etiket2);
        
        add(r1);
        add(r2);
        
        add(buton1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = "Seçilen sınıf: ";
        
        boolean sınıf = false;
        
        if(rbuton1.isSelected()){
            s += rbuton1.getText();
            sınıf = true;
        }
        else if(rbuton2.isSelected()){
            s += rbuton2.getText();
            sınıf = true;
        }
        else if(rbuton3.isSelected()){
            s += rbuton3.getText();
            sınıf = true;
        }
        else if(rbuton4.isSelected()){
            s += rbuton4.getText();
            sınıf = true;
        }
        else{
            s = "Lütfen sınıf seçiniz";
        }
        
        if(sınıf)
            if(r1.isSelected()){
                s += " " + r1.getText();
            }
            else if(r1.isSelected()){
                s += " " + r1.getText();
            }
            else{
                s = "Lütfen cinsiyet seçiniz";
            }
     
        JOptionPane.showMessageDialog(this, s);
    }
}
