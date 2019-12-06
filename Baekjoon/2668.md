import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer> ans = new ArrayList<>();
	static int numbers[], N;
	static boolean visit[];
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(input.readLine());
		numbers = new int[N+1];
		visit = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			numbers[i] = Integer.parseInt(input.readLine());
		}
		
		for(int i=1; i<=N; i++) {
			if(i == numbers[i]) ans.add(i);
			else if(!ans.contains(i)){
				visit[i] = true;
				if(dfs(i, numbers[i])) {
					ans.add(i);
				}
			}
			
			Arrays.fill(visit, false);
		}
		
		Collections.sort(ans);
		
		StringBuilder sb = new StringBuilder();
		sb.append(ans.size()+"\n");
		
		for(int n : ans) {
			sb.append(n+"\n");
		}
		
		System.out.println(sb.toString());
	}

	private static boolean dfs(int start, int here) {
		if(visit[here]) {
			if(here == start) {
				return true;
			}	
			return false;
		}
		
		visit[here] = true;
		if(dfs(start, numbers[here])) {
			ans.add(here);
			return true;
		}
		
		return false;
	}
}
