package com.bean;

import java.util.Scanner;

public class TcpInfo {

    public static String tcpInfo() {
        String tcpIp;
        String tcpPort;
        Scanner ss = new Scanner(System.in);
        System.out.println("Please enter the ip number of server");
        tcpIp = ss.next();
        Scanner ss1 = new Scanner(System.in);
        System.out.println("Please enter the ip number of server");
        tcpPort = ss1.next();
        return tcpIp + ":" + tcpPort;
    }

}
