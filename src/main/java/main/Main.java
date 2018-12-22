/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import server.TcpServer;

/**
 *
 * @author User
 */
public class Main {

    public static String host = com.bean.TcpInfo.tcpIpForServer;
    public static int port = com.bean.TcpInfo.tcpPortForServer;
    public static String whereWriteFile = "test.txt";
    public static String user = com.bean.User.user;
    public static String message = "Salam dost";

    public static void main(String[] args) throws IOException, InterruptedException {

        Thread threadOne = new Thread(new TcpServer());
        threadOne.start();
        threadOne.join(3000);

        Client1ForSocketServer.sendFile(host, port, "D:\bir.txt");
    }

}
