import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
   Reed I Messner
   CS-205
   Warm Up Project (Mastermind Game)
   Computer Mode Edition
   This program is a game where the player creates a sequence of
   4 colors and the computer attempts to guess the user's sequence.
*/

//Number of turns to guess? CHANGE?*****
//Amount of COMPUTER AI? *** position and/or color correct

//2, 3 for computer victory or computer loss

//add Statistic object parameter
//add file exception handling

public class Compmode{
   
   //constants
      
      //CREATE FLAGS TO REPRESENT CORRECT ANSWERS ALSO PRINT
      //OUT MESSAGES TO USER WHEN FLAGS ARE SWITCHED. USE
      //THE FLAGS TO NARROW CPU'S SEARCH// LOCK IN CORRECT VALUES FROM RANDOM.
      
      static int numColors = 6;
      static int flagCount = 0;
      static int temp, index, turnCount, posFlagCount;
      static int rflagcount, bflagcount, gflagcount, yflagcount, pflagcount, oflagcount;
      static boolean pos1,pos2,pos3,pos4,rflag,bflag,yflag,gflag,pflag,oflag;
      static boolean cont = true;
      static boolean win = false;
      static char lock1, lock2, lock3, lock4;
      static char code[] = new char[4];
      static char guess[] = new char[4];
      static char lastguess[] = new char[4];
      
      static char peg1,peg2,peg3,peg4,ch; //either 'r/R', 'B/b', 'G/g', 'Y/y', 'P/p', 'O/o'
      
      //init rand and scan
      static Random rand = new Random();
      static Scanner reader = new Scanner(System.in);
      
      
      
   /**
      The checkPeg method checks if the user input is one of
      the predetermined R B Y G P O colors, specifically if the
      user input matches.
      @param c The input char to be checked. 
   */
   public static boolean checkPeg(char c){
      if (c != 'R' && c !='Y' && c !='O' && c !='G' && c !='B' && c !='P'){
         return false;
      }
      else
         return true;
 
   }
   
   /**
      The convertToChar method takes a number (probably randomly
      generated) and returns the color equivalent of the number for
      char array storing.
      @param n the number to convert to corresponding "color char"
   */
   public static char convertToChar(int n){
      if (n == 1)
         return 'R';
      else if (n == 2)
         return 'Y';
      else if (n == 3)
         return 'B';
      else if (n == 4)
         return 'G';
      else if (n == 5)
         return 'O';
      else
         return 'P';
   }
   
   /**
      The comparePegs method takes two character arrays as parameters
      and alters variables according to the result of the comparison. 
      displays correct position or correct color in wrong position, etc.
      @param code[] A character array representing the key (correct combination)
      @param guess[] A character array representing the guess.
   */
   public static void comparePegs(char code[], char guess[]){
      for (int i = 0; i < guess.length; i++){
         if (guess[i] == code[i]){
            
            System.out.println("Correct color in position "+ (i+1));
            //position flag update for computer AI
            if (guess[0] == code[0])
               pos1 = true;
               posFlagCount++;
            if (guess[1] == code[1])
               pos2 = true;
               posFlagCount++;
            if (guess[2] == code[2])
               pos3 = true;
               posFlagCount++;
            if (guess[3] == code[3])
               pos4 = true;
               posFlagCount++;
            //set a position flag here for future guesses
         }
         else if(guess[i] == code[0] || guess[i] == code[1] || guess[i] == code[2] || guess[i] == code[3]){
            System.out.println("Correct color "+ guess[i] +" in INCORRECT position "+ (i+1));
            //**possibly set color flags here for future guesses
            if (guess[i] == 'R'){
               if (((i == 0) && (pos1 == false)) || ((i == 1) && (pos2 == false)) || ((i == 2) && (pos3 == false)) || ((i == 3) && (pos4 == false)))
                  rflag = true;
                  rflagcount++;
            }
            else if (guess[i] == 'B')
            {
               if (((i == 0) && (pos1 == false)) || ((i == 1) && (pos2 == false)) || ((i == 2) && (pos3 == false)) || ((i == 3) && (pos4 == false)))
                  bflag = true;
                  bflagcount++;
            }
            else if (guess[i] == 'G')
            {
               if (((i == 0) && (pos1 == false)) || ((i == 1) && (pos2 == false)) || ((i == 2) && (pos3 == false)) || ((i == 3) && (pos4 == false)))
                  gflag = true;
                  gflagcount++;
            }
            else if (guess[i] == 'Y'){
               if (((i == 0) && (pos1 == false)) || ((i == 1) && (pos2 == false)) || ((i == 2) && (pos3 == false)) || ((i == 3) && (pos4 == false)))
                  yflag = true;
                  yflagcount++;
            }
            else if (guess[i] == 'O'){
               if (((i == 0) && (pos1 == false)) || ((i == 1) && (pos2 == false)) || ((i == 2) && (pos3 == false)) || ((i == 3) && (pos4 == false)))
                  oflag = true;
                  oflagcount++;
            }
            else if (guess[i] == 'P'){
               if (((i == 0) && (pos1 == false)) || ((i == 1) && (pos2 == false)) || ((i == 2) && (pos3 == false)) || ((i == 3) && (pos4 == false)))
                  pflag = true;
                  pflagcount++;
            }
               
         }
         if (Arrays.equals(code, guess))
         {
            win = true;
            break;
         }
      }

   }
   
   /**
     The genGuess function returns a character array filled with randomly generated
     color "pegs" aka characters that represent colors. The boolean flags from main()
     are utilized to help guide the computer's guesses if a position is correct.
     @return guess the guess generated.
   */
   public static void genGuess()
   {
      //checks for success flags, if we have one then the value is kept.
      if (pos1 == false){
         if ((rflag == true) && (rflagcount <= 1) && (posFlagCount < 3) && (lastguess[0] != 'R'))
            guess[0]='R';
         else if ((bflag == true) && (bflagcount <= 1) && (posFlagCount < 3) && (lastguess[0] != 'B'))
            guess[0]='B';
         else if ((gflag == true) && (gflagcount <= 1) && (posFlagCount < 3) && (lastguess[0] != 'G'))
            guess[0]='G';
         else if ((yflag == true) && (yflagcount <= 1) && (posFlagCount < 3) && (lastguess[0] != 'Y'))
            guess[0]='Y';
         else if ((oflag == true) && (oflagcount <= 1) && (posFlagCount < 3) && (lastguess[0] != 'O'))
            guess[0]='O';
         else if ((pflag == true) && (pflagcount <= 1) && (posFlagCount < 3) && (lastguess[0] != 'P'))
            guess[0]='P';
         else
            guess[0]= convertToChar((rand.nextInt(6)+1));
         
      }
      if (pos2 == false){
         if ((rflag == true) && (rflagcount <= 1) && (posFlagCount < 3) && (lastguess[1] != 'R'))
            guess[1]='R';
         else if ((bflag == true) && (bflagcount <= 1) && (posFlagCount < 3) && (lastguess[1] != 'B'))
            guess[1]='B';
         else if ((gflag == true) && (gflagcount <= 1) && (posFlagCount < 3) && (lastguess[1] != 'G'))
            guess[1]='G';
         else if ((yflag == true) && (yflagcount <= 1) && (posFlagCount < 3) && (lastguess[1] != 'Y'))
            guess[1]='Y';
         else if ((oflag == true) && (oflagcount <= 1) && (posFlagCount < 3) && (lastguess[1] != 'O'))
            guess[1]='O';
         else if ((pflag == true) && (pflagcount <= 1) && (posFlagCount < 3) && (lastguess[1] != 'P'))
            guess[1]='P';
         else
            guess[1]= convertToChar((rand.nextInt(6)+1));
         
      }
      if (pos3 == false){
         if ((rflag == true) && (rflagcount <= 1) && (posFlagCount < 3) && (lastguess[2] != 'G'))
            guess[2]='R';
         else if ((bflag == true) && (bflagcount <= 1) && (posFlagCount < 3) && (lastguess[2] != 'B'))
            guess[2]='B';
         else if ((gflag == true) && (gflagcount <= 1) && (posFlagCount < 3) && (lastguess[2] != 'G'))
            guess[2]='G';
         else if ((yflag == true) && (yflagcount <= 1) && (posFlagCount < 3) && (lastguess[2] != 'Y'))
            guess[2]='Y';
         else if ((oflag == true) && (oflagcount <= 1) && (posFlagCount < 3) && (lastguess[2] != 'O'))
            guess[2]='O';
         else if ((pflag == true) && (pflagcount <= 1) && (posFlagCount < 3) && (lastguess[2] != 'P'))
            guess[2]='P';
         else
            guess[2]= convertToChar((rand.nextInt(6)+1));
         
      }
   
      if (pos3 == false){
         if ((rflag == true) && (rflagcount <= 1) && (posFlagCount < 3) && (lastguess[3] != 'R'))
            guess[3]='R';
         else if ((bflag == true) && (bflagcount <= 1) && (posFlagCount < 3) && (lastguess[3] != 'B'))
            guess[3]='B';
         else if ((gflag == true) && (gflagcount <= 1) && (posFlagCount < 3) && (lastguess[3] != 'G'))
            guess[3]='G';
         else if ((yflag == true) && (yflagcount <= 1) && (posFlagCount < 3) && (lastguess[3] != 'Y'))
            guess[3]='Y';
         else if ((oflag == true) && (oflagcount <= 1) && (posFlagCount < 3) && (lastguess[3] != 'O'))
            guess[3]='O';
         else if ((pflag == true) && (pflagcount <= 1) && (posFlagCount < 3) && (lastguess[3] != 'P'))
            guess[3]='P';
         else
            guess[3]= convertToChar((rand.nextInt(6)+1));
         
      }
   }
   
   public static void main(String [] args){

      //print initial info
      System.out.println("R = Red, G = Green, Y = Yellow, B = Blue, O = Orange, P = Purple."); 
      
      //get peg1 from user
      System.out.println("Enter the 1st character of the 4-color sequence:");
      peg1 = reader.next().trim().charAt(0);
      while (checkPeg(peg1) == false){
         System.out.println("Invalid input.");
         System.out.println("Enter the 1st character of the 4-color sequence:");
         peg1 = reader.next().trim().charAt(0);
      }
      
      //get peg2 from user
      System.out.println("Enter the 2nd character of the 4-color sequence:");
      peg2 = reader.next().trim().charAt(0);
      while (checkPeg(peg2) == false){
         System.out.println("Invalid input.");
         System.out.println("Enter the 2nd character of the 4-color sequence:");
         peg2 = reader.next().trim().charAt(0);
      }
      
      //get peg3 from user
      System.out.println("Enter the 3rd character of the 4-color sequence:");
      peg3 = reader.next().trim().charAt(0);
      while (checkPeg(peg3) == false){
         System.out.println("Invalid input.");
         System.out.println("Enter the 3rd character of the 4-color sequence:");
         peg3 = reader.next().trim().charAt(0);  
      }
      
      //get peg4 from user
      System.out.println("Enter the last character of the 4-color sequence:");
      peg4 = reader.next().trim().charAt(0);
      while (checkPeg(peg4) == false){
         System.out.println("Invalid input.");
         System.out.println("Enter the last character of the 4-color sequence:");
         peg4 = reader.next().trim().charAt(0);

      }
      
      //put pegs into array
      code[0] = peg1;
      code[1] = peg2;
      code[2] = peg3;
      code[3] = peg4;
      System.out.println("Valid sequence entered.");
      
      //** remember to store previous computer guesses in arrays
      //and compare new guesses to old ones via Arrays.equals(arr1, arr2)
      
      //PLAY GAME UNTIL 8 TURNS, VICTORY, OR DISCONTINUE.
      while ((win == false) && (turnCount < 8) && (cont == true)){
         
         //Each iteration of loop represents ONE TURN. 
         System.out.println("------------------------NEW TURN------------------------");
         lastguess = Arrays.copyOf(guess, guess.length);
         //
         //
         System.out.println(lastguess);
         System.out.println(lastguess[3]);
         System.out.println(guess[3]);
         
         //
         //
         genGuess();
         
         //reset color flags after generated guess.
         rflag = false;
         yflag = false;
         gflag = false;
         pflag = false;
         oflag = false;
         bflag = false;
         flagCount = 0;
         posFlagCount = 0;
         
         System.out.println("User code: "+code[0]+' '+code[1]+' '+code[2]+' '+code[3]);
         System.out.println("Computer guess: "+guess[0]+' '+guess[1]+' '+guess[2]+' '+guess[3]);
         comparePegs(code,guess);
         
         //Confirm continuation of game
         System.out.println("Continue? Enter y/n:");
         ch = reader.next().charAt(0);
         //check validity of input
         while ((ch != 'y') && (ch !='Y') && (ch !='N') && (ch != 'n')){
            System.out.println("Invalid input. Enter y/n:");
            ch = reader.next().charAt(0);
         }
         if((ch == 'n') || (ch == 'N'))
            cont = false;
         
         
         turnCount++;
      }
      
      if (win == true)
         System.out.println("The computer has correctly guessed your code!");
      else
         System.out.println("The computer could not guess your code!");
         
      System.out.println("It took "+turnCount+" turns. Good game!");

   }
   
}