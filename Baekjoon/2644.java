import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));	
		int N = Integer.parseInt(input.readLine());
		
		ArrayList<Integer>[] person = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			person[i] = new ArrayList<>();
		}
		
		String compare[] = input.readLine().split(" ");
		int a = Integer.parseInt(compare[0]);
		int b = Integer.parseInt(compare[1]);
		
		int K = Integer.parseInt(input.readLine());
		
		for(int i=0; i<K; i++) {
			String tc[] = input.readLine().split(" ");
			int x = Integer.parseInt(tc[0]);
			int y = Integer.parseInt(tc[1]);
			
			person[x].add(y);
			person[y].add(x);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean visit[] = new boolean[N+1];
		
		queue.offer(a);
		int depth = 1;	
		
		while(!queue.isEmpty()) {	
			int cycle = queue.size();
			
			while(cycle-- > 0) {
				int p = queue.poll();
				visit[p] = true;
				
				for(int n : person[p]) {
					if(n == b) {
						System.out.println(depth);
						return;
					}
					if(!visit[n]) queue.offer(n);
				}
			}		
			depth++;
		}
		
		System.out.println(-1);
	}
}
