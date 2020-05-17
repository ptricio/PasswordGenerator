/*
 * Author: Pat Hurley
 * This class generates a random
 * password for a random password
 * program with a gui
 */
package generator;

import java.util.ArrayList;
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
	private String[] lowerCase = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	private String[] upperCase = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private String[] nums = {"0","1","2","3","4","5","6","7","8","9"};
	private String[] specialChar = {" ","!","\"","#","$","%","&","'","(",")","*","+",",","-",".","/",";","<","=",">","?","@","[","\\","]","^","`",
								  "{","|","}","~"};
	private ArrayList<String> selections = new ArrayList<>();
	
	public String generateRandomPass(int length, boolean upper, boolean num, boolean characters) {
		StringBuilder sb = new StringBuilder();
		int randNum;
		String randChar;
		selections.clear();
		
		for(String el: lowerCase) {
			selections.add(el);
		}
		
		if(upper) {
			for(String el: upperCase) {
				selections.add(el);
			}
		}
		
		if(num) {
			for(String el: nums) {
				selections.add(el);
			}
		}
		
		if(characters) {
			for(String el: specialChar) {
				selections.add(el);
			}
		}
		
		for(int i = 0; i < length; i++) {
			randNum = rand.nextInt(selections.size());
			randChar = selections.get(randNum);
			sb.append(randChar);
		}
		return sb.toString();
	}
	
	
}
