import java.util.Scanner;

class Main {
  static boolean winner = false;
  static char winningP = '.';
  public static void main(String[] args) {
    char[][] gameBoard = new char[6][7];
    for(int i = 0; i < gameBoard.length; i++){
        for(int j = 0; j < gameBoard[0].length; j++){
        gameBoard[i][j] = '.';
       }
     }
     for(int i = 0; i < gameBoard.length; i++){
        for(int j = 0; j < gameBoard[0].length; j++){
        System.out.print("[" + gameBoard[i][j] + "]");
      }
       System.out.println();
      }
    System.out.println("Here is the current board.");

    System.out.println(" \n \n Player 1 is yellow and will be represented with Y. \n Player 2 is red and will be represented with R. Blank spaces are periods. \n Say yes if you understand and would like to start.");
    String start = getString();

    if (!start.equals("yes")){
      System.out.println("Goodbye!"); return;
    }
    
    while(winner == false){
      for(int m = 0; m < 21; m++){
        System.out.println("Yellow: What column would you like to drop your token in? Expected Reply: Integer 0-6.");
        int movey = getCol();

        for(int i = 5; i >= 0; i--){
          if(gameBoard[i][movey] == '.'){
            gameBoard[i][movey] = 'Y';
            i = -1;
          }
        }

        for(int i = 0; i < gameBoard.length; i++){
          for(int j = 0; j < gameBoard[0].length; j++){
            System.out.print("[" + gameBoard[i][j] + "]");
          }
          System.out.println();
        }
        //Horizontal wincheck
        for(int w = 0; w < gameBoard.length; w++){
          for(int q = 0; q < 4; q++){
            if(gameBoard[w][q] == 'Y' && gameBoard[w][q+1] == 'Y' && gameBoard[w][q+2] == 'Y' && gameBoard[w][q+3] == 'Y'){
              winner = true;
              winningP = 'Y';
            }
          }
        }

        //Vertical wincheck
        for(int e = 0; e < gameBoard.length; e++){
          for(int c = 0; c < 3; c++){
            if(gameBoard[c][e] == 'Y' && gameBoard[c+1][e] == 'Y' && gameBoard[c+2][e] == 'Y' && gameBoard[c+3][e] == 'Y'){
              winner = true;
              winningP = 'Y';
            }
          }
        }

        //Diagonal Wincheck
        for(int b = 0; b < 3; b++){
          for(int v = 0; v < 4; v++){
            if(gameBoard[b][v] == 'Y' && gameBoard[b+1][v+1] == 'Y' && gameBoard[b+2][v+2] == 'Y' && gameBoard[b+3][v+3] == 'Y'){
              winner = true;
              winningP = 'Y';
            }
          }
        }
        for(int n = 5; n > 2; n--){
          for(int q = 0; q < 4; q++){
            if(gameBoard[n][q] == 'Y' && gameBoard[n-1][q+1] == 'Y' && gameBoard[n-2][q+2] == 'Y' && gameBoard[n-3][q+3] == 'Y'){
              winner = true;
              winningP = 'Y';
          }
        }
        }

         if(winner == true){
           break;
         }

        System.out.println("Red: What column would you like to drop your token in? Expected Reply: Integer 0-6.");
        int mover = getCol();

        for(int i = 5; i >= 0; i--){
          if(gameBoard[i][mover] == '.'){
            gameBoard[i][mover] = 'R';
            i = -1;
          }
        }

        for(int i = 0; i < gameBoard.length; i++){
          for(int j = 0; j < gameBoard[0].length; j++){
            System.out.print("[" + gameBoard[i][j] + "]");
          }
          System.out.println();
        }
        //Horizontal wincheck
        for(int z = 0; z < gameBoard.length; z++){
          for(int x = 0; x < 4; x++){
            if(gameBoard[z][x] == 'R' && gameBoard[z][x+1] == 'R' && gameBoard[z][x+2] == 'R' && gameBoard[z][x+3] == 'R'){
              winner = true;
              winningP = 'R';
            }
          }
        }
        //Vertical wincheck
        for(int e = 0; e < gameBoard.length; e++){
          for(int c = 0; c < 3; c++){
            if(gameBoard[c][e] == 'R' && gameBoard[c+1][e] == 'R' && gameBoard[c+2][e] == 'R' && gameBoard[c+3][e] == 'R'){
              winner = true;
              winningP = 'R';
            }
          }
        }
        //Diagonal Wincheck
        for(int r = 0; r < 3; r++){
          for(int t = 0; t < 4; t++){
            if(gameBoard[r][t] == 'R' && gameBoard[r+1][t+1] == 'R' && gameBoard[r+2][t+2] == 'R' && gameBoard[r+3][t+3] == 'R'){
              winner = true;
              winningP = 'R';
            }
          }
        }
        for(int y = 5; y > 2; y--){
          for(int u = 0; u < 4; u++){
            if(gameBoard[y][u] == 'R' && gameBoard[y-1][u+1] == 'R' && gameBoard[y-2][u+2] == 'R' && gameBoard[y-3][u+3] == 'R'){
              winner = true;
              winningP = 'R';
            }
          }
        }
        

        if(winner == true){
           break;
        }
      }
      if(winner != true){
        System.out.println("It was a draw!");
        return;
      } else if(winningP == 'Y'){
        System.out.println("Yellow wins!!");
      } else{
        System.out.println("Red wins!!");
      }
    
    }
  }
  

  public static int getCol(){
    Scanner keyboard = new Scanner(System.in);
    return keyboard.nextInt();
  }

  public static String getString(){
    Scanner keyboard = new Scanner(System.in);
    return keyboard.nextLine();
  }
}

