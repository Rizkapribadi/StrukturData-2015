
public class Gabung
{
    private double[] data;
    private Kelompok[] kelompok = new Kelompok[5]  ;
    
    public Gabung (double[] data ){
        
        
        for (int i=0; i<5; i++){
            
            int awal = i*(data.length/5);
            int akhir = awal+((data.length/5)-1);
            kelompok [i] = new Kelompok (awal,akhir,data);
        
        }
        
        Thread d1 = new Thread(kelompok [0]);
        Thread d2 = new Thread(kelompok [1]);
        Thread d3 = new Thread(kelompok [2]);
        Thread d4 = new Thread(kelompok [3]);
        Thread d5 = new Thread(kelompok [4]);

        d1.start();
        d2.start();
        d3.start();
        d4.start();
        d5.start();
        
    }
    
    public double hasil (){
        
        try {
            Thread.sleep (1000);
        }
        
        catch (InterruptedException e){
            System.out.println ("Terjadi Kesalahan");
        }
        double hasil =0;
        for (int i=0; i<5; i++){
            hasil=hasil+kelompok[i].hasil();
        }
        return hasil;
    }
    
    
}
