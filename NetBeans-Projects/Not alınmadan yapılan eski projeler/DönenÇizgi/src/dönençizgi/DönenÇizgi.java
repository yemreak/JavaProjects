
package dönençizgi;

import javax.swing.JFrame;

public class DönenÇizgi {

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        
        İçiDoluÇokgen panel1 = new İçiDoluÇokgen(640,480);
        frame.add(panel1);
        
        frame.setSize(651,514);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        
             /* 
        Kare dönenkare = new Kare(640,480);
        frame.add(dönenkare);
        frame.addKeyListener(dönenkare);
     
        frame.setSize(651,514); // 11 / 34 çerçeveye gidiyor.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        */
        
        
        
        /*
        Çizgi çizgi1 = new Çizgi(640,480);
        frame.add(çizgi1);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(651,514); // 11-34 kayma oranı (çerçeveye gidiyor).
        frame.setVisible(true);
        frame.setResizable(false);
*/
    }
    
}
