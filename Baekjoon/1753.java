import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception{
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	String ve[] = input.readLine().split(" ");
    	
    	int V = Integer.parseInt(ve[0]);
    	int E = Integer.parseInt(ve[1]);
    	int S = Integer.parseInt(input.readLine());
    	
    	ArrayList<Node>[] graph = new ArrayList[V+1];
    	int dis[] = new int[V+1];
    	boolean visit[] = new boolean[V+1];
    	int INF = Integer.MAX_VALUE >> 1;
    	
    	for(int i=1; i<=V; i++){
    		graph[i] = new ArrayList<>();
    	}
    	
    	Arrays.fill(dis, INF);
    	
    	while(E-- > 0){
    		String tc[] = input.readLine().split(" ");
    		int s = Integer.parseInt(tc[0]);
    		int e = Integer.parseInt(tc[1]);
    		int w = Integer.parseInt(tc[2]);
    		
    		graph[s].add(new Node(e, w));
    	}
    	
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	dis[S] = 0;
    	pq.add(new Node(S, 0));
    	
    	while(!pq.isEmpty()){
    		Node cur = pq.poll();
    		int index = cur.index;
    		
    		if(visit[index]){
    			continue;
    		}
    		
    		visit[index] = true;
    		
    		for(Node node : graph[index]){
    			if(dis[node.index] > dis[index]+node.w){
    				dis[node.index] = dis[index]+node.w;
    				pq.add(new Node(node.index, dis[node.index]));
    			}
    		}
    	}
    	
    	StringBuilder output = new StringBuilder();
    	
    	for(int i=1; i<=V; i++){
    		output.append(dis[i] == INF ? "INF" : dis[i]).append("\n");
    	}
    	
    	System.out.println(output);
    }
}

class Node implements Comparable<Node>{
	int index;
	int w;
	
	Node(int index, int w){
		this.index = index;
		this.w = w;
	}
	
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.w, o.w);
	}
}
