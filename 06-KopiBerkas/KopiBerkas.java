import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class KopiBerkas {
    public void kopi(String sumber, String sasaran) throws IOException { // throw kalo ada kesalahan  kalo gada jalanin dr  try sampe while,        FileInputStream masukan = null;
       
        FileInputStream masukan = null;
         FileOutputStream keluaran = null;
        // Deklarasi variabel
        try { //ekseption = mekanisme untuk menangkap kesalahan dengan diuji misal pembagian dengan nol kalo b/0 b itu nol apa gak 
            // Object stream untuk masukkan
            masukan = new FileInputStream(sumber); //nilai awal
            keluaran = new FileOutputStream(sasaran);

            // Coba baca  dari stream
            int karakter = masukan.read();
            
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                // Coba baca lagi dari stream
                 keluaran.write(karakter);
                karakter = masukan.read();
               
                
            }
            keluaran.flush(); 
        }
        catch (IOException kesalahan) {
            System.out.printf("Terjadi kesalahan: %s", kesalahan);

        }

        finally { //salah ga salah file yang dibawah tetep di jalankan 
            // Tutup stream masukan
            if (masukan != null)
                masukan.close(); //wajib di tuutup
            if (keluaran != null)
                keluaran.close();
        }

    }

}
    
