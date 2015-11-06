import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class CaesarCipher{

    private int shift;

    public CaesarCipher(int shift){

        this.shift=shift;

    }

    public void enkripsi (String sumber, String sasaran) throws IOException {
        FileInputStream masukan = null;
        FileOutputStream keluaran = null;

        // Deklarasi variabel
        try {
            // Object stream untuk masukkan
            masukan = new FileInputStream(sumber);
            keluaran = new FileOutputStream(sasaran);// ambil objek abestu bukak nama berkasnya kalaok ga ada dia throw excepytion 

            // Coba baca  dari stream
            int karakter = masukan.read();
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {// kalau minus 1 dia selesai
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
               karakter+=shift;
                keluaran.write((char)karakter);
                
                // Coba baca lagi dari stream
                 
                karakter = masukan.read();
            }
          
            keluaran.flush();
        }catch(IOException kesalahan){
            System.out.print("salah : %s, kesalahan");
        } 
        finally {
            // Tutup stream masukan
            if (masukan != null)
                masukan.close();
            if (keluaran != null)
                keluaran.close();

        }
       
    }
        
    public void dekripsi (String sumber, String sasaran) throws IOException {
        FileInputStream masukan = null;
        FileOutputStream keluaran = null;

        // Deklarasi variabel
        try {
            // Object stream untuk masukkan
            masukan = new FileInputStream(sumber);
            keluaran = new FileOutputStream(sasaran);// ambil objek abestu bukak nama berkasnya kalaok ga ada dia throw excepytion 

            // Coba baca  dari stream
            int karakter = masukan.read();
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {// kalau minus 1 dia selesai
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                karakter-=shift;
                keluaran.write((char)karakter);
                // Coba baca lagi dari stream
                
                karakter = masukan.read();
                
            }
            keluaran.flush();
        }catch(IOException kesalahan){
            System.out.print("salah : %s, kesalahan");
        
        }
         
        finally {
            // Tutup stream masukan
            if (masukan != null)
                masukan.close();
            if (keluaran != null)
                keluaran.close();

        }
    }
     public static void main(String[] args)  {
        try {
            CaesarCipher baru = new CaesarCipher(3);
            baru.enkripsi("ujisumber.txt","ujisasaran.txt");
            baru.dekripsi("ujisumber.txt","uji.txt");
        }
        catch (IOException kesalahan) {
            System.out.printf("Terjadi kesalahan: %s", kesalahan);
        }
    }
     
}