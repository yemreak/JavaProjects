
package grafikarayüzü;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Dörtgen {
    
    Rectangle r;
    int vX, vY; // X ve Y hızları
    
    public Dörtgen(int x, int y, int width, int height, int vX, int vY){
        
        r= new Rectangle(x, y, width, height);
        this.vX = vX;
        this.vY = vY;
    }
    
    public Dörtgen(int x, int y, int width, int height){
        
        r = new Rectangle(x, y, width, height);
        vX = 0;
        vY = 0;
    }
    
    public void ekranÇiz(Graphics g){
        g.drawRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
    }
    
    public void hareketEt(int x, int y, Dörtgen[] diğerleri, int sayı){
        
        Rectangle geçici = new Rectangle(r);
        geçici.setLocation((int)geçici.getX() + x, (int)geçici.getY() + y);
        
        boolean çakışma = false;
        
        for(int i = 0; i < sayı; i++){
            if(geçici.intersects(diğerleri[i].getRectangle()) ||
               geçici.getX() < 0   || geçici.getY() < 0       ||
               geçici.getX() > 610 || geçici.getY() > 425
              )
                çakışma = true;
        }
        if (çakışma == false){
            r.setLocation((int)r.getX() + x,(int)r.getY() + y);
        }
    }
    public void hareketEt(Dörtgen[] diğerleri, int sayı){
        
        Rectangle geçici = new Rectangle(r);
        geçici.setLocation((int)geçici.getX() + vX, (int)geçici.getY() + vY);
        
        boolean çarpışma = false;
        
        for(int i = 0; i < sayı; i++){
            
            if( (!this.equals(diğerleri[i])) && (
                geçici.intersects(diğerleri[i].getRectangle()) || 
                geçici.getX() < 0   || 
                geçici.getY() < 0   || 
                geçici.getX() > 610 || 
                geçici.getY() > 425
                    )
            )
                çarpışma = true;
        }
           
            if(çarpışma == false){
                
                r.setLocation((int)r.getX() + vX, (int)r.getY() + vY);
            }
            else{
                
                vX = -vX;
                vY = -vY;
            }
    }
    public void hareketEt(Dörtgen a, Dörtgen[] diğerleri, int sayı){
        
        Rectangle geçici = new Rectangle(r);
        geçici.setLocation((int)geçici.getX() + vX, (int)geçici.getY() + vY);
        
        boolean çarpışma = false;
        
        for(int i = 0; i < sayı; i++){
            
            if( (!this.equals(diğerleri[i])) && (!this.equals(a)) && (
                geçici.intersects(a.getRectangle()) ||
                geçici.intersects(diğerleri[i].getRectangle()) || 
                geçici.getX() < 0   || 
                geçici.getY() < 0   || 
                geçici.getX() > 610 || 
                geçici.getY() > 425
                    )
            )
                çarpışma = true;
        }
           
            if(çarpışma == false){
                
                r.setLocation((int)r.getX() + vX, (int)r.getY() + vY);
            }
            else{
                
                vX = -vX;
                vY = -vY;
            }
    }
    public void hareketEt(int x, int y, Dörtgen a, Dörtgen[] diğerleri, int sayı){
        
        Rectangle geçici = new Rectangle(r);
        geçici.setLocation((int)geçici.getX() + x, (int)geçici.getY() + y);
        
        boolean çarpışma = false;
        
        for(int i = 0; i < sayı; i++){
            
            if( (!this.equals(diğerleri[i])) && (
                geçici.intersects(diğerleri[i].getRectangle()) || 
                geçici.getX() < 0   || 
                geçici.getY() < 0   || 
                geçici.getX() > 610 || 
                geçici.getY() > 425
                    )
            )
                çarpışma = true;
        }
           
            if(çarpışma == false){
                
                r.setLocation((int)r.getX() + x, (int)r.getY() + y);
            }
            else{
                r.setLocation((int)r.getX() - x, (int)r.getY() - y);
            }
    }
    
    public Rectangle getRectangle(){
        return this.r;
    }
}
