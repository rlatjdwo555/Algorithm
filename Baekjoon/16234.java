import java.io.*;
import java.util.*;

public class Main {
	
	static int N, L, R;
	static int matrix[][];
	static boolean visit[][];
	
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String tc[] = input.readLine().split(" ");
		N = Integer.parseInt(tc[0]);
		L = Integer.parseInt(tc[1]);
		R = Integer.parseInt(tc[2]);
		matrix = new int[N][N];
		visit = new boolean[N][N];
		
		int ans = 0;
		
		for(int i=0; i<N; i++){
			String row[] = input.readLine().split(" ");
			for(int j=0; j<N; j++){
				matrix[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		while(true){
			boolean exit = true;
			
			for(int r=0; r<N; r++){
				for(int c=0; c<N; c++){
					if(!visit[r][c]){
						if(union(r,c)){
							exit = false;
						}
					}
				}
			}
			
			for(int i=0; i<N; i++){
				Arrays.fill(visit[i], false);
			}
			
			if(exit) break;
			ans++;
		}
		
		System.out.println(ans);
	}

	static boolean union(int x, int y) {
		LinkedList<int[]> pos = new LinkedList<>();
		Queue<int[]> queue = new LinkedList<>();
		
		int sum = matrix[x][y];
		int area = 1;
		
		pos.add(new int[]{x, y});
		queue.add(new int[]{x, y});
		visit[x][y] = true;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			while(size-- > 0){
				int[] cur = queue.poll();
				
				for(int i=0; i<4; i++){
					int nx = cur[0]+dx[i];
					int ny = cur[1]+dy[i];
					
					if(check(nx, ny, cur[0], cur[1])){
						queue.add(new int[]{nx,ny});
						pos.add(new int[]{nx, ny});
						sum += matrix[nx][ny];
						area++;
						visit[nx][ny] = true;
					}
				}
			}
		}
		
		if(area == 1){
			return false;
		}
        
		int avg = sum / area;
		
		for(int[] p : pos){
			matrix[p[0]][p[1]] = avg;
		}
		
		return true;
	}

	static boolean check(int nx, int ny, int x, int y) {
		if(nx<0 || ny<0 || nx>=N || ny>=N || visit[nx][ny]){
			return false;
		}
		
		int dis = Math.abs(matrix[x][y]-matrix[nx][ny]);
		
		return dis >= L && dis <= R ? true : false;
	}
}
