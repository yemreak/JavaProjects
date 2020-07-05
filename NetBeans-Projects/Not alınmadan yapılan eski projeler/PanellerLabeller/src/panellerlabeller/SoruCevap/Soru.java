
package panellerlabeller.SoruCevap;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Soru extends JPanel{
    
    String soru;
    String şıkA,şıkB,şıkC,şıkD;
    JLabel l;
    JRadioButton r1,r2,r3,r4;
    ButtonGroup g1;
    // enum'da değişken kullanıcı tarafından alınır. 
    public enum Cevap{
        _A,
        _B,
        _C,
        _D
    }
    
    Cevap doğrucevap;
    
    public Soru(
            String soru, String şıkA, String şıkB, 
            String şıkC, String şıkD, Cevap cevap
            ){
        this.soru = soru;
        this.şıkA = şıkA;
        this.şıkB = şıkB;
        this.şıkC = şıkC;
        this.şıkD = şıkD;
        this.doğrucevap = cevap;
        
        setLayout(new GridLayout(5,1));
        
        l = new JLabel(soru);
        
        r1 = new JRadioButton(şıkA);
        r2 = new JRadioButton(şıkB);
        r3 = new JRadioButton(şıkC);
        r4 = new JRadioButton(şıkD);
        
        g1 = new ButtonGroup();
        
        g1.add(r1);
        g1.add(r2);
        g1.add(r3);
        g1.add(r4);
        
        add(l);
       
        add(r1);
        add(r2);
        add(r3);
        add(r4);
        
    }
    
    public Soru(
            String soru, String şıkA, String şıkB, 
            String şıkC, String şıkD, String cevap
            ){
        this.soru = soru;
        this.şıkA = şıkA;
        this.şıkB = şıkB;
        this.şıkC = şıkC;
        this.şıkD = şıkD;
        
        if(cevap.equalsIgnoreCase("A")){
            doğrucevap = Soru.Cevap._A;
        }
        else if(cevap.equalsIgnoreCase("B")){
            doğrucevap = Soru.Cevap._B;
        }
        else if(cevap.equalsIgnoreCase("C")){
            doğrucevap = Soru.Cevap._C;
        }
        else if(cevap.equalsIgnoreCase("D")){
            doğrucevap = Soru.Cevap._D;
        }
        
        setLayout(new GridLayout(5,1));
        
        l = new JLabel(soru);
        
        r1 = new JRadioButton(şıkA);
        r2 = new JRadioButton(şıkB);
        r3 = new JRadioButton(şıkC);
        r4 = new JRadioButton(şıkD);
        
        g1 = new ButtonGroup();
        
        g1.add(r1);
        g1.add(r2);
        g1.add(r3);
        g1.add(r4);
        
        add(l);
       
        add(r1);
        add(r2);
        add(r3);
        add(r4);

    }
    
    public void seçiliOlanıSıfırla(){
        g1.clearSelection();
    }
    
    public void değiştir(Soru s){
        this.l.setText(s.soru);
        this.r1.setText(s.şıkA);
        this.r2.setText(s.şıkB);
        this.r3.setText(s.şıkC);
        this.r4.setText(s.şıkD);
        this.doğrucevap = s.doğrucevap;
    }
    
    public String alSoru(){
        return soru + şıkA + şıkB + şıkC + şıkD;
    }
    boolean cevapKontrol(){
        
        if(r1.isSelected() && doğrucevap == doğrucevap._A){
            //System.out.println("A");
            r1.setSelected(false);
            return true;
        }
        else if(r2.isSelected() && doğrucevap == doğrucevap._B){
            //System.out.println("B");
            r2.setSelected(false);
            return true;
        }
        else if(r3.isSelected() && doğrucevap == doğrucevap._C){
            //System.out.println("C");
            r3.setSelected(false);
            return true;
        }
        else if(r4.isSelected() && doğrucevap == doğrucevap._D){
            //System.out.println("D");
            r4.setSelected(false);            
            return true;
        }
        else
            return false;
    }   
}
