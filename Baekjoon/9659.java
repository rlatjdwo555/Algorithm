import java.io.*;

public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(input.readLine());
		
		System.out.println((N & 1) == 0 ? "CY" : "SK");
	}
}
