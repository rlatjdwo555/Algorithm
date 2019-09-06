import java.io.*;

public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		String tc[] = input.readLine().split(" ");
		long A = Long.parseLong(tc[0]);
		long B = Long.parseLong(tc[1]);
		
		if(A > B){
			long tmp = A;
			A = B;
			B = tmp;
		}
		
		if(1 >= B-A){
			System.out.println(0);
			return;
		}
		
		output.append(B-A-1).append("\n");
		for(long i=A+1; i<B; i++){
			output.append(i).append(" ");
		}
		
		System.out.println(output);
	}
}
