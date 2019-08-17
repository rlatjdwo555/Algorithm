import java.io.*;

public class Main {
	
	static int N, ans;
	static int map[][];
	static int dx[] = {0,1,1}; // 우측 / 대각선/ 하단
	static int dy[] = {1,1,0};

	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String row[] = input.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		move(0,1,0);
		System.out.println(ans);
	}

	private static void move(int x, int y, int flag) {
		if(x == N-1 && y == N-1) {
			ans++;
			return;
		}
		
		// 0 : 우측 , 1: 대각선, 2: 하단
		if(flag == 0) {
			for(int i=0; i<2; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(rightRange(nx, ny)) {
					if(i==1) {	// 대각선이면 추가 칸 검사
						if(map[x][y+1] == 0 && map[x+1][y] == 0) {
							move(nx, ny, 1);
						}
					}else {
						move(nx, ny, 0);
					}
				}
			}
		}else if(flag == 1) {
			for(int i=0; i<3; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(rightRange(nx, ny)) {
					if(i==1) {	// 대각선이면 추가 칸 검사
						if(map[x][y+1] == 0 && map[x+1][y] == 0) {
							move(nx, ny, 1);
						}
					}else if(i == 0){
						move(nx, ny, 0);
					}else {
						move(nx, ny, 2);
					}
				}
			}
		}else {
			for(int i=1; i<3; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(rightRange(nx, ny)) {
					if(i==1) {	// 대각선이면 추가 칸 검사
						if(map[x][y+1] == 0 && map[x+1][y] == 0) {
							move(nx, ny, 1);
						}
					}else {
						move(nx, ny, 2);
					}
				}
			}
		}
	}

	private static boolean rightRange(int x, int y) {
		return x>-1 && y>-1 && x<N && y<N && map[x][y] == 0? true : false;
	}
}
