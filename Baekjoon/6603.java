import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[] numbers;
	static int[] check;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String []testCase = input.readLine().split(" ");
			N = Integer.parseInt(testCase[0]);
			
			if(N == 0) break;
			
			numbers = new int[N];
			check = new int[N];
			
			for(int i=0; i<N; i++){
				numbers[i] = Integer.parseInt(testCase[i+1]);
			}
			
			DFS(0,0);
			output.append("\n");
		}
		
		System.out.println(output);
	}
	
	static String DFS(int head, int depth){
		if(depth == 6){
			output.append(print());
		}
		
		for(int i=head; i<N; i++){
			check[i] = 1;
			DFS(i+1, depth+1);
			check[i] = 0;
		}	
		return "";
	}
	
	static String print(){
		StringBuilder result = new StringBuilder();
		
		for(int i=0; i<N; i++){
			if(check[i] == 1){
				result.append(numbers[i]+" ");
			}
		}
		return result.append("\n").toString();
	}
}
