
public class textAnalyzer {
	private String readFile;
	private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	public textAnalyzer() {
		readFile = null;
	}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	public String[][] analyzeText(String fileName) {
		fileReader fr = new fileReader();
		readFile = fr.dataFromFile(fileName);
		readFile = readFile.toLowerCase();
		readFile = readFile.replaceAll("\\s+", "");
		String[][] charCount = new String[2][26];
		char [] alphArray = alphabet.toCharArray();
		for (int i = 0; i < alphabet.length(); i++) {
			charCount[0][i] = String.valueOf(alphArray[i]);
		}
		double length = readFile.length();
		double onePercent = length / 100;
		String cutReadFile;
		double percentage;
		double beforeDiv;
		for (int i = 0; i < 26; i++) {
			cutReadFile = readFile.replaceAll(charCount[0][i], "");
			beforeDiv = readFile.length() - cutReadFile.length();
			percentage = beforeDiv / onePercent ;
			percentage = round(percentage, 3);
			charCount[1][i] = Double.toString(percentage);
		}
		return charCount;
	}
}
