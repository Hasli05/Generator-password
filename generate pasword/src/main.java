import java.util.Scanner;
import java.util.Random;

public class main {

	public static void main(String[] args) {
		String stringForPassword = "0123456789abcdefghijklmnopqrstuvwxyz!@#$%^&*()ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] symbolsForPassword = new char[stringForPassword.length()];
		
		for(int i = 0; i < stringForPassword.length(); ++i) {
			symbolsForPassword[i] = stringForPassword.charAt(i);
		}
		
		
		Scanner len = new Scanner(System.in);
		System.out.println("Введите длинну пароля: ");
		
		int length = len.nextInt();
		
		len.close();
		
		
		String password = "";
		
		Random rand = new Random();
		
		for(int i = 0; i < length; ++i) {
			int randomNum = rand.nextInt(stringForPassword.length());
			password += symbolsForPassword[randomNum];
		}
		
		
		System.out.println("Ваш пароль: " + password);
	}

}
