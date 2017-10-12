import java.io.IOException;
import java.io.PrintWriter;

public class fileDecryptor {
	public fileDecryptor() {
		String fileData = null;
	}
	public void decryptFile(String encryptedFile, String fileToAnalyze) {
		textAnalyzer textAn = new textAnalyzer();
		String[][] percentEncr = textAn.analyzeText(encryptedFile);
		String[][] percentToCheck = textAn.analyzeText(fileToAnalyze);
		fileReader fr = new fileReader();
		String fileData = fr.dataFromFile(encryptedFile);
		for (int i = 0; i < 26; i++) {
			fileData = fileData.replaceAll(String.valueOf(percentToCheck[0][i]), "-&" + String.valueOf(percentToCheck[0][i]));
		}
		double perctc;
		double percen;
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {

				perctc = Double.valueOf(percentToCheck[1][i]);
				percen = Double.valueOf(percentEncr[1][j]);
				
				if (perctc == percen || (perctc + 0.02 > percen && perctc - 0.02 < percen)) {
					System.out.println("Zamena");
					fileData = fileData.replaceAll(String.valueOf("-&" + percentEncr[0][j]), String.valueOf(percentToCheck[0][i]));
				}
			}
		}
		try {
			PrintWriter writer = new PrintWriter("un" + encryptedFile, "UTF-8");
			writer.println(fileData);
			writer.close();
		} catch(IOException e) {
			System.out.println("OutputException");
		}
		System.out.println("Ваш дешифрованный файл называется un" + encryptedFile +
				" и находится в корне проекта.");

	}
}
