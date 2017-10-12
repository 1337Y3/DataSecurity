import java.util.Random;
public class keyGen {
	private String key;
	private int keyNumber;
	
	public keyGen() {
		key = null;
		keyNumber = 3;
	}
	
	public String generateKey(int gotKeyNumber) {
		keyNumber = gotKeyNumber;
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < keyNumber; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		key = sb.toString();
		return key;
	}
}
