import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String []args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String testCase[] = input.readLine().split(" ");
		
		int min1 = Integer.parseInt(testCase[0].replaceAll("6", "5"));
		int min2 = Integer.parseInt(testCase[1].replaceAll("6", "5"));
		
		int max1 = Integer.parseInt(testCase[0].replaceAll("5", "6"));
		int max2 = Integer.parseInt(testCase[1].replaceAll("5", "6"));
		
		System.out.println((min1+min2)+" "+(max1+max2));
	}
}
