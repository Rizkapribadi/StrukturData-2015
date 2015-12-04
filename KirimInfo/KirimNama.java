import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.io.BufferedInputStream;

public class KirimNama {    
    public void whois(String KirimNama) 
                throws UnknownHostException, IOException {
        // 0. Buka socket
        koneksi = new Socket("192.168.43.139", 33333);//protokol who is//pandi pengendali utama

        // Kirim perintah untuk informasi namaDomain
        kirimPerintah(KirimNama);
        
        // Baca balasannya
      

        // Tutup socket-nya => dengan sendirinya menutup semua stream
        koneksi.close();
    }
    
    public void kirimPerintah(String KirimNama) throws IOException {
        // 1 & 2. Minta socket untuk ditulis dan Langsung dibuka
        OutputStream keluaran = koneksi.getOutputStream();
        // Note: Karena protokol-nya berbasis teks pakai writer aja.
        Writer keluaranWriter = new OutputStreamWriter(keluaran); 
        // 3. Selagi ada data kirim
        keluaranWriter.write(KirimNama);
        // Syarat protokol-nya, semua perintah diakhiri dengan: CR & LF
        keluaranWriter.write("Rizka Pribadi(1408107010010)"); 
        keluaranWriter.flush(); // Paksa kirim data yang belum terkirim
    }
    
    
    
    private Socket koneksi = null;
}
