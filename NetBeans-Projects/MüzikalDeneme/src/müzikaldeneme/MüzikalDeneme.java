/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package müzikaldeneme;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Yunus Emre
 */
public class MüzikalDeneme extends JPanel implements KeyListener{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame a = new JFrame();
        
        MüzikalDeneme b = new MüzikalDeneme();
        a.addKeyListener(b);
        
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.add(b);
        a.setSize(400,400);
        a.setVisible(true);
        
        
    }
    
    
    
    
    /**
     * Notoları tutan dizi ve boyutu
     */  
    String[] notalar;
    int notaSayısı = 8;
   
    /**
     * Notalar
     */
    String DO = "DO";
    
    public MüzikalDeneme(){
        super();
        
        notalarıTanımla();
        
        addKeyListener(this);
    }
    
    /**
     * Notaları diziye aktarma
     */
    public void notalarıTanımla(){
        notalar = new String[notaSayısı];
        
        notalar[1] = "DO";
        notalar[2] = "RE";
        notalar[3] = "Mİ";
        notalar[4] = "FA";
        notalar[5] = "SOl";
        notalar[6] = "LA";
        notalar[7] = "Sİ";
    }
    
    /**
     * Ses çalma
     * @param dosyaYolu Çalınacak dosyanın konumu
     */
    public static void sesÇal(String dosyaYolu){
        try {
            // Çalınacak ses dosyasının yolunu tanıtan değişken
            InputStream müzikYolu = new FileInputStream(dosyaYolu);
            
            AudioStream müzik = new AudioStream(müzikYolu);
            AudioPlayer.player.start(müzik);
            
            
        } 
        catch (IOException ex) {
            System.err.println("Hata : " + ex.getMessage());
        }
    }

    public void notaÇal(int n){
        if(n < notaSayısı)
        sesÇal("musics\\" + notalar[n] + ".wav");
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.print(e.getKeyCode() - 48);
        notaÇal(e.getKeyCode() - 48);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
}
