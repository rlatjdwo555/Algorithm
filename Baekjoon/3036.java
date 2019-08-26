import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		input.readLine();
		
		StringTokenizer token = new StringTokenizer(input.readLine());
		int first = Integer.parseInt(token.nextToken());
		
		while(token.hasMoreTokens()) {
			int n = Integer.parseInt(token.nextToken());
			int gcd = euclide(first, n);
			
			if(gcd == 1) {
				output.append(first+"/"+n+"\n");
				continue;
			}
			
			output.append(first/gcd+"/"+n/gcd+"\n");
		}
		
		System.out.println(output);
	}

	private static int euclide(int a, int b) {
		int remain = 1;
		
		while(b > 0) {
			remain = a % b;
			a = b;
			b = remain;
		}
		
		return a;
	}
}
