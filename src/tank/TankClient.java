/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tank;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yasiru
 */
public class TankClient extends Thread {
    private Socket socket;
    private DataOutputStream dos;
    private String ip="localhost";
    private ServerSocket serverSocket;
    private int port=6000;
private boolean connect() {
		try {
			socket = new Socket(ip, port);
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("Unable to connect to the address: ");
			return false;
		}
		System.out.println("Successfully connected to the server.");
		return true;
	}

    
    public void run(String msg){
     connect();
        try {        
            dos.writeBytes(msg);
            dos.flush();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(TankClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
}
