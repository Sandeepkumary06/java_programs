import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int actualNumber = (int)(Math.random()*100)+1;
        System.out.println("Welcome to the guess Number game");
        System.out.println();
        int attempts = 5;
        
        while(attempts-->0){
            System.out.println("Number of attempts : "+ attempts);
            System.out.println("Enter the Guessing Number between 1 to 100: ");
            
            int guessNumber = sc.nextInt();
            
            if(guessNumber>0 && guessNumber<=100){
                if(guessNumber==actualNumber){
                    System.out.println("You won this Game");
                    break;
                }
            
                else if(guessNumber<actualNumber){
                    System.out.println("Too Low");
                }
                
                else if(guessNumber>actualNumber){
                    System.out.println("Too High");
                }
            }
            
            else{
                System.out.println("Hey! You the Number only between 1 to 100 and Try again");
            }
            
            if(attempts==1){
                System.out.println("Hey! If you want any HINT: Enter the 'Y' or 'y' else Enter the 'N' or 'n' ");
                char ch = sc.next().charAt(0);
                
                if(ch=='Y' || ch=='y'){
                    int dulipcateNumber = actualNumber;
                    int ans = 0;
                    
                    while(dulipcateNumber>0){
                        int j = dulipcateNumber%10;
                        ans = ans+j;
                        dulipcateNumber/=10;
                    }
                    
                    System.out.println(ans);
                }
                
                else if(ch=='n' || ch=='N'){
                    System.out.println("Good Luck!");
                }
            }
            
            if(attempts==0){
                System.out.println("You Lose this Game");
                System.out.println("The Random Number is "+actualNumber);
            }
        }
    }
}
