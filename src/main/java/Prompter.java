import java.lang.System.*;
import java.io.*;
import java.util.*;

public class Prompter {
	
	private Jar mJar;
	private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private int quantityGuessed;
	private int numberOfTries = 1;
	
	public Prompter() {
	}
	
	public void promptAdministrator() {
		String item = null;
		int maxNumber = 0;
		
		// Prompt Administrator for item type and maximum quantity
		System.out.println("---------- Administrator ----------\n");
		System.out.print("What type of item?  ");
		try {
			item = bf.readLine();	
			while (item == null || item.isEmpty()) {
				System.out.print("What type of item?  ");
				item = bf.readLine();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());	
		}
		
		while (maxNumber == 0) {
			System.out.printf("\nWhat is the maximum amount of %s?  ", item);
			try {
				maxNumber = Integer.parseInt(bf.readLine());
				mJar = new Jar(item, maxNumber);
				mJar.fillJar();
			} catch (IOException e) {
				System.out.println(e.getMessage());	
			} catch (NumberFormatException nfe) {
				System.out.println("Must be a number...");
				maxNumber = 0;
			} catch (IllegalArgumentException iae) {
				System.out.println("Must be greater than 0");
				maxNumber = 0;
			}
		}
	}
	
	public void userPlay() {
		System.out.println("\n\n---------- Player ----------\n");
		System.out.printf("How many %s are in the jar? Pick a number between 1 and %d", 
										 mJar.getItem(), mJar.getMaxQuantity());
		
		while (quantityGuessed != mJar.getItemsInJar()) {
			try {
				System.out.print("\nGuess:  ");
				quantityGuessed = Integer.parseInt(bf.readLine());
				checkGuess(quantityGuessed);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException nfe) {
				System.out.println("Must be a number...");
				quantityGuessed = 0;
			}
		}
		
		if (quantityGuessed == mJar.getItemsInJar()) {
			System.out.printf("Correct! The jar has %d %s in it. It took you %d guess(es)%n",
												mJar.getItemsInJar(), mJar.getItem(), numberOfTries);
		}
	}
	
	public void checkGuess(int guess) {
    if (guess > mJar.getMaxQuantity()) {
			System.out.printf("Your guess must be less than %d ", mJar.getMaxQuantity());
		} else if (guess < mJar.getItemsInJar()) {
			System.out.println("Your guess is too low");	
			numberOfTries++;
		} else if (guess > mJar.getItemsInJar()) {
			System.out.println("Your guess is too high");
			numberOfTries++;
		}
	}
}