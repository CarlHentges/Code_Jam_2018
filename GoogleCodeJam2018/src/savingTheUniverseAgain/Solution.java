package savingTheUniverseAgain;
import java.util.*;
import java.io.*;
public class Solution {
	
	public static void main(String[] args) {
		
		Scanner inputScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int counter = inputScanner.nextInt();
		int shield = 0;
		for (int i = 1; i <=counter; i++) {
			shield = inputScanner.nextInt();
			String input = inputScanner.nextLine();
			System.out.print(
					input);
			System.out.print("Case #"+i+": " );
			
			
			int test = lowerDamageTo(input,shield);
			if (test != -1) {
				System.out.print(test+"\n");
			}else {
				System.out.print("IMPOSSIBLE\n");
			}
		}		
		
	}
	
	public static int damageValue(String input) {
		
		int charge = 1;
		int totalDamage = 0;
		for(int i = 0; i < input.length();i++) {
			if (input.charAt(i) == 'S') {
				totalDamage += charge;
				//System.out.println("Shoot "+totalDamage 
				//		+ " " + charge);
			}
			if (input.charAt(i) == 'C') {
				charge*=2;
				//System.out.println("Charge "+totalDamage + " " + charge);
			}
		}
		return totalDamage;
	}
	
	public static String lowerDamage(String input) {
		for(int i = input.length()-1;i>0;i--) {
			if (input.charAt(i) == 'S' && input.charAt(i-1)=='C'){
				input = swap(input, i-1);
				return input;
			}
		}
		return input;
	}
	
	public static String swap(String input,int index) {
		char[] tempCharArr = input.toCharArray();
		char tempChar = tempCharArr[index];
		tempCharArr[index] = tempCharArr[index+1];
		tempCharArr[index+1] = tempChar;
		return new String(tempCharArr);
	}
	
	public static int lowerDamageTo(String input, int shield) {
		int hackCount = 0;
		while(damageValue(input)>shield) {
			if(hackCount > input.length()) return -1;
			input = lowerDamage(input);
			hackCount ++;
		}
		
		return hackCount;
	}
}

