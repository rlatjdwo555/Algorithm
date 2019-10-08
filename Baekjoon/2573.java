import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int matrix[][];
	static boolean visit[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String size[] = input.readLine().split(" ");
		N = Integer.parseInt(size[0]);
		M = Integer.parseInt(size[1]);
		
		matrix = new int[N][M];
		visit = new boolean[N][M];
		Queue<Dot> queue = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			String row[] = input.readLine().split(" ");
			for(int j=0; j<M; j++) {
				int n = Integer.parseInt(row[j]);
				
				matrix[i][j] = n;
				if(n != 0) queue.add(new Dot(i, j));
			}
		}
		
		int answer = 0;
		
		while(!queue.isEmpty()) {
			if(checkDetach()) break;
			
			initVisit();
			answer++;	
			int queueSize = queue.size();
			
			int backup[][] = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					backup[i][j] = matrix[i][j];
				}
			}
			
			while(queueSize-- > 0) {
				Dot cur = queue.poll();
				
				int h = matrix[cur.x][cur.y];
				int sea = 0;
				
				for(int i=0; i<4; i++) {
					int nx = cur.x+dx[i];
					int ny = cur.y+dy[i];
					
					if(backup[nx][ny] == 0) sea++;
				}
				
				matrix[cur.x][cur.y] = h-sea < 1 ? 0 : h-sea;
				
				if(matrix[cur.x][cur.y] > 0) queue.offer(cur);
			}
		}
		
		if(queue.isEmpty()) {	
			answer = 0;
		}
		
		System.out.println(answer);
		
	}

	static void initVisit() {
		for(int i=0; i<N; i++) {
			Arrays.fill(visit[i], false);
		}
	}

	static boolean checkDetach() {
		boolean check = false;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(matrix[i][j] != 0 && !visit[i][j]) {
					if(check) {
						return true;
					}
		
					dfs(i, j);
					check = true;
				}
			}
		}
		
		return false;
	}
	
	

	static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(isPossible(nx, ny)) {
				dfs(nx, ny);
			}
		}
	}
	
	
	static boolean isPossible(int nx, int ny) {
		if(nx>-1 && ny>-1 && nx<N && ny<M && matrix[nx][ny] != 0 && !visit[nx][ny]) {
			return true;
		}
		
		return false;
	}

	static class Dot{
		int x;
		int y;
		
		Dot(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
