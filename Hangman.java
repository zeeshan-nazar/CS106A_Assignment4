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
	
	
	
	
	
	private String pickWord(){
		
		int randWord = rgen.nextInt(0,hangman.getWordCount());
		
		String pickWord = hangman.getWord(randWord);
		return pickWord;
	}
	
	String word = pickWord();
	private String countNumberOfCharcterInPickWord(){
		String charLength = "";
		for(int count =0; count<word.length();count++)
		{
			charLength = charLength + "-";
		}
		return charLength;
	}
	
	String hiddenWord = countNumberOfCharcterInPickWord();
	
	
	public void run() {
		/* You fill this in */
    	setSize(windowWidth,windowHeight);
    	
    	println("Welcome to Hangman !");
       	println("The word now looks like this: "+ hiddenWord);
       	println("You have " + guessCounter + " guesses left.");
    	
       	pickWord();
       	
    	
    	
    	
    	
    	
	}

}
