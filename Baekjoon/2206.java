import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N, M;
	static char[][] map;
	static boolean visit[][][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String nm[] = input.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		map = new char[N][M];
		visit = new boolean[N][M][2];
		
		for(int i=0; i<N; i++) {
			map[i]=input.readLine().toCharArray();
		}
		
		int ans = bfs(0,0);
		
		System.out.println(ans);
	}

	private static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y,1});
		visit[x][y][0] = true;
		
		if(N==1 && M==1) return 1;
		
		int dis = 1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			dis++;
			
			while(size-- > 0) {
				int cur[] = queue.poll();
				
				for(int i=0; i<4; i++) {
					int nx = cur[0]+dx[i];
					int ny = cur[1]+dy[i];
					
					if(nx == N-1 && ny == M-1) return dis;
					
					if(rangeCheck(nx, ny)) {
						if(map[nx][ny] == '1') {
							if(cur[2] > 0) {	
								queue.offer(new int[] {nx, ny, 0});
							}
						}else {
							if(cur[2] == 1 && !visit[nx][ny][1]) {
								visit[nx][ny][1] = true;		
								queue.offer(new int[] {nx, ny, cur[2]});
							}else if(cur[2] == 0 && !visit[nx][ny][0]){
								visit[nx][ny][0] = true;
								queue.offer(new int[] {nx, ny, cur[2]});
							}						
						}
					}
				}
			}
		}
		
		return -1;
	}

	static boolean rangeCheck(int x, int y) {
		return x>-1 && y>-1 && x<N && y<M ? true : false;
	}
}
