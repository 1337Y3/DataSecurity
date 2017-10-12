import java.io.*;

public class fileEncryptor {
	private String fileName;
	private String readFile;
	public fileEncryptor() {
		fileName = null;
		readFile = null;
	}
	public void encryptFile (String name, String oldAlphabet, String newAlphabet) {
		readFile ="";
		char[] oldAlph = oldAlphabet.toCharArray();
		char[] newAlph = newAlphabet.toCharArray();
		
		//Вызов функции чтения файла
		fileReader fr = new fileReader();
		readFile = fr.dataFromFile(name);
		
		//Замена букв старого алфавита на буквы нового
		readFile = readFile.toLowerCase();
		for (int i = 0; i < oldAlphabet.length(); i++) {
			readFile = readFile.replaceAll(String.valueOf(oldAlph[i]), "-&" + String.valueOf(oldAlph[i]));
		}
		for (int j = 0; j < oldAlphabet.length(); j++) {
			readFile = readFile.replaceAll("-&" + String.valueOf(oldAlph[j]), String.valueOf(newAlph[j]));
		}
		System.out.println("Ваш зашифрованный файл называется encrypted" + name +
				" и находится в той же папке, что и незашифрованный.");

		try {
			PrintWriter writer = new PrintWriter("encrypted" + name, "UTF-8");
			writer.println(readFile);
			writer.close();
		} catch(IOException e) {
			System.out.println("OutputException");
		}
	}
}
