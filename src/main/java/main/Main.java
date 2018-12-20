/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) {

        String user;
        String url;
        String tcpIn;
        String tcpIp;
        int tcpPort;
        user = com.bean.User.userInfo();
        url = com.bean.UrlInfo.sendFileUrl();
        tcpIn = com.bean.TcpInfo.tcpInfo();
        String[] str = tcpIn.split(":");
        tcpIp = str[0];
        tcpPort = Integer.parseInt(str[1]);
    }
//Və bu ip port-a daxil olub həmin faylı göndərəcəksiniz göndərdikdən sonra da mesaj çapa verəcəksiniz ki, uğurla göndərildi.

}
