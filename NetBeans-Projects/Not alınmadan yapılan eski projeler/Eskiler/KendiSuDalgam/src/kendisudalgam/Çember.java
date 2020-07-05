
package kendisudalgam;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Çember extends JPanel{
    
    int[] konum;
    int genişlik;

    public Çember(int konumX, int konumY, int genişlik) {
        super();
        konum = new int[2];
        this.konum[0] = konumX;
        this.konum[1] = konumY;
        this.genişlik = genişlik;
    }
    
    public void ekranaÇiz(Graphics g){
        super.paint(g); // Bunu koyarsam 1 tane çizer, her yeni durumda eskisini siler.
        g.drawOval(konum[0], konum[1], genişlik, genişlik);
    }
}
