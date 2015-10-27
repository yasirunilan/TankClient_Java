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
    private DataOutputStream outstream;
    private ServerSocket serverSocket;
private boolean connect() { //connect to the server
		try {
			socket = new Socket("localhost", 6000);
			outstream = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("Can't connect to the server ");
			return false;
		}
		System.out.println("Successfully connected to the server.");
		return true;
	}

    
    public void run(String msg){
     connect();
        try {        
            outstream.writeBytes(msg);
            outstream.flush();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(TankClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
}
