/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */


import acm.program.*;
import acm.util.*;




public class Hangman extends ConsoleProgram {

	private int windowWidth = 700;
	private int windowHeight = 1000;
	private HangmanLexicon hangman = new HangmanLexicon();
	private HangmanCanvas canvas ;
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	private int guessCounter = 8;
	private char character;
	private String incorrectLetter = "";
	

	
	private String pickWord(){
		
		int randWord = rgen.nextInt(0,hangman.getWordCount());
		
		String pickWord = hangman.getWord(randWord);
		return pickWord;
	}
	
	String word = pickWord();
	private String countNumberOfCharcterInPickWord(){
		String wordLength = "";
		for(int count =0; count<word.length();count++)
		{
			wordLength = wordLength + "-";
		}
		
		return wordLength;
	}
	
	String hiddenWord = countNumberOfCharcterInPickWord();
	private void playGame(){
		
		println(word); ////////////.........
		String letter;
		
		while(true){
			if(guessCounter == 0){
				gameOver();
				break;
			}
			
			else{
				
					if(hiddenWord.equals(word)){
						wonGame();
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
			
				searchCharacter();
				characterPresentOrNot();
			}
		}
	}
		
	}
	
	private void searchCharacter(){
		for(int match = 0; match<word.length();match++)
		{				
			if(character == word.charAt(match))
			{
				hiddenWord = hiddenWord.substring(0,match) + character + hiddenWord.substring(match + 1);

			}
			
			canvas.displayWord(hiddenWord);
			
		}
	}
	
	private void characterPresentOrNot(){
		 int index = word.indexOf(character);
			
			if(index == -1){
				println("There are no " + character + " in the word.");
				guessCounter--;
				
				incorrectLetter = incorrectLetter + character;
				canvas.noteIncorrectGuess(incorrectLetter);
				println("The word now looks like this: "+ hiddenWord);
				println("You have "+ guessCounter + " guesses left");
			}
			
			else if(index != -1){
				
				println("That guess is correct");
				println("The word now looks like this: "+ hiddenWord);
				println("You have "+ guessCounter + " guesses left");
			}
	}
	
	private void gameOver(){
		println("You are completely hung.");
		println("The word was :"+ word);
		println("You Lose the game :(");
	}
	
	private void wonGame(){
		println("You guessed the word:" +word);
		println("You won the game :)");
		
	}
	public void run() {
		/* You fill this in */
				
    	setSize(windowWidth,windowHeight);
    	canvas.reset();
    	
    	println("Welcome to Hangman !");
    	println("The word now looks like this: "+ hiddenWord);
    	println("You have " + guessCounter + " guesses left.");
    	
    	playGame();
    	
	}
	
	public void init(){
		canvas = new HangmanCanvas();
		add(canvas);		
	}

}
