// Date made 23/11/2019
// Developed By Arjun Varma (Aka CompDaddy)

// The main logic behind this is that in the while loop the couunter "c" indicates the players 
// turn. As the loop iterates the value of c is changing the change in the value is utilised. 
// When the value of c is an even number player2 has to play because in a game of tic tac toe
// the second player is always O and player 1 plays when the value of c is odd

// The value of the array "Base[i]" is taken as X when player 1 plays and O When player 2
// plays

import java.util.Scanner;

class TicTac{
    
    //Global Variables
    static String base[] = {".", ".", ".", ".", ".", ".", ".", ".", "."};
    static boolean f = false;
    static int pos;
    static Scanner SC = new Scanner(System.in);
    static String player1, player2, choice;
    
    //Setting up the board
    void display(){
        System.out.println("\t " + base[0] + " | " + base[1] + " | " + base[2]);
        System.out.println("\t---|---|---");
        System.out.println("\t " + base[3] + " | " + base[4] + " | " + base[5]);
        System.out.println("\t---|---|---");
        System.out.println("\t " + base[6] + " | " + base[7] + " | " + base[8]);
    }

    //To check if a player has won
    boolean gameOver(){
        boolean f = false;
        if(win_diag() == true || win_rows() == true || win_cols() == true)
            f = true;
        return f;
    }

    //To check if a player has won diagnolly
    boolean win_diag(){
        boolean f = false;
        if((base[0] == "X" && base[4] == "X" && base[8] == "X") || (base[0] == "O" && base[4] == "O" && base[8] == "O"))
            f = true;
        else if((base[2] == "X" && base[4] == "X" && base[6] == "X") || (base[2] == "O" && base[4] == "O" && base[6] == "O"))
            f = true;
        return f;
    }

    //To check if a player has won by rows
    boolean win_rows(){
        boolean f = false; 
        if((base[0] == "X" && base[1] == "X" && base[2] == "X") || (base[0] == "O" && base[1] == "O" && base[2] == "O"))
            f = true;
        else if((base[3] == "X" && base[4] == "X" && base[5] == "X") || (base[3] == "O" && base[4] == "O" && base[5] == "O"))
            f = true;
        else if((base[6] == "X" && base[7] == "X" && base[8] == "X") || (base[6] == "O" && base[7] == "O" && base[8] == "O"))
            f = true;
        return f;
    }

    //To check if a player has won by columns
    boolean win_cols(){
        boolean f = false; 
        if((base[0] == "X" && base[3] == "X" && base[6] == "X") || (base[0] == "O" && base[3] == "O" && base[6] == "O"))
            f = true;
        else if((base[1] == "X" && base[4] == "X" && base[7] == "X") || (base[1] == "O" && base[4] == "O" && base[7] == "O"))
            f = true;
        else if((base[2] == "X" && base[5] == "X" && base[8] == "X") || (base[2] == "O" && base[5] == "O" && base[8] == "O"))
            f = true;
        return f;
    }

    void StartGame(){
        Scanner SC = new Scanner(System.in);
        int c = 1;

        System.out.println("\t Enter player 1's name");
        System.out.print("\t "); 
        player1 = SC.next();
        System.out.println("\t Enter player 2's name");
        System.out.print("\t "); 
        player2 = SC.next();

        //Taking inputs from the players
        while(c <= 9){
            System.out.println("");
            display();
            if(c%2==0){
                System.out.println("---------------------------------------------------------");
                System.out.println("\t " + player2 + "'s chance");
                System.out.println("\t Enter the position u want to play");
                System.out.print("\t ");pos = SC.nextInt();
                if(pos == 1)
                    base[0] = "O"; //assigning X to array base
                else if(pos > 1)
                    base[Math.abs(pos - 1)] = "O";
                
            }

            else{
                System.out.println("---------------------------------------------------------");
                System.out.println("\t " + player1 + "'s chance");
                System.out.println("\t Enter the position u want to play");
                System.out.print("\t ");pos = SC.nextInt();
                if(pos == 1)
                    base[0] = "X"; //assigning X to array base
                else if(pos > 1)
                    base[Math.abs(pos - 1)] = "X";
            }   
            
            if(gameOver() == true){
                if(c%2==0)
                    System.out.println("\t " + player2 + " has defeated " + player1);
                else 
                    System.out.println("\t " + player1 + " has defeated " + player2);
                break;
            }
            if(c == 9)
                System.out.println("\t Its a draw :(");
            c++;
        }
        System.out.println("");
        display();
    }

    public static void main(String args[]){
        Scanner SC = new Scanner(System.in);
        TicTac TT = new TicTac();
        int c = 1;

        System.out.println("--------------------------------------------------------------");
        System.out.println("");
        System.out.println("\t Welcome to a game of Tic Tac Toe!!");
        System.out.println("\t Developed By Arjun Varma");
        System.out.println("");
        System.out.println("--------------------------------------------------------------");
        System.out.println("");
        System.out.println("\t Lets start now, shall we??");

        TT.StartGame();
    }
}