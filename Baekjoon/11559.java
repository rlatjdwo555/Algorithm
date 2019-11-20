import java.io.*;
import java.util.*;

public class Main {

	static final int ROW_SIZE = 12, COL_SIZE = 6;
	static char[][] map = new char[ROW_SIZE][COL_SIZE];
	static boolean visit[][] = new boolean[ROW_SIZE][COL_SIZE];
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	static int ans, depth;
	
	public static void main(String[] args) throws IOException {		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<12; i++) {
			map[i] = input.readLine().toCharArray();
		}
		
		boolean bomb = true;
		
		while(bomb) {
			bomb = false;
			
			// 터뜨릴 뿌요 찾고 터뜨림
			for(int row=0; row<ROW_SIZE; row++) {
				for(int col=0; col<COL_SIZE; col++) {
					char color = map[row][col];
					depth = 1;
					
					if(Character.isAlphabetic(color)) {
						find(color, row, col);
						
						if(depth >= 4) {
							bomb = true;
							visitInit();

							remove(color, row, col);
						}
						
						visitInit();
					}
				}
			}
			
			// 중력 작용
			if(bomb) {
				ans++;  
				rearrange();
			}
		}
		
		System.out.println(ans);
	}
    
	private static void visitInit() {
		for(int i=0; i<ROW_SIZE; i++) {
			Arrays.fill(visit[i], false);
		}
	}

	private static void rearrange() {
		Queue<Character> queue = new LinkedList<>();
		
		for(int col=0; col<COL_SIZE; col++) {
			for(int row=ROW_SIZE-1; row>=0; row--) {
				char v = map[row][col];
				if( v != '.') {
					queue.add(v);
				}
			}
			
			for(int row=ROW_SIZE-1; row>=0; row--) {
				if(!queue.isEmpty()) {
					map[row][col] = queue.poll();
				}else {
					map[row][col] = '.';
				}
			}
		}
	}

	private static void find(char color, int r, int c) {
		visit[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int nx = r+dx[i];
			int ny = c+dy[i];
			
			if(check(nx, ny, color)) {
				depth++;
				find(color, nx, ny);
			}
		}
	}
	
	private static void remove(char color, int r, int c) {
		visit[r][c] = true;
		map[r][c] = '.';
		
		for(int i=0; i<4; i++) {
			int nx = r+dx[i];
			int ny = c+dy[i];
			
			if(check(nx, ny, color)) {
				remove(color, nx, ny);
			}
		}
	}

	private static boolean check(int nx, int ny, char color) {
		return nx<0 || ny<0 || nx>=ROW_SIZE || ny>=COL_SIZE || map[nx][ny] != color || visit[nx][ny] ? false : true;
	}
}
