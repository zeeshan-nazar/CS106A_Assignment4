/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

	private int windowWidth = 400;
	private int windowHeight = 1000;
	private HangmanLexicon hangman = new HangmanLexicon();
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	private int guessCounter = 8;
	
	
	private void pickWord(){
		
		int randWord = rgen.nextInt(0,hangman.getWordCount());
		
		String pickWord = hangman.getWord(randWord);
		
		println("The Pick word is that :"+ pickWord);
	}
	
	
	
	
	public void run() {
		/* You fill this in */
    	setSize(windowWidth,windowHeight);
    	println("Welcome to Hangman !");
    	println("The word now looks like this: ");
    	println("You have " + guessCounter + " guesses left.");
    	pickWord();
    	
    	
    	
    	
	}

}
