package server;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TcpClient {

    public static void main(String[] args) throws IOException {
        Socket sock = null;
        String host = com.bean.TcpInfo.tcpInfo().split(":")[0];
        int port = 5679;
        String url = com.bean.UrlInfo.sendFileUrl();
        int fileSize = Integer.MAX_VALUE;

        int bytesRead;
        int current = 0;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            sock = new Socket(host, port);
            System.out.println("Connecting...");
            byte[] mybytearray = new byte[fileSize];
            InputStream is = sock.getInputStream();
            fos = new FileOutputStream(url);
            bos = new BufferedOutputStream(fos);
            bytesRead = is.read(mybytearray, 0, mybytearray.length);
            current = bytesRead;
            do {
                bytesRead = is.read(mybytearray, current, (mybytearray.length - current));
                if (bytesRead >= 0) {
                    current += bytesRead;
                }
            } while (bytesRead > -1);
            bos.write(mybytearray, 0, current);
            bos.flush();
            System.out.println("File " + url + " downloaded (" + current + " bytes read)");
        } finally {
            if (fos != null) {
                fos.close();
            }
            if (bos != null) {
                bos.close();
            }
            if (sock != null) {
                sock.close();
            }
        }
    }

}
