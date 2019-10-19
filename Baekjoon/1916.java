import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	static Queue<Vertex> queue;
	static ArrayList<Vertex> graph[];
	static int distance[];
	static boolean visited[];
	static int N, M, S, K;
	
	public static void main(String []args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());
		
		visited = new boolean[N+1];
		distance = new int[N+1];
		graph = new ArrayList[N+1];
		
		Arrays.fill(distance, 100000*100000+1);
		
		for(int i=1; i<=N; i++){
			graph[i] = new ArrayList<Vertex>();
		}
		
		for(int i=0; i<M; i++){
			String nCase[] = input.readLine().split(" ");
			
			int x = Integer.parseInt(nCase[0]);
			int y = Integer.parseInt(nCase[1]);
			int w = Integer.parseInt(nCase[2]);
			
			graph[x].add(new Vertex(y,w));
		}
		
		String testCase[] = input.readLine().split(" ");
		
		S = Integer.parseInt(testCase[0]);
		K = Integer.parseInt(testCase[1]);
	
		queue = new PriorityQueue<Vertex>();
		
		Dijkstra(S);
		System.out.println(distance[K]);
	}
	
	static void Dijkstra(int s){
		queue.add(new Vertex(s,0));
		distance[s] = 0;
		
		while(!queue.isEmpty()){
			Vertex cur = queue.poll();
			visited[cur.p] = true;
			
			for(int i=0; i<graph[cur.p].size(); i++){
				Vertex next = graph[cur.p].get(i);
				
				int p = next.p;
				int dis = next.distance;
				
				if(distance[p] > distance[cur.p]+dis){
					distance[p] = distance[cur.p]+dis;
					queue.add(new Vertex(p, dis));
				}
			}
		}
	}
}

class Vertex implements Comparable<Vertex>{
	int p;
	int distance;
	
	Vertex(int p, int distance){
		this.p = p;
		this.distance = distance;
	}

	public int compareTo(Vertex vertex) {
		
		if(this.distance > vertex.distance){
			return 1;
		}else if(this.distance < vertex.distance){
			return -1;
		}else{
			return 0;
		}
	}
}
