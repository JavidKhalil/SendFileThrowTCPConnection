/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Url1 {

    public static String fileTosend = sendFileUrl();

    public static String sendFileUrl() {
        String url;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the full url of your file");
        url = scan.next();
        return url;
    }

}
