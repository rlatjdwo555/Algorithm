import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String testCase[] = input.readLine().split(" ");
		
		String A = testCase[0];
		String B = testCase[1];
		
		int answer = B.length();
		
		int gap = B.length() - A.length();
		
		for(int i=0; i<=gap; i++){
			int head = i;
			int tail = gap-i;
			int diff = 0;
			
			for(int j=head; j<B.length()-tail; j++){
				if(A.charAt(j-head) != B.charAt(j)) diff++;
				if(diff > answer) break;
			}
			
			answer = Math.min(answer, diff);
		}
		
		System.out.println(answer);
	}
}
