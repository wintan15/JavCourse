import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
	public static void main(String[] args) {
		System.out.println("Welcome to RockPaperScissors!");
		String cont = "Yes";
		String temp;
		int y; 
		int[] score = new int[3]; //Tie loss win
		Scanner inp = new Scanner(System.in);
		String[] choice = {"Rock","Paper","Scissors"};
		int userC;
		Random rand = new Random();
		do {
			//Num Rounds
			System.out.println("How many rounds would you like to play? (1-10)");
			temp = inp.nextLine();
			//Sanitization
			try {
				y = Integer.parseInt(temp);				
				if (y<1 || y>10) {
					System.err.println("Not in range!");
					return;	
					
				}
			} catch(Exception e) {
				System.err.println("Not an integer!");
				return;				
			}
			
			int compChoice;
			//Main Game
			for(int i = 0; i<y;i++) {
				System.out.println("Choose a number: (0) Rock, (1) Paper, (2) Scissors");
				temp = inp.nextLine();
				try {
					userC = Integer.parseInt(temp) - 1;
					if (userC>2||userC<0) {
						System.err.println("Not valid input!");
						return;	
					}
				}catch(Exception e) {
					System.err.println("Not valid input!");
					return;	
				}
				compChoice = rand.nextInt(3)+1 - 1;
				System.out.println("Computer chose " + choice[compChoice]);		
				//Result
				switch(compChoice - userC){
					case 0:
						System.out.println("It was a tie!");
						score[0] += 1;
						break;
					case 1:
					case -2:
						System.out.println("You lost!");
						score[1] += 1;
						break;
					default:
						System.out.println("You Won!");
						score[2] += 1;
						break;					
					}
				}
			System.out.println("In this game, you had "+ score[0] +" ties, " + score[1] + " losses " +
				score[2] + " wins.");
			if (score[1]>score[2]) {
				System.out.println("The computer is the overall winner");
			} else if (score[1]==score[2]) {
				System.out.println("It was a tie overall!");
			} else {
				System.out.println("You are the overall winner!");				
			}
			do{
				System.out.println("Would you like to play again? (No or Yes)");			
				cont = inp.nextLine();
			}while(!(cont.equals("No") || cont.equals("Yes")));
		}while(cont.equals("Yes"));
		System.out.println("Thanks for playing!");
		inp.close();
	}

}
