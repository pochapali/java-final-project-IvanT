import java.lang.Math;
import java.util.TreeSet;
import java.util.Collections;
import java.util.Scanner;

public class numPicker {
    private int correctCode;
    private TreeSet<Integer> tries=new TreeSet<Integer>();
    
    public numPicker(){
        this.correctCode=(int)(Math.random()*10);
        
    }
    public void start(){
        System.out.println("Okay... the game is going to start");
        newAttempt();
    }
    public void newAttempt(){
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number: ");
        
        int n= reader.nextInt();
        // reader.close();
        this.tries.add(n);
        if  (n!=this.correctCode){
            System.out.println("Ouch! not correct\n:sad:\n\n\n");
            printUI();
        }
        else{System.out.println("You win!");}
    }
    public void printUI(){
        System.out.println("You can do that!\nYou still have infinite tries.");
        printHints();
    }
    public void printHints(){
        if(Collections.max(this.tries)>this.correctCode){
            System.out.println("Higher than target:");
            for (Integer num:tries){
                if (num>correctCode){
                    System.out.println(num);
                }
            }
        }
        if(Collections.min(this.tries)<this.correctCode){
            System.out.println("Lower than target:");
            for (Integer num:tries){
                if (num < correctCode){
                    System.out.println(num);
                }
            }
        }
        newAttempt();
    }

    // похуй
    
}

