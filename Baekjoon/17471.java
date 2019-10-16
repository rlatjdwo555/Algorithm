import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, ans = -1;
	static ArrayList<Integer>[] graph = new ArrayList[10];
	static boolean use[];
	static int nums[];
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		nums = new int[N];
		use = new boolean[N];
		
		String tc[] = input.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<>();
			nums[i] = Integer.parseInt(tc[i]);
		}
		
		for(int i=0; i<N; i++) {
			String info[] = input.readLine().split(" ");
			
			int k = Integer.parseInt(info[0]);
			
			for(int j=1; j<=k; j++) {
				graph[i].add(Integer.parseInt(info[j])-1);
			}
		}
		
		for(int i=1; i<=N/2; i++) {
			M = i;
			combi(0, 0);
		}
		
		System.out.println(ans);
	}

	static void combi(int idx, int start) {
		if(idx == M) {
			int A[] = new int[M];
			int B[] = new int[N-M];
			int idxA = 0;
			int idxB = 0;
			int sumA = 0;
			int sumB = 0;
			
			for(int i=0; i<N; i++) {
				if(use[i]) {
					A[idxA++] = i;
					sumA += nums[i];
				}else {
					B[idxB++] = i;
					sumB += nums[i];
				}
			}
						
			if(isLink(A) && isLink(B)) {
				ans = ans == -1 ? Math.abs(sumA-sumB) : Math.min(ans, Math.abs(sumA-sumB));
			}
			
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(!use[i]) {
				use[i] = true;
				combi(idx+1, i+1);
				use[i] = false;
			}
		}
	}

	static boolean isLink(int[] arr) {
		HashSet<Integer> hs = new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			hs.add(arr[i]);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean visit[] = new boolean[N];
		
		int start = arr[0];
		queue.add(start);
		visit[start] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-- > 0) {
				int cur = queue.poll();
				
				for(int next : graph[cur]) {
					if(!visit[next] && hs.contains(next)) {
						queue.add(next);
						visit[next] = true;
					}
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!visit[arr[i]]) {
				return false;
			}
		}
		
		return true;
	}
}
