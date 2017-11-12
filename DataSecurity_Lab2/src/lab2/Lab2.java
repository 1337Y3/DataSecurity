
package lab2;

import java.util.Random;
import java.util.Scanner;


public class Lab2 {

        public static void main(String[] args) {
        String dict = "abcdefghijklmnopqrstuvwxyz";
        char[] achDict = dict.toCharArray();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input text");
        String text = scanner.nextLine();
        char[] achText = text.toCharArray();
        char[] achKey = new char[achText.length];
        char[] achResult = new char[achText.length];
        Random random = new Random(); 
        for (int i = 0; i < achText.length; i++) { 
        achKey[i] = achDict[random.nextInt(26)]; 
        achResult[i] = (char) (achText[i] ^ achKey[i]); 
        } 

System.out.println("Text: " + String.valueOf(achText)); 
System.out.println("Key: " + String.valueOf(achKey)); 
System.out.println("Result: " + String.valueOf(achResult)); 

char[] achDecrypt = new char[achText.length]; 
for (int i = 0; i < achText.length; i++) { 
achDecrypt[i] = (char) (achResult[i] ^ achKey[i]); 
} 

System.out.println("Decrypt: " + String.valueOf(achDecrypt)); 
} 
}
        
    
    

