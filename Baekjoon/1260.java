import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static StringBuilder output = new StringBuilder();
	static Queue<Integer> queue = new LinkedList<>();
	static ArrayList<Integer> graph[];
	static boolean visited[];
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String testCase[] = input.readLine().split(" ");
		
		int N = Integer.parseInt(testCase[0]);
		int M = Integer.parseInt(testCase[1]);
		int V = Integer.parseInt(testCase[2]);
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++){
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++){
			String route[] = input.readLine().split(" ");
			int x = Integer.parseInt(route[0]);
			int y = Integer.parseInt(route[1]);
			
			graph[x].add(y);
			graph[y].add(x);
		}
		
		for(int i=1; i<=N; i++){
			Collections.sort(graph[i]);
		}
		
		DFS(V);
		output.append("\n");
		
		init();
		BFS(V);
		System.out.println(output);
	}
	
	static void init(){
		Arrays.fill(visited, false);
	}
	
	static void DFS(int start){
		visited[start] = true;
		output.append(start+" ");
		
		for(int n : graph[start]){
			if(!visited[n]){
				DFS(n);
			}
		}
	}
	
	static void BFS(int start){
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()){
			int n = queue.poll();
			output.append(n+" ");
			
			for(int x : graph[n]){
				if(!visited[x]){
					visited[x] = true;
					queue.add(x);
				}
			}
		}
	}
}
