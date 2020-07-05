
package panellerlabeller;

import javax.swing.JFrame;
import panellerlabeller.SoruCevap.Soru;
import panellerlabeller.SoruCevap.SorularÇerçevesi;

public class PanellerLabeller {

    public static void main(String[] args) {
    
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        
        
        
        
        
        
        SorularÇerçevesi sorular = new SorularÇerçevesi(240,240);/*
        sorular.soruEkle("Hangisi programlama dili değildir?",
                "Java",
                "C++",
                "Oracle",
                "Pyhton",
                Soru.Cevap._C
        );
        sorular.soruEkle("Hangisi programlama dillerindeki keywords (anahtar kelime)'lerden biri değildir?",
                "int",
                "String",
                "Char",
                "void",
                Soru.Cevap._B
        );*/
       
        sorular.başlat();
        
        
        
        
        /*
        JFrame frame = new JFrame("Radio Buton");
        
        JPanel panel1 = new JPanel();
        
        RadioButtonPaneli buton1 = new RadioButtonPaneli();
        ÇButton çbuton = new ÇButton();
        
        panel1.add(buton1);
        panel1.add(çbuton);
        
        frame.add(panel1);
        frame.setSize(140,360);
        frame.setVisible(true);
        
        
        
        
        /*
        JFrame pencere = new JFrame("Ders Denemesi");
        
        pencere.add(new CheckBoxPaneli());
        pencere.setBounds(240, 180, 320, 240);
        pencere.setVisible(true);
        
        /*
        TextFieldDenemesi panel1 = new TextFieldDenemesi();
     
        pencere.add(panel1);
        pencere.setSize(210,180);
        pencere.setResizable(false);
        pencere.setVisible(true);
     
        /*
         ButonDenemesi panel1 = new ButonDenemesi();
     
        pencere.add(panel1);
        pencere.setSize(210,180);
        pencere.setVisible(true);
        */
    }
    
}
