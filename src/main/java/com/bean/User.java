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
public class User {

    public static String name;
    public static String surname;
    public static String user = name + ":" + surname;

    public static String userInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name");
        name = sc.next();
        System.out.println("Please enter your surname");
        Scanner sc1 = new Scanner(System.in);
        surname = sc1.next();
        return name + ":" + surname;
    }

}
