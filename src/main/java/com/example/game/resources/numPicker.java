package com.example.game.resources;
import java.lang.Math;
import java.util.TreeSet;
import java.util.Collections;
import java.util.Scanner;

public class numPicker {
    private int correctCode;
    private TreeSet<Integer> tries=new TreeSet<Integer>();
    private int points;
    public numPicker(){
        this.correctCode=(int)(Math.random()*10);
        this.points=5;
        
    }
    public String start(){
        return "Okay... the game is going to start\nYou have 5 point, each attempt cost one point, good luck";

    }
    public String newAttempt(int n){
        
       
        
        // reader.close();
        this.tries.add(n);
        if  (n!=this.correctCode){
            if(points!=0){
                points-=1;
            }
            return "Ouch! not correct\n:sad:\n\n\nYou have "+Integer.toString(points)+" points left";
        
        }
        else{
            
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
        return result;
    }

    // похуй
    
}

