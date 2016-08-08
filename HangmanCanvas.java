/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	

/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		
		double scaffold_Start_x_coordinate = getWidth()/2 * 2;
		double scaffold_Start_y_coordinate = getHeight()/2;
		double scaffold_End_y_coordinate = scaffold_Start_y_coordinate + SCAFFOLD_HEIGHT ;
		GLine scaffold= new GLine (scaffold_Start_x_coordinate, scaffold_Start_y_coordinate, scaffold_Start_x_coordinate, scaffold_End_y_coordinate);
		add(scaffold);
		
		double beam_End_x_coordinate = scaffold_Start_x_coordinate + BEAM_LENGTH;
		GLine beam = new GLine(scaffold_Start_x_coordinate, scaffold_Start_y_coordinate, beam_End_x_coordinate, scaffold_Start_y_coordinate);
		add(beam);
		
		double rope_End_y_coordinate  = scaffold_Start_y_coordinate + ROPE_LENGTH;
		GLine rope = new GLine (beam_End_x_coordinate, scaffold_Start_y_coordinate , beam_End_x_coordinate, rope_End_y_coordinate);
		add(rope);
		
		drawHead();
		drawBody();
		leftArm();
		rightArm();
		hip();
		Legs();
		leftFoot();
	}
	
	private void drawHead(){
		
		double head_width = getWidth()*2 + ROPE_LENGTH + 7;
		double head_height = getHeight()/2 + ROPE_LENGTH;
		
		GOval head = new GOval(head_width,head_height,HEAD_RADIUS,HEAD_RADIUS);
		add(head);
	}
	
	private void drawBody(){
		double body_Start_x_coordinate = getWidth()*2 + ROPE_LENGTH*2 + 7;
		double body_Start_y_coordinate = getHeight()/2 + ROPE_LENGTH + HEAD_RADIUS + 2;
		double body_End_x_coordinate = body_Start_x_coordinate;
		double body_End_y_coordinate = body_Start_y_coordinate + BODY_LENGTH;
		
		GLine body = new GLine(body_Start_x_coordinate,body_Start_y_coordinate,body_End_x_coordinate,body_End_y_coordinate);
		add(body);
	}
	
	
	private void leftArm(){
		double leftArm_Start_x_coordinate = getWidth()*2 + HEAD_RADIUS + ROPE_LENGTH/2 - 2;
		double leftArm_Start_y_coordinate = getHeight() + ARM_OFFSET_FROM_HEAD;
		double leftArm_End_x_coordinate = leftArm_Start_x_coordinate - UPPER_ARM_LENGTH;
	    double leftArm_End_y_coordinate = leftArm_Start_y_coordinate;
	    
	    GLine upper_left_Arm = new GLine(leftArm_Start_x_coordinate,leftArm_Start_y_coordinate, leftArm_End_x_coordinate,leftArm_End_y_coordinate);
	    add(upper_left_Arm);
	    
	    double left_Lower_Arm_Start_x_coordinate = leftArm_End_x_coordinate;
	    double left_Lower_Arm_Start_y_coordinate = leftArm_Start_y_coordinate;
	    double left_Lower_Arm_End_x_coordinate = left_Lower_Arm_Start_x_coordinate;
	    double left_Lower_Arm_End_y_coordinate = leftArm_Start_y_coordinate + LOWER_ARM_LENGTH;
	    
	    GLine lower_left_Arm = new GLine(left_Lower_Arm_Start_x_coordinate,left_Lower_Arm_Start_y_coordinate,left_Lower_Arm_End_x_coordinate,left_Lower_Arm_End_y_coordinate);
	    add(lower_left_Arm);
	}
	
	private void rightArm(){
		double rightArm_Start_x_coordinate = getWidth()*2 + HEAD_RADIUS + ROPE_LENGTH/2 - 2;
		double rightArm_Start_y_coordinate = getHeight() + ARM_OFFSET_FROM_HEAD;
		double rightArm_End_x_coordinate = rightArm_Start_x_coordinate + UPPER_ARM_LENGTH;
	    double rightArm_End_y_coordinate = rightArm_Start_y_coordinate;
	    
	    GLine upper_right_Arm = new GLine(rightArm_Start_x_coordinate,rightArm_Start_y_coordinate, rightArm_End_x_coordinate,rightArm_End_y_coordinate);
	    add(upper_right_Arm);
	    
	    double right_Lower_Arm_Start_x_coordinate = rightArm_End_x_coordinate;
	    double right_Lower_Arm_Start_y_coordinate = rightArm_Start_y_coordinate;
	    double right_Lower_Arm_End_x_coordinate = right_Lower_Arm_Start_x_coordinate;
	    double right_Lower_Arm_End_y_coordinate = rightArm_Start_y_coordinate + LOWER_ARM_LENGTH;
	    
	    GLine lower_right_Arm = new GLine(right_Lower_Arm_Start_x_coordinate,right_Lower_Arm_Start_y_coordinate,right_Lower_Arm_End_x_coordinate,right_Lower_Arm_End_y_coordinate);
	    add(lower_right_Arm);
	}
	
	private void hip(){
		double left_hip_Start_x_coordinate = getWidth()*2 + HEAD_RADIUS + ROPE_LENGTH/2 - 2;
		double left_hip_Start_y_coordinate = getHeight()/2 + ROPE_LENGTH + HEAD_RADIUS + BODY_LENGTH + 2;
		double left_hip_End_x_coordinate = left_hip_Start_x_coordinate - HIP_WIDTH;
		double left_hip_End_y_coordinate =  left_hip_Start_y_coordinate;
		
		GLine hip_Left_Side = new GLine(left_hip_Start_x_coordinate,left_hip_Start_y_coordinate,left_hip_End_x_coordinate,left_hip_End_y_coordinate);
		add(hip_Left_Side);
		
		
		double right_hip_Start_x_coordinate = getWidth()*2 + HEAD_RADIUS + ROPE_LENGTH/2 - 2;
		double right_hip_Start_y_coordinate = getHeight()/2 + ROPE_LENGTH + HEAD_RADIUS + BODY_LENGTH + 2;
		double right_hip_End_x_coordinate = right_hip_Start_x_coordinate + HIP_WIDTH;
		double right_hip_End_y_coordinate =  right_hip_Start_y_coordinate;
		
		GLine hip_Right_Side = new GLine(right_hip_Start_x_coordinate,right_hip_Start_y_coordinate,right_hip_End_x_coordinate,right_hip_End_y_coordinate);
		add(hip_Right_Side);
		
		
	}
	
	private void Legs(){
		double leftLeg_Start_x_coordinate = getWidth()*2 + HEAD_RADIUS + ROPE_LENGTH/2 - HIP_WIDTH - 2;
		double leftLeg_Start_y_coordinate = getHeight()/2 + ROPE_LENGTH + HEAD_RADIUS + BODY_LENGTH + 2;
		double leftLeg_End_x_coordinate = leftLeg_Start_x_coordinate;
	    double leftLeg_End_y_coordinate = leftLeg_Start_y_coordinate + LEG_LENGTH;
	    
	    GLine left_Leg = new GLine(leftLeg_Start_x_coordinate,leftLeg_Start_y_coordinate, leftLeg_End_x_coordinate,leftLeg_End_y_coordinate);
	    add(left_Leg);
	    
	    double rightLeg_Start_x_coordinate = getWidth()*2 + HEAD_RADIUS + ROPE_LENGTH/2 + HIP_WIDTH - 2;
		double rightLeg_Start_y_coordinate = getHeight()/2 + ROPE_LENGTH + HEAD_RADIUS + BODY_LENGTH + 2;
		double rightLeg_End_x_coordinate = rightLeg_Start_x_coordinate;
	    double rightLeg_End_y_coordinate = rightLeg_Start_y_coordinate + LEG_LENGTH;
	    
	    GLine right_Leg = new GLine(rightLeg_Start_x_coordinate,rightLeg_Start_y_coordinate, rightLeg_End_x_coordinate,rightLeg_End_y_coordinate);
	    add(right_Leg);
	}
	
	private void leftFoot(){
		double leftFoot_Start_x_coordinate = getWidth()*2 + HEAD_RADIUS + ROPE_LENGTH/2 - HIP_WIDTH - 2;
		double leftFoot_Start_y_coordinate = getHeight()/2 + ROPE_LENGTH + HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH + 2;
		double leftFoot_End_x_coordinate = leftFoot_Start_x_coordinate - FOOT_LENGTH;
	    double leftFoot_End_y_coordinate = leftFoot_Start_y_coordinate;
	    
	    GLine left_Foot = new GLine(leftFoot_Start_x_coordinate,leftFoot_Start_y_coordinate,leftFoot_End_x_coordinate,leftFoot_End_y_coordinate);
	    add(left_Foot);
	    
	    double rightFoot_Start_x_coordinate = getWidth()*2 + HEAD_RADIUS + ROPE_LENGTH/2 + HIP_WIDTH - 2;
		double rightFoot_Start_y_coordinate = getHeight()/2 + ROPE_LENGTH + HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH + 2;
		double rightFoot_End_x_coordinate = rightFoot_Start_x_coordinate + FOOT_LENGTH;
	    double rightFoot_End_y_coordinate = rightFoot_Start_y_coordinate;
	    
	    GLine right_Foot = new GLine(rightFoot_Start_x_coordinate,rightFoot_Start_y_coordinate,rightFoot_End_x_coordinate,rightFoot_End_y_coordinate);
	    add(right_Foot);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
