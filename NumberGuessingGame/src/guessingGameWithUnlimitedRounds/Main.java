package guessingGameWithUnlimitedRounds;

import java.util.Scanner;

public class Main {
	public static void guessingNumberGame() {
		Scanner sc = new Scanner(System.in);
		
		int numb= 1; 
		int K= 5;
		int randomNumb= (int)(Math.random() * 100); 
		boolean guessedCorrectly  = false;
		
		int attempts = 0; 
		
		
		System.out.println("A number is chosen between 1 and 100.");
		System.out.println("You have " + K + "attemps per a round to guess correct number");
		
		 
		while(!guessedCorrectly) {
			
			for (int i = 0; i < K; i++) {
				System.out.println("Enter your guess:");
				int guess = sc.nextInt();
				attempts++;
				
				if (guess == randomNumb) {  
					System.out.println ( "Congratulations! You guessed the correct number in "
	                        + attempts + " attempts.");
					guessedCorrectly = true;
				
					sc.close();
					break;
				} else if(guess < randomNumb) {
					System.out.println("The number is greater than " + guess);
				} else { 
					System.out.println("The number is less than " + guess);
				} 			
				numb++;
			}
			
			 if (!guessedCorrectly) {
	                
	                System.out.println("You have used all " + K
	                                   + " attempts.");
	                System.out.print(
	                    "Do you want to continue guessing? (yes/no): ");
	                String response = sc.next();

	                if (!response.equalsIgnoreCase("yes")) {
	                    System.out.println(
	                        "Game Over! The correct number was: "
	                        + randomNumb);
	                    break;
	                }
	            }
		}
		System.out.println("You are exhausted all attemps. the correct number was " + randomNumb);
		sc.close();
		
	}
	public static void main(String[] args) { 
		guessingNumberGame();
	}
}
