import java.io.*;
import java.util.*;

public class Main {
	
	static int dx[] = {0,0,-1,1,0,0};
	static int dy[] = {-1,1,0,0,0,0};
	static int dz[] = {0,0,0,0,1,-1};
	
	static int L, R, C;
	static char map[][][];
	static boolean visit[][][];
	static int me[] = null, exit[] = null;
		
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		

		
		while(true) {
			String mapSize[] = input.readLine().split(" ");		
			L = Integer.parseInt(mapSize[0]);
			R = Integer.parseInt(mapSize[1]);
			C = Integer.parseInt(mapSize[2]);
			
			if(L == 0 && R == 0 && C == 0) {
				break;
			}
			
			map = new char[R][C][L];
			visit = new boolean[R][C][L];
			me = null; exit = null;
			
			for(int l=0; l<L; l++) {
				for(int r=0; r<R; r++) {
					char row[] = input.readLine().toCharArray();
					for(int c=0; c<C; c++) {
						map[r][c][l] = row[c];
						
						if(row[c] == 'S') {
							me = new int[] {r,c,l};
						}else if(row[c] == 'E') {
							exit = new int[]{r,c,l};
						}
					}
				}
				input.readLine();
			}
			
			if(me == null || exit == null) {
				output.write("Trapped!\n");
				continue;
			}
			
			int answer = escape();
			output.write(answer < 1 ? "Trapped!\n" : "Escaped in "+answer+" minute(s).\n");
		}
		
		output.flush();
	}
	
	static int escape() {	
		Queue<int[]> queue = new LinkedList<>();
		queue.add(me);
		visit[me[0]][me[1]][me[2]] = true;
		
		int time = 0;
		
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			time++;
			
			while(queueSize-- > 0) {
				int cur[] = queue.poll();
				
				for(int i=0; i<6; i++) {
					int nx = cur[0] + dx[i];
					int ny = cur[1] + dy[i];
					int nz = cur[2] + dz[i];
											
					if(rangeCheck(nx, ny, nz)) {
						if(nx == exit[0] && ny == exit[1] && nz == exit[2]) {
							return time;
						}
						
						queue.add(new int[] {nx, ny, nz});
						visit[nx][ny][nz] = true;
					}
				}
			}
		}
		
		return -1;
	}

	static boolean rangeCheck(int nx, int ny, int nz) {
		return nx>=0 && ny>=0 && nz>=0 && nx<R && ny<C && nz<L && !visit[nx][ny][nz] &&
				map[nx][ny][nz] != '#' ? true : false;
	}
}
