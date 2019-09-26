import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static Queue<Integer> queue;
	static int visited[] = new int[100001];
	static int N, K;
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		
		queue = new LinkedList<Integer>();
		BFS(N);
		System.out.println(visited[K]-1);	
	}
	
	static void BFS(int n){
		queue.add(n);
		visited[n] = 1;	
		
		while(!queue.isEmpty()){
			int v = queue.poll();
			
			if(v == K){
				break;
			}
			
			if(v+1 <= K && visited[v+1] == 0){
				queue.add(v+1);
				visited[v+1] = visited[v]+1;
			}
			
			if(v-1 >= 0 && visited[v-1] == 0){
				queue.add(v-1);
				visited[v-1] = visited[v]+1;
			}
			
			if(v*2 <= 100000 && visited[v*2] == 0){
				queue.add(v*2);
				visited[v*2] = visited[v]+1;
			}		
		}
	}
}
