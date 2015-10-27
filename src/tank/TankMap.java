/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tank;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Yasiru
 */
public class TankMap {
   static int mapMax=10;
   static String map[][]=new String[mapMax][mapMax];
   static int x=0,y=0;
   static ArrayList<String> Player1;
   static ArrayList<String> Player2;
   static ArrayList<String> Player3;
   static ArrayList<String> Player4;
   static ArrayList<String> Player5;
   
    
    public static void createMap(String address){
        
        String I;
        String playerID;
        String brick;
        String stone;
        String water;
        ArrayList<String> brick_pos = new ArrayList<String>();
        ArrayList<String> stone_pos = new ArrayList<String>();
        ArrayList<String> water_pos = new ArrayList<String>();
        
String new_add=address.substring(0, address.length()-1);// to remove last # mark
        StringTokenizer str = new StringTokenizer(new_add, ":");
        I = str.nextToken();//check first value I,G, S etc
        playerID = str.nextToken();//get player names
        brick = str.nextToken();//get bricks pattern
        stone = str.nextToken();//get stones pattern
        water = str.nextToken();//get water patterns
        System.out.println("I = "+I+" brick = "+brick+" stone = "+stone+" water = "+water);
        
        StringTokenizer bri=new StringTokenizer(brick, ";");
        for(int i=0;bri.hasMoreTokens();i++){
            brick_pos.add(i, bri.nextToken());
        }
        StringTokenizer sto=new StringTokenizer(stone, ";");
        for(int i=0;sto.hasMoreTokens();i++){
            stone_pos.add(i, sto.nextToken());
        }
        StringTokenizer wat=new StringTokenizer(water, ";");
        for(int i=0;wat.hasMoreTokens();i++){
            water_pos.add(i, wat.nextToken());
        }
        for(int i=0;i<mapMax;i++){
            for(int j=0;j<mapMax;j++){
                map[i][j]="0";
            } }
        for(int i=0;i<brick_pos.size();i++){
            String positions[]=brick_pos.get(i).split(",");
            x=Integer.parseInt(positions[0]);
            y=Integer.parseInt(positions[1]);
            map[y][x]="1";//1 for brick
        }
        for(int i=0;i<stone_pos.size();i++){
            String positions[]=stone_pos.get(i).split(",");
            x=Integer.parseInt(positions[0]);
            y=Integer.parseInt(positions[1]);
            map[y][x]="2";//2 for stone
        }
        for(int i=0;i<water_pos.size();i++){
            String positions[]=water_pos.get(i).split(",");
            x=Integer.parseInt(positions[0]);
            y=Integer.parseInt(positions[1]);
            map[y][x]="3";//3 for water
        }
        printMap();
         
    }
    private static void printMap(){ //print the map in the console
        for(int i=0;i<mapMax;i++){
            for(int j=0;j<mapMax;j++){
                System.out.print(map[i][j] +"  ");
            } 
             System.out.println();
         }
        
    }
    public static void updateMap(String G){ //update map details
        String raw_st = G.substring(2,G.length());
        
       
        StringTokenizer upmap=new StringTokenizer(raw_st, ":");
        for(int i=0;upmap.hasMoreTokens();i++){
            
            String k=upmap.nextToken();
            if(k.charAt(0)=='P'){
                playerUpdateStatus(k);
            }
        
        
    }
        
    
}
    private static void playerUpdateStatus(String P){ //update the player status
        
        
            ArrayList<String> tokens=new ArrayList<String>();
            StringTokenizer player=new StringTokenizer(P, ";");
            while(player.hasMoreTokens()){
                tokens.add(player.nextToken());
            }
            String positions[]=tokens.get(1).split(",");
            x=Integer.parseInt(positions[0]);
            y=Integer.parseInt(positions[1]);
            
            
            map[y][x]=tokens.get(0);
            if("Player1".equals(tokens.get(0))){
                Player1 =tokens;
            }
            else if("Player2".equals(tokens.get(0))){
                Player2 =tokens;
            }
            else if("Player3".equals(tokens.get(0))){
                Player3 =tokens;
            }
            else if("Player4".equals(tokens.get(0))){
                Player4 =tokens;
            }
            else if("Player5".equals(tokens.get(0))){
                Player5 =tokens;
            }
            printMap();
            System.out.println(Player1);
            System.out.println(Player2);
        }
    public static void getLifePacks(String L){ //this is about life packets
        
        String details[]=L.split(":");
        String[] positions =details[0].split(",");
        x=Integer.parseInt(positions[0]);
        y=Integer.parseInt(positions[1]);
        int time=Integer.parseInt(details[1].substring(0,(details[1]).length()-1));
        System.out.println("LIFE PACK X  ="+  y+" Y =" +x+" time "+ time);
        
    }

    
    
    
}
