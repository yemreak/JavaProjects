package ders.insan;

public class İnsan {
    String isim;
    int yaş;
    
    public İnsan(){
        this.isim = "İsimsiz";
        this.yaş = -1;
    }
    
    public void setİsim(String name){
        this.isim = name;
    }
    
    public void setYaş(int yaş){
        this.yaş = yaş;
    }
    
    public String getİsim(){
        return this.isim;
    }
    
    public int getYaş(){
        return this.yaş;
    }
    
    public String getBilgi(){
        return (this.isim+" "+this.yaş);
    }
    
}
