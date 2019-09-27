import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		
		int arr[][] = new int[N][N];
		int answer[][] = new int[N][N];
		
		for(int i=0; i<N; i++){
			String testCase[] = input.readLine().split(" ");	
			for(int j=0; j<N; j++){
				arr[i][j] = Integer.parseInt(testCase[j]);
			}
		}
		
		for(int i=0; i<N; i++){
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = new boolean[N];
			
			queue.offer(i);
			
			while(!queue.isEmpty()){
				int p = queue.poll();
				
				for(int j=0; j<N; j++){	
					if(arr[p][j] == 1 && !visited[j]){
						queue.add(j);
						visited[j] = true;
						answer[i][j] = 1;
					}
				}
			}
		}
		
		StringBuilder output = new StringBuilder();
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				output.append(answer[i][j]+" ");
			}
			output.append("\n");
		}
		
		System.out.println(output);
		
	}
}
