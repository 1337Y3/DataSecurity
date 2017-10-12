import java.util.Set;
import java.util.LinkedHashSet;

public class newAlphabet {
	private String originalAlphabet;
	private String newAlph;
	public newAlphabet() {
		originalAlphabet = "abcdefghijklmnopqrstuvwxyz";
		newAlph = null;
	}
	public String genNewAlph(String key) {
		newAlph = key + originalAlphabet;
		char[] newAlphArray = newAlph.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
		for (char c : newAlphArray) {
			charSet.add(c);
		}
		StringBuilder sb = new StringBuilder();
		for (Character character : charSet) {
			sb.append(character);
		}
		newAlph = sb.toString();
		return newAlph;
	}
}
