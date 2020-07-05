
package panellerlabeller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldDenemesi extends JPanel implements ActionListener {
    
    JTextField textfield1;
    JButton buton1;
    JLabel label1;
    
    public TextFieldDenemesi(){
        super(); // Constructer'da yapılan şeyler yapılsın. (JPanel için)
        // add'yapıldığında layout null olmazsa, soldan sağa add yapılma sırasıyla eklenir.
        label1 = new JLabel();
        
        add(label1);
        
        textfield1 = new JTextField(10);
        // İçine sayı yazılırsa, text field'in uzunluğunu belirtir.
        // İçine string yazarsak, text field'in içine yazar direk.
        textfield1.addActionListener(this); // Textfields'ten enter'e basılırsa action tetiklenir
        
        add(textfield1); // Panel'e eklemek için.
        
        buton1 = new JButton("Tamam");
        buton1.addActionListener(this);
        
        add(buton1);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Tamam")){
            
            label1.setText(label1.getText() + " " + textfield1.getText());
            
            textfield1.setText(""); // Text field'in içini silme
            textfield1.requestFocusInWindow(); // Odak noktamızın değişmemesi için.
        }
    }
    
}
