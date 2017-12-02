/** Program: Guessing Game
* File: GuessingGame.java
* Summary: Program creates a random number to be guessed. 
* The user is prompted to guess the number. 
* Program gives user feedback on guesses. 
* Once the number is guessed the program prints the number of guesses to the screen.
* Author: Jason E. Borum
* Date: December 2, 2017
**/

import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		// Set random number range
		int lowerLimit = 1;
		int upperLimit = 10000;
		int index = 1;
		
		// Generate a random number
		int randomNumber = lowerLimit + (int)(Math.random() * ((upperLimit - lowerLimit) + 1));
		
		// Print the random number for testing purposes
		//System.out.println("******* For testing purposes the random number is <" + randomNumber + "> *******");
		
		// Initilize scanner, prompt user for a guess and get user input.
		Scanner userInput = new Scanner(System.in);
		System.out.print("Guess a number between :" + lowerLimit + " and " + upperLimit + " : ");
		int userNumber = userInput.nextInt();
		
		// Check user input to ensure it is within the range
		while ((userNumber < lowerLimit) || (userNumber > upperLimit)){
			System.out.println("[" + userNumber + "] is outside of the range :");
			System.out.print("Guess a number between :" + lowerLimit + " and " + upperLimit + " : ");
			userNumber = userInput.nextInt();
		}
		
		// Test random number and user input for equality
		while ((randomNumber != userNumber) && (lowerLimit != upperLimit)) {
			
			// Display feedback if the user guess was too high
			if (randomNumber < userNumber) {
				// Set new upper limit
				upperLimit = userNumber - 1;
				System.out.println("LOWER :");
				// Display feedback if the user input was too low
			} else if (randomNumber > userNumber) {
				// Set new lower limit
				lowerLimit = userNumber + 1;
				System.out.println("HIGHER :");
				}
			
			// Get new guess from the user
			System.out.print("Guess a number between :" + lowerLimit + " and " + upperLimit + " : ");
			userNumber = userInput.nextInt();
			
			// Check user input to ensure it is within the range
			while ((userNumber < lowerLimit) || (userNumber > upperLimit)){
				System.out.println("[" + userNumber + "] is outside of the range :");
				System.out.print("Guess a number between :" + lowerLimit + " and " + upperLimit + " : ");
				userNumber = userInput.nextInt();
			}
			index++;
		}
		
		// Display message when user guesses the correct number
		if (lowerLimit == upperLimit) {
			System.out.println("You lose the answer is [" + lowerLimit + "] It took you [" + index + "] guesses ");
		} else
			System.out.println("You Win. It took you [" + index + "] guesses ");
		}
	}

