/*
 * Author: Pat Hurley
 * This class generates a random
 * password for a random password
 * program with a gui
 */
package generator;

import java.util.Random;

/**
 * Generates a password using the ascii
 * table from 26-126 so includes all
 * letters a-z, A-Z, numbers 0-9, and 
 * a bunch of characters not sure if they
 * are all legal password characters though
 * @author pat
 *
 */
public class Generate {
	private Random rand = new Random();
	
	public String generateRandomPass(int length) {
		StringBuilder sb = new StringBuilder();
		int randNum;
		char randChar;
		for(int i = 0; i < length; i++) {
			randNum = rand.nextInt(100) + 26;
			randChar = (char) randNum;
			sb.append(randChar);
		}
		return sb.toString();
	}
	
	
}
