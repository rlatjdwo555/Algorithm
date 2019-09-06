import java.io.*;

public class Main {
		
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		
		System.out.println((N & 1)== 0 ? "CY" : "SK");
	}
}
