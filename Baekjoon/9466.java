import java.io.*;

public class Main {	
	
	static int N, ans;
	static int arr[];
	static boolean visit[];
	static boolean notCycle[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(input.readLine());
		
		while(T-- > 0) {
			N = Integer.parseInt(input.readLine());			 
			arr = new int[N];
			visit = new boolean[N];
			notCycle = new boolean[N];
			ans = 0;
			
			String tc[] = input.readLine().split(" ");
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(tc[i])-1;
			}
			
			for(int i=0; i<N; i++) {
				if(visit[i]) continue; 	
				
				visit[i] = true;
				
				if(!dfs(arr[i], i, 1)) {
					visit[i] = false;
					notCycle[i] = true;
				}
			}
			
			output.write(N-ans+"\n");	
		}
		output.flush();
	}

	private static boolean dfs(int cur, int start, int count) {
		if(notCycle[cur]) return false;
		
		if(visit[cur]) {
			if(cur == start) {
				ans += count;
				return true;
			}else {
				return false;
			}
		}

		visit[cur] = true;
		
		if(dfs(arr[cur], start, count+1)) {
			return true;
		}
		
		visit[cur] = false;
		
		return false;
	}
}
