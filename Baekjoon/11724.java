import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String []args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String testCase[] = input.readLine().split(" ");
		
		int N = Integer.parseInt(testCase[0]);
		int M = Integer.parseInt(testCase[1]);
		int answer = 0;
		
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++){
			graph[i] = new ArrayList<Integer>();
		}
		
		boolean []visited = new boolean[N+1];
		
		while(M-- > 0){
			String command[] = input.readLine().split(" ");
			graph[Integer.parseInt(command[0])].add(Integer.parseInt(command[1]));
			graph[Integer.parseInt(command[1])].add(Integer.parseInt(command[0]));
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++){
			if(!visited[i]){
				answer++;
				visited[i] = true;
				queue.offer(i);
				
				while(!queue.isEmpty()){
					int p = queue.poll();
					
					for(int n : graph[p]){
						if(!visited[n]){
							queue.add(n);
							visited[n] = true;
						}
					}
				}
			}
		}
		
		System.out.println(answer);	
	}
}
