package util;

import java.util.Random;

public class RandomNumber {
	public int RandomNumbers(int i){
		Random random = new Random();
		int x = (int)Math.pow(10,i-1)  + random.nextInt(9*(int)Math.pow(10,i-1)-1);
		return x;
	}
}
