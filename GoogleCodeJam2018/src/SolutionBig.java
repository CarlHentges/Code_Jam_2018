import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;

public class SolutionBig {
	
	public static double threshold = 0.00000000000000000000000000000000000000000001;
	
	public static void main(String[] args) {
		
		Scanner inputScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int counter = inputScanner.nextInt();
		inputScanner.nextLine();
		for (int i = 1; i <=counter; i++) {
			double area = inputScanner.nextDouble();
			try{inputScanner.nextLine();}catch (Exception e) {}
			System.out.println("Case #"+i+":");
			System.out.println(findCoordinates(area));
		}
		
		
		
	}
	
	public static String findCoordinates(double in) {
		BigDecimal ar
		
		double[] faceX = {0.5,0,0};
		double[] faceY = {0,0.5,0};
		double[] faceZ = {0,0,0.5};
		
		
		double angle = 0;
		
		double step = Math.PI/180;
		
		boolean increaseing = true;
		
		while(!inRange(area, face(angle))){
			
//			System.out.println( "area "+ face(angle) + " angle " + angle );
			angle += step;
			if (increaseing == true && area < face(angle)) {
//				System.out.println("swiching to neg");
				increaseing = false;
				step *= -0.5;
			}
			
			if (increaseing == false && area > face(angle)) {
//				System.out.println("swiching to pos");
				increaseing = true;
				step *= -0.5;
			}
		}
		
		faceX = rotateZ(faceX,angle);
		faceY = rotateZ(faceY,angle);
		faceZ = rotateZ(faceZ,angle);

		return faceX[0] +" "+faceX[1] +" "+faceX[2]+"\n"+faceY[0] +" "+faceY[1] +" "+faceY[2]+"\n"+faceZ[0] +" "+faceZ[1] +" "+faceZ[2];
	}
	
	public static double[] rotateZ(double[] input,double angle){
		double[] output = new double[3];
		output[0] = input[0] * Math.cos(angle) + input[1] * Math.sin(angle) * -1.0; 
		output[1] = input[0] * Math.sin(angle) + input[1] * Math.cos(angle);
		output[2] = input[2] * 1;
		
		
		return output;
	}
	
	public static double face(double angle) {
		return Math.cos(angle)+Math.sin(angle);
	}
	
	public static boolean inRange(double num1,double num2) {
		
		return Math.abs(num1 - num2) < threshold;
		
	}

}
