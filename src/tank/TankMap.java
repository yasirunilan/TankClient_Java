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
        ArrayList<String> brick_pos = new ArrayList<>();
        ArrayList<String> stone_pos = new ArrayList<>();
        ArrayList<String> water_pos = new ArrayList<>();
        
String new_add=address.substring(0, address.length()-1);// to remove last # mark
        StringTokenizer str = new StringTokenizer(new_add, ":");
        I = str.nextToken();//check first value I,G, S etc
        playerID = str.nextToken();//get player names
        brick = str.nextToken();//get bricks pattern
        stone = str.nextToken();//get stones pattern
        water = str.nextToken();//get water patterns
        System.out.println("I = "+I+" brick = "+brick+" stone = "+stone+" water = "+water);
//        System.out.println("I = "+I+" brick = "+brick+" stone = "+stone+" water = "+water);
//        System.out.println("I = "+I+" brick = "+brick+" stone = "+stone+" water = "+water);
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
                map[i][j]="N";
            } }
       for (String brick_po : brick_pos) {
           String[] positions = brick_po.split(",");
           x=Integer.parseInt(positions[0]);
           y=Integer.parseInt(positions[1]);
           map[y][x]="B";//1 for brick
       }
       for (String stone_po : stone_pos) {
           String[] positions = stone_po.split(",");
           x=Integer.parseInt(positions[0]);
           y=Integer.parseInt(positions[1]);
           map[y][x]="S";//2 for stone
       }
       for (String water_po : water_pos) {
           String[] positions = water_po.split(",");
           x=Integer.parseInt(positions[0]);
           y=Integer.parseInt(positions[1]);
           map[y][x]="W";//3 for water
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
        
       
        StringTokenizer updateMap=new StringTokenizer(raw_st, ":");
        for(int i=0;updateMap.hasMoreTokens();i++){
            
            String k=updateMap.nextToken();
            if(k.charAt(0)=='P'){
                playerUpdateStatus(k);
            }
        
        
    }
        
    
}
    private static void playerUpdateStatus(String P){ //update the player status
        
        
            ArrayList<String> tokens=new ArrayList<>();
            StringTokenizer player=new StringTokenizer(P, ";");
            while(player.hasMoreTokens()){
                tokens.add(player.nextToken());
            }
            String positions[]=tokens.get(1).split(",");
            x=Integer.parseInt(positions[0]);
            y=Integer.parseInt(positions[1]);
            
            
            map[y][x]=tokens.get(0);
            if(null != tokens.get(0))switch (tokens.get(0)) {
           case "Player1":
               Player1 =tokens;
               break;
           case "Player2":
               Player2 =tokens;
               break;
           case "Player3":
               Player3 =tokens;
               break;
           case "Player4":
               Player4 =tokens;
               break;
           case "Player5":
               Player5 =tokens;
               break;
       }
            printMap();
            System.out.println(Player1);
            System.out.println(Player2);
        }
    public static void getLifePacks(String L){ //this is about life packets
        
        //System.out.println("details "+L);
        String details[]=L.split(":");
        String[] positions =details[1].split(",");
        x=Integer.parseInt(positions[0]);
        y=Integer.parseInt(positions[1]);
        map[y][x]="L";
        int time=Integer.parseInt(details[2].substring(0,(details[2]).length()-1));
        //System.out.println("LIFE PACK X  ="+  y+" Y =" +x+" time "+ time);
        System.out.println("LIFE PACK X  ="+  y+" Y =" +x);
        //System.out.println();
    }

    
    public static void getCoinPiles(String C){ //this is about life packets
        
        //System.out.println("details "+L);
        String details[]=C.split(":");
        String[] positions =details[1].split(",");
        x=Integer.parseInt(positions[0]);
        y=Integer.parseInt(positions[1]);
        map[y][x]="C";
        int time=Integer.parseInt(details[2].substring(0,(details[2]).length()-1));
        //System.out.println("LIFE PACK X  ="+  y+" Y =" +x+" time "+ time);
        System.out.println("COIN PILES X  ="+  y+" Y =" +x);
    }
    
}
