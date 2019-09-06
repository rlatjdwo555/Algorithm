import java.io.*;

public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		int btn[] = {300, 60, 10};
		int N = Integer.parseInt(input.readLine());
		
		for(int i=0; i<3; i++){
			int count = N/btn[i];
			output.append(count).append(" ");
			N -= btn[i]*count;
		}
		
		System.out.println(N > 0 ? -1 : output);
	}
}
