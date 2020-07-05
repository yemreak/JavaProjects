
package panellerlabeller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButonDenemesi extends JPanel implements ActionListener{
    
    JButton buton1, buton2;
    JLabel label1;
    int sayı = 10;
    
    public ButonDenemesi(){
        
        super();
        
        buton1 = new JButton("Arttır");
        buton1.addActionListener(this);
        
        buton2 = new JButton("Azalt");
        buton2.addActionListener(this);
        
        label1 = new JLabel("" + sayı);
        
        add(buton1);
        add(buton2);
        add(label1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getActionCommand().equals("Arttır")){   
            
            label1.setText("" + (Integer.parseInt(label1.getText()) + 1));
        }
        else if(e.getActionCommand().equals("Azalt")){
            
            label1.setText("" + (Integer.parseInt(label1.getText()) - 1));
        }
    }
    
    
    
    
}
