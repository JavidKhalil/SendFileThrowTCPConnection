package server;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import threads.ThreadsTwo;

public class TcpServer {

    public static void beginServer() throws IOException {

        int port = Integer.parseInt(com.bean.TcpInfo.tcpPortForServer);
        String url = com.bean.Url1.sendFileUrl();

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        ServerSocket servsock = null;
        Socket sock = null;

        servsock = new ServerSocket(port);
        while (true) {
            System.out.println("Waiting...");
            ThreadsTwo two = new ThreadsTwo();
            Thread two1 = new Thread(two);
            two1.start();
            if ((sock = servsock.accept()) != null) {
                System.out.println("Accepted connection : " + sock);
            }
            File myFile = new File(url);
            byte[] mybytearray = new byte[(int) myFile.length()];
            fis = new FileInputStream(myFile);
            bis = new BufferedInputStream(fis);
            bis.read(mybytearray, 0, mybytearray.length);
            os = sock.getOutputStream();
            System.out.println("Sending " + url + "(" + mybytearray.length + " bytes)");
            os.write(mybytearray, 0, mybytearray.length);
            os.flush();
            System.out.println("Done.");
            if (bis != null) {
                bis.close();
            }
            if (os != null) {
                os.close();
            }
            if (sock != null) {
                sock.close();
            }
        }
    }
}
