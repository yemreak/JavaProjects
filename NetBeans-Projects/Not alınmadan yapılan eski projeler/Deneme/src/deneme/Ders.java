package deneme;
public class Ders {
    String ders;
    String hoca;
    int sinif;
    public Ders(String x, String x1,int x2){
        this.ders=x;
        this.hoca=x1;
        this.sinif=x2;
        System.out.println(ders+"'i"+hoca+" tarafindan "+sinif+"'lara verilmektedir.\n");
        String liste[]=new String[10];
        liste[0]="Silan java'yı unutmaa";
        System.out.println(liste[0]);
    }
}
