
package panellerlabeller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ÇButton extends JPanel implements ActionListener{

    JButton çıkış;
    
    public ÇButton(){
        super();
        
        çıkış = new JButton("Çıkış");
        çıkış.addActionListener(this);
        
        add(çıkış);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(1);
    }
    
}
