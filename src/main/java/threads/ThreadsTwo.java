/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author User
 */
public class ThreadsTwo implements Runnable {

    @Override
    public void run() {
        try {
            server.TcpClient.beginClient();
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
