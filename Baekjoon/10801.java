import java.io.*;

public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		String A[] = input.readLine().split(" ");
		String B[] = input.readLine().split(" ");
		
		int a = 0;
		int b = 0;
		
		for(int i=0; i<10; i++){
			int cardA = Integer.parseInt(A[i]);
			int cardB = Integer.parseInt(B[i]);
			
			if(cardA > cardB) a++;
			else if(cardB > cardA) b++;
		}
		
		System.out.println(a == b ? 'D' : a > b ? 'A' : 'B');
	}
}
