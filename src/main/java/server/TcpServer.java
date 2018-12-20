package server;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    
        public static int port =  Integer.parseInt(com.bean.TcpInfo.tcpInfo().split(":")[1]);
        public static String url = com.bean.UrlInfo.sendFileUrl();  

        public static void main(String[] args) throws IOException {
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            OutputStream os = null;
            ServerSocket servsock = null;
            Socket sock = null;
            try {
                servsock = new ServerSocket(port);
                while (true) {
                    System.out.println("Waiting...");
                    try {
                        sock = servsock.accept();
                        System.out.println("Accepted connection : " + sock);
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
                    } finally {
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
            } finally {
                if (servsock != null) {
                    servsock.close();
                }
            }
        }
    }
