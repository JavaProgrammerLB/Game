package liangfei.game.russiablock.util;

import java.util.Random;

public class RandomGenerator {
	
	private static final RandomGenerator randomGenerator = new RandomGenerator();
	
	private Random random; //维持同一Random的单例，保证几率平等
	
	// 私有构造子(单例模式)
	
	private RandomGenerator() {
		random = new Random(System.currentTimeMillis());
	}
	
	public static RandomGenerator getRandomGenerator() {
		return randomGenerator;
	}
	
	public int randomByMax(int max) {
		if (max <= 0) {
			return 0;
		}
		int num = random.nextInt(max + 2); // +2以消除边界不平等
		while (num < 1 || num > max) {
			num = random.nextInt(max);
		}
		return num - 1;
	}
	
}
