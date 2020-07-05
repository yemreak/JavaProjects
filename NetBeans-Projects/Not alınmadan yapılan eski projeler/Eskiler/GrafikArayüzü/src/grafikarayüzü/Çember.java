
package grafikarayüzü;

import java.awt.Graphics;

public class Çember {
    
    int x,y,genişlik;
    
    public Çember(int x, int y, int genişlik){
        this.x = x;
        this.y = y;
        this.genişlik = genişlik;
    }
    
    public void ekranÇiz(Graphics g){
        g.drawOval(x, y, genişlik, genişlik);
    }
    
    public void genişle(int i){
            this.genişlik += i;
            this.x -= i/2;
            this.y -= i/2;
    }
}
