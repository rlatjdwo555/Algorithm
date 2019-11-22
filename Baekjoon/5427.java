import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C, ans;
	static char[][] map;
	static Queue<int[]> fire = new LinkedList<>();
	static Queue<int[]> player = new LinkedList<>();
	static boolean[][] visit;
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(input.readLine());
		
		while(T-- > 0) {
			String rc[] = input.readLine().split(" ");
			R = Integer.parseInt(rc[1]);
			C = Integer.parseInt(rc[0]);
			map = new char[R][C];
			visit = new boolean[R][C];
			ans = 0;
			
			int start[] = new int[2];
			
			for(int i=0; i<R; i++) {
				char row[] = input.readLine().toCharArray();
				for(int j=0; j<C; j++) {
					map[i][j] = row[j];
					
					if(row[j] == '@') {
						start[0] = i;
						start[1] = j;
						map[i][j] = '.';
						visit[i][j] = true;
						player.add(new int[] {i,j});
					}else if(row[j] == '*') {
						fire.add(new int[] {i, j});
					}
				}
			}
				
			int ans = escape();
			
			sb.append(ans > 0 ? ans : "IMPOSSIBLE");
			sb.append("\n");
			
			fire.clear();
			player.clear();
		}
		
		System.out.println(sb);
	}

	static int escape() {
		int time = 0;
		
		while(!player.isEmpty()) {
			time++;
			
			if(!fire.isEmpty()) {
				spreadFire();
			}
			
			if(run()) return time;		
		}
		
		return -1;
	}

	static boolean run() {
		int size = player.size();
		
		while(size-- > 0) {
			int cur[] = player.poll();
			
			if(cur[0] == 0 || cur[0] == R-1 || cur[1] == 0 || cur[1] == C-1) {
				return true;
			}
			
			for(int i=0; i<4; i++) {
				int nx = cur[0]+dx[i];
				int ny = cur[1]+dy[i];
				
				if(rangeCheck(nx, ny) && !visit[nx][ny]) {
					visit[nx][ny] = true;
					player.add(new int[] {nx, ny});
				}
			}
		}
		
		return false;
	}

	static void spreadFire() {
		int size = fire.size();
		
		while(size-- > 0) {
			int cur[] = fire.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur[0]+dx[i];
				int ny = cur[1]+dy[i];
				
				if(rangeCheck(nx, ny)) {
					map[nx][ny] = '*';
					fire.add(new int[] {nx, ny});
				}
			}
		}
	}

	static boolean rangeCheck(int x, int y) {
		return x>-1 && y>-1 && x<R && y<C && map[x][y] == '.' ? true : false;
	}
}
