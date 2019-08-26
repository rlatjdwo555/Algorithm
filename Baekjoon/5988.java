import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(input.readLine());
		
		while(N-- > 0) {
			String tc = input.readLine();
			output.write((tc.charAt(tc.length()-1)-'0' & 1) == 0 ? "even\n" : "odd\n");
		}
		
		output.flush();
	}
}
