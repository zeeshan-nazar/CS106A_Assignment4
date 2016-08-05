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
	private char character;
	String temp;
	
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
	private void playGame(){
		
		String letter;
		
		println("Word: " + word);		//...............
		while(true){
			if(guessCounter == 0){
				println("You are completely hung.");
				println("The word was :"+ word);
				println("You Lose the game.");
				break;
			}
			
			else{
				letter = readLine("Your guess character:");
				while(true){
				if(letter.length()>1){
					letter = readLine("You guess only one letter at a time, Please enter again only one letter :");
				}
				
				if(letter.length() == 1){
					break;
				}
			}
				character = letter.charAt(0);
				
				if(Character.isLowerCase(character))
				{					
					character = Character.toUpperCase(character);	
				}
				
				
				for(int match = 0; match<word.length();match++)
				{				
					if(character == word.charAt(match))
					{
						 temp = hiddenWord.substring(0,match)+ character + hiddenWord.substring(match+1);
						hiddenWord = temp;
						

					}
					
					
				}
				
				 int index = word.indexOf(character);
				
				if(index == -1){
					println("There are no " + character + " in the word.");
					guessCounter--;
					println("The word now looks like this: "+ hiddenWord);
					println("You have "+ guessCounter + " guesses left");
				}
				
				else if(index != 1){
					println("That guess is correct");
					println("The word now looks like this: "+ hiddenWord);
					println("You have "+ guessCounter + " guesses left");
				}
				
			}
		}
		
		if(guessCounter>0){
			if(hiddenWord.length() == word.length()){
				println("That guess is correct.");
				println("You guessed the word:" +word);
				println("You win");
				
			}
		} 
		
	}
	
	public void run() {
		/* You fill this in */
		
		
    	setSize(windowWidth,windowHeight);
    	println("Welcome to Hangman !");
    	println("The word now looks like this: "+ hiddenWord);
    	println("You have " + guessCounter + " guesses left.");
    	playGame();
    	
    	
    	
    	
	}

}
