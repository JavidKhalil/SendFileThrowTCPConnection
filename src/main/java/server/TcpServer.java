package server;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TcpServer implements Runnable {

    public static String host = "127.0.0.1";
    //com.bean.TcpInfo.tcpIpForServer;
    public static int port = com.bean.TcpInfo.tcpPortForServer;
    public static String whereWriteFile = "test.txt";
    public static String user = com.bean.User.user;
    public static String message = "Salam dost";

    @Override
    public void run() {
        try {
            TcpServer.beginSendToClient(host, port, whereWriteFile, user, message);
        } catch (IOException ex) {
            System.out.println("Could not connect to server");
            ex.getMessage();
        }
    }

    public static void beginSendToClient(String host, int portNum,
            String whereWriteFile, String user, String message) throws IOException {
        int FILE_SIZE = 6000000;
        int bytesRead;
        int current = 0;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        Socket sock = null;
        try {
            sock = new Socket(host, portNum);
            System.out.println("Connecting...");
            byte[] mybytearray = new byte[FILE_SIZE];
            InputStream is = sock.getInputStream();
            fos = new FileOutputStream(whereWriteFile);
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
            System.out.println("File " + whereWriteFile + " downloaded (" + current + " bytes read)");
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
