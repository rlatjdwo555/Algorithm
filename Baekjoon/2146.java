import java.io.*;
import java.util.*;

public class Main {
	
	static int N, answer = Integer.MAX_VALUE;
	static int matrix[][];
	static boolean visit[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static Queue<Ship> queue = new LinkedList<>();
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(input.readLine());
		matrix = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String row[] = input.readLine().split(" ");
			for(int j=0; j<N; j++) {
				matrix[i][j] = Integer.parseInt(row[j]);
			}
		}
				
		/* 구역 분할 */
		int areaIndex = 1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j] && matrix[i][j] != 0) {
					divideArea(i, j, areaIndex++);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			Arrays.fill(visit[i], false);
		}
		
		ArrayList<Ship> ships = new ArrayList<>();
		
		/* 육지 인접 바다 좌표를 큐에 삽입 */
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(matrix[i][j] != 0) {
					for(int k=0; k<4; k++) {
						int x = i+dx[k];
						int y = j+dy[k];
						
						if(isPossible(x, y) && matrix[x][y] == 0) {
							ships.add(new Ship(x,y,matrix[i][j])); // 바다에 배를 띄우고 시작한다.
						}
					}
				}
			}
		}
		
		for(int i=1; i<areaIndex; i++) {
			for(Ship ship : ships) {
				if(ship.addr == i) {
					queue.add(ship);
					visit[ship.x][ship.y] = true;	
				}
			}
			
			bfs();
			queue.clear();
			
			for(int j=0; j<N; j++) {
				Arrays.fill(visit[j], false);
			}
		}
		
		System.out.println(answer);	
	}
	
	private static void bfs() {
		int length = 0;
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			while(size-- > 0) {
				Ship cur = queue.poll();
				
				if(matrix[cur.x][cur.y] != 0 && matrix[cur.x][cur.y] != cur.addr) {
					answer = Math.min(answer, length);
					return;
				}
				
				for(int i=0; i<4; i++) {
					int nx = cur.x+dx[i];
					int ny = cur.y+dy[i];
					
					if(isPossible(nx, ny) && matrix[nx][ny] != cur.addr) {
						visit[nx][ny] = true;
						queue.add(new Ship(nx, ny, cur.addr));
					}
				}
			}			
			length++;
		}
	}
	
	static void show() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}


	private static void divideArea(int x, int y, int k) {
		visit[x][y] = true;
		matrix[x][y] = k;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(isPossible(nx, ny) && matrix[nx][ny] != 0) {
				divideArea(nx, ny, k);
			}
		}
	}

	private static boolean isPossible(int x, int y) {
		return x<0 || y<0 || x>=N || y>=N || visit[x][y] ? false : true;
	}
	
	static class Ship{
		int x;
		int y;
		int addr;
		
		Ship(int x, int y, int addr){
			this.x = x;
			this.y = y;
			this.addr = addr;
		}
	}
}
