import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K, ans;
	static int map[][];
	static boolean visit[][];
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	static ArrayList<int[]> edge = new ArrayList<>();
	static int link[];
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String nm[] = input.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++){
			String row[] = input.readLine().split(" ");
			for(int j=0; j<M; j++){
				map[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		// 섬에 번호 부여
		int no = 2;
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(map[i][j] == 1){
					dfs(i, j, no++);
				}
			}
		}
				
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(map[i][j] > 1){
					for(int k=0; k<4; k++){
						int nx = i+dx[k];
						int ny = j+dy[k];
						
						if(rangeCheck(nx, ny) && map[nx][ny] == 0){
							setBridge(nx, ny, map[i][j], k);
						}
					}
				}
			}
		}
		
		Collections.sort(edge, new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		K = no;
		link = new int[K+1];
		for(int i=0; i<K; i++){
			link[i] = i;
		}
		
		for(int e[] : edge){
			unionSet(e);
		}
		
		for(int i=2; i<K; i++){
			findSet(i);
		}
		
		int root = link[2];
		
		for(int i=3; i<K; i++){
			if(link[i] != root){
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(ans);
	}
	
	static int findSet(int x){
		if(link[x] == x){
			return x;
		}
		
		link[x] = findSet(link[x]);
		return link[x];
	}
	
	static void unionSet(int[] e){
		int rootA = findSet(e[0]);
		int rootB = findSet(e[1]);
		
		if(rootA == rootB) return;
		
		ans += e[2];
		link[rootA] = rootB;
	}
	
	// 상, 하, 좌, 우
	static void setBridge(int nx, int ny, int no, int d) {
		int dis = 0;
		int cur = 0;
				
		switch(d){
		case 0 : 
			for(int r=nx-1; r>=0; r--){
				dis++;
				cur = map[r][ny];
				if(cur > 1){
					break;
				}
			}
			break;
		case 1 : 
			for(int r=nx+1; r<N; r++){
				dis++;
				cur = map[r][ny];
				if(cur > 1){
					break;
				}
			}
			break;
		case 2 : 
			for(int c=ny-1; c>=0; c--){
				dis++;
				cur = map[nx][c];
				if(cur > 1){
					break;
				}
			}
			break;
		case 3 : 
			for(int c=ny+1; c<M; c++){
				dis++;
				cur = map[nx][c];
				if(cur > 1){
					break;
				}
			}
			break;
		}
		
		if(cur > 0 && cur != no && dis > 1){
			edge.add(new int[]{no, cur, dis});
		}
	}

	static void dfs(int x, int y, int no) {
		visit[x][y] = true;
		map[x][y] = no;
		
		for(int i=0; i<4; i++){
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(rangeCheck(nx, ny) && !visit[nx][ny] && map[nx][ny] == 1){
				dfs(nx, ny, no);
			}
		}
	}
	
	static boolean rangeCheck(int nx, int ny){
		return nx>=0 && ny>=0 && nx<N && ny<M ? true : false;
	}
}
