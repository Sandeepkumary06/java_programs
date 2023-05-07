import java.util.*;

class TicTacToe{
    static char[][] board;
    
    public TicTacToe(){
        board = new char[3][3];
        initBoard();
    }
    
    void initBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j] = ' ';
            }
        }
    }
    
    static void displayBoard(){
        
        System.out.println("-------------");
        for(int i=0;i<board.length;i++){
            System.out.print("| ");
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    
    static void placeMark(int row,int col,char mark){
        if(row>=0 && row<3 && col>=0 && col<3){
            board[row][col] = mark;
        }
        else{
            System.out.println("Invalid Position");
        }
    }
    
    static boolean checkColWin(){
        for(int j=0;j<3;j++){
            if(board[0][j]!=' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]){
                return true;
            }
        }
        return false;
    }
    
    static boolean checkRowWin(){
        for(int i=0;i<3;i++){
            if(board[i][0]!=' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                return true;
            }
        }
        return false;
    }
    
    static boolean checkDiagWin(){
            if(board[0][0]!=' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] || board[0][2]!=' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]){
                return true;
            }
            return false;
    }
    
    static boolean checkisDraw(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }   
}

abstract class Player{
    String name;
    char mark;
    
    abstract void makeMove();
    
    boolean isValid(int row,int col){
        if(row>=0 && row<3 && col>=0 && col<3){
            if(TicTacToe.board[row][col]==' '){
                return true;
            }
        }
        return false;
    }
    
}

class HumanPlayer extends Player{
    
    HumanPlayer(String name,char mark){
        this.name = name;
        this.mark = mark;
    }
    
    void makeMove(){
        Scanner sc = new Scanner(System.in);
        int row;
        int col;
        do{
            System.out.println("Enter the row and col");
            row = sc.nextInt();
            col = sc.nextInt();
        }
        while(!isValid(row,col));
        
        TicTacToe.placeMark(row,col,mark);        
    }
}

class aiPlayer extends Player{
    
    aiPlayer(String name,char mark){
        this.name = name;
        this.mark = mark;
    }
    
    void makeMove(){
        Scanner sc = new Scanner(System.in);
        int row;
        int col;
        do{
            Random r = new Random();
            row = r.nextInt(3);
            col = r.nextInt(3);
        }
        while(!isValid(row,col));
        
        TicTacToe.placeMark(row,col,mark);        
    }
    
}

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter 1 for One Player or 2 for Two Players");
	    int game = sc.nextInt();
	    
	    TicTacToe t = new TicTacToe();
	    
	    if(game==1){
	        System.out.println("Enter the your name :");
	        String s1 = sc.next();
	        HumanPlayer p1 = new HumanPlayer(s1,'X');
            aiPlayer p2 = new aiPlayer("Computer",'O');
            Player cp;
            cp = p1;
            while(true){
                System.out.println(cp.name+" your turn");
                cp.makeMove();
                t.displayBoard();
                if(t.checkColWin() || t.checkRowWin() || t.checkDiagWin()){
                    System.out.println(cp.name+" You Win");
                    break;
                }
                else if(t.checkisDraw()){
                    System.out.println("Game Draw");
                    break;
                }
                else{
                    if(cp==p1){
                        cp=p2;
                    }
                    else{
                        cp=p1;
                    }
                }
            }
	        
	    }
	    
	    else if(game==2){
	        System.out.println("Enter the player1 name :");
	        String s1 = sc.next();
	        System.out.println("Enter the player2 name :");
	        String s2 = sc.next();
	        HumanPlayer p1 = new HumanPlayer(s1,'X');
            HumanPlayer p2 = new HumanPlayer(s2,'O');
            Player cp;
            cp = p1;
            while(true){
                System.out.println(cp.name+" your turn");
                cp.makeMove();
                t.displayBoard();
                if(t.checkColWin() || t.checkRowWin() || t.checkDiagWin()){
                    System.out.println(cp.name+ " You Win");
                    break;
                }
                else if(t.checkisDraw()){
                    System.out.println("Game Draw");
                    break;
                }
                else{
                    if(cp==p1){
                        cp=p2;
                    }
                    else{
                        cp=p1;
                    }
                }
            }
	    }
	}
	
}
