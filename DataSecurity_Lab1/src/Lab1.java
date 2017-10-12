import java.io.*;
import java.util.Scanner;
public class Lab1 {
	public static void main(String []args) throws IOException {

		System.out.println("Выберите действие: \n\t1.Шифрование;\n\t2.Дешифрование");
		
		//Сканирование ввода для выбора пункта меню
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		int choice = Integer.valueOf(input);
		
		switch (choice) {
		case 1: 
			System.out.println("Введите количество символов ключа (3-5): ");
			
			input = in.nextLine();
			int keyNumber = Integer.valueOf(input);
			
			//Вызов функции генерации ключа и буферизация полученного ключа
			keyGen newKey = new keyGen();
			String buff=newKey.generateKey(keyNumber);
			System.out.println("Ваш ключ: " + buff);
			
			//Вызов функции генерации нового алфавита
			String oldAlphabet = "abcdefghijklmnopqrstuvwxyz";
			newAlphabet newAlph = new newAlphabet();
			String newAlphabet = newAlph.genNewAlph(buff);
			System.out.println("Ваш новый алфавит: " + newAlph.genNewAlph(buff));
			
			//Выбор текста для шифрования
			System.out.println("Введите название файла для шифрования (*.txt)");
			String fileName = in.nextLine();
			fileEncryptor encrypt = new fileEncryptor();
			encrypt.encryptFile(fileName, oldAlphabet, newAlphabet);
			break;
		case 2:
			System.out.println("Выберите текст для дешифровки:");
			String decrFileName = in.nextLine();
			System.out.println("Выберите текст для анализа");
			String analyzeFileName = in.nextLine();
			fileDecryptor fd = new fileDecryptor();
			fd.decryptFile(decrFileName, analyzeFileName);
			break;
		default:
			System.out.println("Нет такого пункта");
			break;
		}
	}
}
