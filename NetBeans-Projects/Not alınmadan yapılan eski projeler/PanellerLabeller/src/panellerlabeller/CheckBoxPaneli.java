
package panellerlabeller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

// Birden fazla seçim işlemi için kullanılır genelde, tek bir seçim için radio button kullanılır.
public class CheckBoxPaneli extends JPanel implements ActionListener{
    
    JCheckBox kutu1,kutu2;
    JButton buton1;
    
    public CheckBoxPaneli(){
        
        super();
        
        kutu1 = new JCheckBox("Yurtta kallıyor");
        kutu2 = new JCheckBox("Burslu");
        
        add(kutu1);
        add(kutu2);
        
        buton1 = new JButton("Onayla");
        buton1.addActionListener(this);
        
        add(buton1);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Onayla")){
            
            if(kutu1.isSelected()){
               
                JOptionPane.showMessageDialog(this, "Başarılı");
            }
            else{
                
                JOptionPane.showMessageDialog(this, "Lütfen kutuyu seçiniz");
            }
            
        }
        
    }
    
}
