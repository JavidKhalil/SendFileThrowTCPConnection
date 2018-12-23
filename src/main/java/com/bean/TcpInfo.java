package com.bean;

import java.util.Scanner;

public class TcpInfo {

    public static String tcpIpForServer = getTcpIpForServer();
    public static int tcpPortForServer = getTcpPortForServer();
    public static int tcpPortForClient = tcpPortForServer;
    public static String tcpIpForClient = tcpIpForServer;

    public static String getTcpIpForServer() {
        Scanner ss = new Scanner(System.in);
        System.out.println("Please enter the ip number of server, enter localhost");
        tcpIpForServer = ss.next();
        if (tcpIpForServer != "localhost") {
            System.out.println("We confirm only localhost");
        }
        tcpIpForServer = "127.0.0.1";
        return tcpIpForServer;
    }

    public static int getTcpPortForServer() {
        Scanner ss1 = new Scanner(System.in);
        System.out.println("Please enter the port number of server");
        tcpPortForServer = ss1.nextInt();
        return tcpPortForServer;
    }

}
