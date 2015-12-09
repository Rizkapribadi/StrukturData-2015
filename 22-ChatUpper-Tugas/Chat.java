
/**
 * Write a description of class Utama here.
 * 
 * @author Rizka Pribadi
 * @NIM :1408107010010
 */
import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.io.BufferedInputStream;

public class Chat
{
    public void chat(String pesanChat) 
                throws UnknownHostException, IOException {
        // 0. Buka socket
        koneksi = new Socket("192.168.43.153", 33333);

        // Kirim perintah untuk informasi namaDomain
        kirimPesan(pesanChat);
        
        // Baca balasannya
        bacaBalasan();
        
        // Tutup socket-nya => dengan sendirinya menutup semua stream
        koneksi.close();
    }
    
    public void kirimPesan(String pesan) throws IOException {
        // 1 & 2. Minta socket untuk ditulis dan Langsung dibuka
        OutputStream keluaran = koneksi.getOutputStream();
        // Note: Karena protokol-nya berbasis teks pakai writer aja.
        Writer keluaranWriter = new OutputStreamWriter(keluaran); 
        // 3. Selagi ada data kirim
        keluaranWriter.write(pesan);
        // Syarat protokol-nya, semua perintah diakhiri dengan: CR & LF
        keluaranWriter.write("\r\n"); 
        keluaranWriter.flush(); // Paksa kirim data yang belum terkirim
    }
    
    public void bacaBalasan() throws IOException {
        // 1 & 2. Minta socket untuk baca -> Langsung dibuka
        InputStream masukan = koneksi.getInputStream();
        // Karena keluarannya panjang sehingga harus dibuffer
        BufferedInputStream masukanBuffer = new BufferedInputStream(masukan);
        
        System.out.print("Server: ");
        
        // Selagi masih ada data baca 
        String balasan = "";
        int data = masukanBuffer.read();
        while (data != -1) {
            System.out.write((char) data);
            balasan = balasan + Character.toUpperCase((char) data);
            
            data = masukanBuffer.read();                       
        }
        
        System.out.println("Client: "+balasan);
        kirimPesan(balasan);
    }
    
    private Socket koneksi = null;
}
