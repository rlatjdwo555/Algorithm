import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static boolean prime[] = new boolean[10000];

	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		
		getPrime();
		int nCase = Integer.parseInt(input.readLine());
	
		while(nCase-- > 0) {
			String testCase[] = input.readLine().split(" ");
			int A = Integer.parseInt(testCase[0]);
			int B = Integer.parseInt(testCase[1]);
			
			int answer = BFS(A, B);
			output.write(answer == -1 ? "Impossible\n" : answer+"\n");
		}
		
		output.flush();
	}
	
	static int BFS(int A, int B) {
		boolean visit[] = new boolean[10000];
		Queue<Integer> queue = new LinkedList<>();
		int answer = -1;
		int digit[] = new int[4];
		
		queue.add(A);
		visit[A] = true;
		
		while(!queue.isEmpty()) {
			answer++;
			
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				int n = queue.poll();
				visit[n] = true;
				
				if(n == B) return answer;
				
				for(int j=0; j<4; j++) {
					digit[0] = n/1000;
					digit[1] = n%1000/100;
					digit[2] = n%100/10;
					digit[3] = n%10;
					
					for(int k=0; k<10; k++) {
						digit[j] = k;
						int newNum = digit[0]*1000 + digit[1]*100 + digit[2]*10 + digit[3];
						
						if(!visit[newNum] && prime[newNum] && newNum > 1000) {
							queue.add(newNum);
						}
					}
				}
			}
		}
		
		return -1;
	}

	static void getPrime() {
		Arrays.fill(prime, true);
		
		for(int i=2; i<Math.sqrt(10000); i++) {
			if(prime[i]) {
				for(int j=i+i; j<10000; j+=i) {
					prime[j] = false;
				}
			}
		}
	}
}
