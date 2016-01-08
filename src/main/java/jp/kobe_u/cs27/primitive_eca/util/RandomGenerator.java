package jp.kobe_u.cs27.primitive_eca.util;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;

/**
 * @author otokunaga
 *
 */
public class RandomGenerator {
	private static RandomGenerator rand;
	private static SecureRandom random = new SecureRandom();
	static byte bytes[] = new byte[16];
	private static final String algorithm = "SHA1PRNG";
	private static int testIndex = 0;
	private static HashMap<Integer,String> testVal = new HashMap<>();

	private RandomGenerator(){
		
	}
	public static RandomGenerator getInstance(){
		if(rand == null){
			rand = new RandomGenerator();
		}
		return rand;
	}
	/**
	 * securerondomを利用して、ECAのIDを生成
	 * @return
	 */
	public static String getRandomUniqueId(){
		try {
			random = SecureRandom.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		random.nextBytes(bytes);
		return new BigInteger(130,random).toString(32);
	}
	
	
	
}
