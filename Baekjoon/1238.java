import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {

	static Queue<Integer> q;
	static ArrayList<Vertex>[] graph;
	static boolean visited[];
	static int distance[];
	static int nV, nE, X;
	
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String firstCommand[] = input.readLine().split(" ");
		
		nV = Integer.parseInt(firstCommand[0]);
		nE = Integer.parseInt(firstCommand[1]);
		X = Integer.parseInt(firstCommand[2]);
		
		visited = new boolean[nV+1];
		distance = new int[nV+1];
		graph = new ArrayList[nV+1];
		
		init();
		
		for(int i=1; i<=nV; i++){
			graph[i] = new ArrayList<Vertex>();
		}
		
		for(int i=0; i<nE; i++){
			String testCase[] = input.readLine().split(" ");
			
			int u = Integer.parseInt(testCase[0]);
			int v = Integer.parseInt(testCase[1]);
			int w = Integer.parseInt(testCase[2]);
			
			graph[u].add(new Vertex(v,w));
		}
		
		q = new LinkedList<Integer>();
		
		dijkstra(X);
		
		int xToHome[] = new int[nV+1];
		
		for(int i=1; i<=nV; i++){
			xToHome[i] = distance[i];
		}
		
		int max = 0;
		
		for(int i=1; i<=nV; i++){
			init();
			dijkstra(i);
			
			int totalDistance = distance[X] + xToHome[i];
			max = max < totalDistance ? totalDistance : max;
		}
		
		System.out.println(max);		
	}
	
	static void init(){
		Arrays.fill(visited, false);
		Arrays.fill(distance, 1000000);
	}
	
	static void dijkstra(int k){
		q.add(k);
		distance[k] = 0;
		
		while(!q.isEmpty()){
			int current = q.poll();
			visited[current] = true;
			
			for(int i=0; i<graph[current].size(); i++){
				Vertex v = graph[current].get(i);
				
				int next = v.no;
				int dis = v.weight;
				
				if(distance[next] > distance[current] + dis){
					distance[next] = distance[current] + dis;
					q.add(next);
				}
			}
		}
	}
}

class Vertex{
	int no;
	int weight;
	
	Vertex(int no, int weight){
		this.no = no;
		this.weight = weight;
	}
}
