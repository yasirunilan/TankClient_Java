/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yasiru
 */
public class TankMain extends Thread {

    /**
     * @param args the command line arguments
     */
    ServerSocket serverSocket;
    Socket socket;
    TankClient client;
    public TankMain(TankClient client) throws IOException{
        serverSocket=new ServerSocket(7000);
        this.client=client;
    }
    @Override
    public void run(){
        client.run("JOIN#");//this is the request to join the game server
        
        while(true){
            try {
                socket=serverSocket.accept();
                BufferedReader msg=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String string=msg.readLine();
                System.out.println(string);
                if(string.charAt(0)=='I'&&string.charAt(1)==':'){//for priority I
                    TankMap.createMap(string);
                }
                if(string.charAt(0)=='G'&&string.charAt(1)==':'){
                    
                    TankMap.updateMap(string);
                }
                 
            } catch (IOException ex) {
                Logger.getLogger(TankMain.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }
    public static void main(String[] args) {
        TankClient tankClient=new TankClient();
        try {
            TankMain tankServer=new TankMain(tankClient);
            tankServer.start();
        } catch (IOException ex) {
            Logger.getLogger(TankMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
