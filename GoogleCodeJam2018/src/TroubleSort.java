import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TroubleSort {
	
	public static void main(String[] args) {
		
		Scanner inputScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int counter = inputScanner.nextInt();
		inputScanner.nextLine();
		for (int i = 1; i <=counter; i++) {
			inputScanner.nextLine();
			String input = inputScanner.nextLine();
			System.out.print("Case #"+i+": ");
			int temp = isSorted(troubleSort(toCorrectForm(input)));
			if(temp == -1) {
				System.out.print("OK\n");
			}else {
				System.out.print(temp+"\n");
			}
		}		
		
	}
	
	public static ArrayList<Integer> toCorrectForm(String input){
		ArrayList<String> stringList = new ArrayList<String>(Arrays.asList(input.split(" ")));
		ArrayList<Integer> intList = new  ArrayList<>();
		for(int i = 0; i < stringList.size();i++) {
			intList.add(Integer.parseInt(stringList.get(i)));
		}
		
		return intList;
	}
	
	public static ArrayList<Integer> troubleSort(ArrayList<Integer> input) {
		
		boolean isRunning = true;
		
		while(isRunning) {
				isRunning = false;
			for(int i = 0; i <  input.size()-2; i++) {
				
				int temp;
				
				if (input.get(i) > input.get(i+2)) {
					temp = input.get(i);
					input.set(i, input.get(i+2));
					input.set(i+2, temp);
					isRunning = true;
				}
				
			}
		}
		return input;
	}
	
	public static int isSorted(ArrayList<Integer> input) {
		for(int i = 1; i < input.size();i++) {
			if (input.get(i-1) > input.get(i) ) {
				return i-1;
			}
		}
		return -1;
	}

}
