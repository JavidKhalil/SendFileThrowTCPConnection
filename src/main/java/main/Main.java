/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import threads.ThreadsOne;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        ThreadsOne one = new ThreadsOne();
//        ThreadsTwo two = new ThreadsTwo();

        Thread one1 = new Thread(one);
  //      Thread two1 = new Thread(two);

        one1.start();
    //    two1.start();

    }

}
