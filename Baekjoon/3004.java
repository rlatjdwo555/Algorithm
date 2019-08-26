import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			
		int N = Integer.parseInt(input.readLine());
		int r = N/2;
		int c = N-r;
		System.out.println((r+1)*(c+1));
	}
}