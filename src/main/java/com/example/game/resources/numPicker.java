package com.example.game.resources;
import java.lang.Math;
import java.util.TreeSet;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class numPicker {
    private int correctCode;
    private TreeSet<Integer> tries=new TreeSet<Integer>();
    private int points;
    private String name;
    private boolean isFinished=false;
    public numPicker(String name){
        this.name=name;
        this.correctCode=(int)(Math.random()*10);
        this.points=5;
        
    }
    public String start(){
        try {
            File Obj = new File("myfile.txt");
            if (!Obj.exists()){
                Obj.createNewFile();
            }
            
        }catch(IOException e){
            return "The game started but the statistics file couldn't be created. \nConsider informing t1triv00@students.oamk.fi about that";
        }
        return "Okay... the game is going to start\nYou have 5 point, each attempt cost one point, good luck";

    }
    public String newAttempt(int n){
        if(isFinished){
            return "Good attempt, but you can't play after you win\nI congrat you and all that stuff but please POST /start?name=YourName to start new game and win again";
        }
       
        
        // reader.close();
        this.tries.add(n);
        if  (n!=this.correctCode){
            if(points!=0){
                points-=1;
            }
            return "Ouch! not correct\n:sad:\n\n\nYou have "+Integer.toString(points)+" points left";
        
        }
        else{
            this.isFinished=true;
            try{
                File Obj = new File("statistics.txt");
                FileWriter fr = new FileWriter(Obj, true);
                fr.write("player "+this.name+" got "+this.points+" points\n");
                fr.close();
                
            }
            catch(IOException e){
                return "You won but program failed to write statistics to file.";
            }
            return "You win!\n\nYou got "+Integer.toString(points)+" points";
        }
    }

    public String getHints(){
        String result="";
        if (this.tries.size()==0){
            return "You haven't put any number! pls consider doing that\nTo enter number put /attempt?n=YourNumber where YourNumber is the number that you pick";
        }
        if(Collections.max(this.tries)>this.correctCode){
            result+="Higher than target:";
            for (Integer num:tries){
                if (num>this.correctCode){
                    result+="\n"+Integer.toString(num);
                }
            }
            result+="\n";
        }
        if(Collections.min(this.tries)<this.correctCode){
            result+="Lower than target:";
            for (Integer num:tries){
                if (num<this.correctCode){
                    result+="\n"+Integer.toString(num);
                }
            }
            
        }
        if(isFinished){
            result+="\nYou already finished game, bro";
        }
        return result;
    }
    public String getStats(){
        
        String stats="";
        try{
            File Obj=new File("statistics.txt");
        Scanner reader=new Scanner(Obj);
        while (reader.hasNextLine()){
            stats+=reader.nextLine()+"\n";
        }
        reader.close();
        }catch(FileNotFoundException e){
            return "File was not found, no statistics can be given";
        }
        return stats;
    }

    // похуй
    
}

