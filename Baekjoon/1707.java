import java.io.*;
import java.util.ArrayList;

public class Main {
	
	static int V, E;
	static ArrayList<Integer>[] graph;
	static boolean visit[][];
	static boolean answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int nCase = Integer.parseInt(input.readLine());
		
		while(nCase -- > 0){
			String size[] = input.readLine().split(" ");
			V = Integer.parseInt(size[0]);
			E = Integer.parseInt(size[1]);
			graph = new ArrayList[V+1];
			visit = new boolean[V+1][2];
			answer = true;
			
			for(int i=1; i<=V; i++){
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; i++){
				String edge[] = input.readLine().split(" ");
				int x = Integer.parseInt(edge[0]);
				int y = Integer.parseInt(edge[1]);
				
				graph[x].add(y);
				graph[y].add(x);
			}
			
			for(int i=1; i<=V; i++){
				if(!visit[i][0]){
					dfs(i, true);
				}
			}
			
			if(answer){
				output.write("YES\n");
			}else{
				output.write("NO\n");
			}
			
		}
		
		output.flush();
	}
	
	static void dfs(int v, boolean flag){
		visit[v][0] = true;
		visit[v][1] = flag;
		int range = graph[v].size();
		
		for(int i=0; i<range; i++){
			int next = graph[v].get(i);
			
			if(visit[next][0] && flag == visit[next][1]){
				answer = false;
				return;
			}else if(visit[next][0]) continue;
			
			dfs(next, !flag);
            if(!answer) return;
		}
	}
}
