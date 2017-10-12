import java.io.*;
import java.util.Scanner;
public class Lab1 {
	public static void main(String []args) throws IOException {

		System.out.println("�������� ��������: \n\t1.����������;\n\t2.������������");
		
		//������������ ����� ��� ������ ������ ����
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		int choice = Integer.valueOf(input);
		
		switch (choice) {
		case 1: 
			System.out.println("������� ���������� �������� ����� (3-5): ");
			
			input = in.nextLine();
			int keyNumber = Integer.valueOf(input);
			
			//����� ������� ��������� ����� � ����������� ����������� �����
			keyGen newKey = new keyGen();
			String buff=newKey.generateKey(keyNumber);
			System.out.println("��� ����: " + buff);
			
			//����� ������� ��������� ������ ��������
			String oldAlphabet = "abcdefghijklmnopqrstuvwxyz";
			newAlphabet newAlph = new newAlphabet();
			String newAlphabet = newAlph.genNewAlph(buff);
			System.out.println("��� ����� �������: " + newAlph.genNewAlph(buff));
			
			//����� ������ ��� ����������
			System.out.println("������� �������� ����� ��� ���������� (*.txt)");
			String fileName = in.nextLine();
			fileEncryptor encrypt = new fileEncryptor();
			encrypt.encryptFile(fileName, oldAlphabet, newAlphabet);
			break;
		case 2:
			System.out.println("�������� ����� ��� ����������:");
			String decrFileName = in.nextLine();
			System.out.println("�������� ����� ��� �������");
			String analyzeFileName = in.nextLine();
			fileDecryptor fd = new fileDecryptor();
			fd.decryptFile(decrFileName, analyzeFileName);
			break;
		default:
			System.out.println("��� ������ ������");
			break;
		}
	}
}
