package generator;

import java.util.Random;

public class Generate {
	Random rand = new Random();
	
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
