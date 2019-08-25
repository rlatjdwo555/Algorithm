import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N, L, ans;
	static int map[][];
	static boolean visit[][];
	
	// 현재보다 내리막이면 앞을 보고 오르막이면 뒤를 검사한다.
	// visit으로 경사놨는지 여부 체크, 열체크 -> 행체크 넘어갈 때 초기화 필요
	
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String nl[] = input.readLine().split(" ");
		N = Integer.parseInt(nl[0]);
		L = Integer.parseInt(nl[1]);
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String row[] = input.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		// 행 검사
		for(int row=0; row<N; row++) {
			boolean isOk = true;
			
			for(int col=0; col<N-1; col++) {
				int cur = map[row][col];
				int next = map[row][col+1];
				
				if(cur < next) {
					if(Math.abs(cur-next) > 1 || !checkBackward(row, col, cur, true)) {
						isOk = false; break;
					}
				}
				else if(cur > next) {
					if(Math.abs(cur-next) > 1 || !checkForward(row, col+1, next, true)) {
						isOk = false; break;
					}
					col += L-1;
				}
			}
			
			if(isOk) {
				ans++;
			}
		} 
		
		for(int i=0; i<N; i++) {
			Arrays.fill(visit[i], false);
		}
		
		// 열 검사
		for(int col=0; col<N; col++) {
			boolean isOk = true;
			
			for(int row=0; row<N-1; row++) {
				int cur = map[row][col];
				int next = map[row+1][col];
				
				if(cur < next) {
					if(Math.abs(cur-next) > 1 || !checkBackward(row, col, cur, false)) {
						isOk = false; break;
					}
				}
				else if(cur > next) {
					if(Math.abs(cur-next) > 1 || !checkForward(row+1, col, next, false)) {
						isOk = false; break;
					}
					row += L-1;
				}
			}
			
			if(isOk) {
				ans++;
			}
		} 
		
		System.out.println(ans);
	}

	// direction=true(행) , false(열)
	private static boolean checkForward(int row, int col, int h, boolean direction) {
		if(direction) {	
			if(col+L-1 >= N) {   // 경사가 맵의 범위를 벗어나면
				return false;
			}
			
			for(int dis=0; dis<L; dis++) {
				if(map[row][col] != h || visit[row][col]) {		// 지형 높낮이가 다르거나 이미 경사를 놨던 부분이면
					return false;
				}
				visit[row][col++] = true;
			}
		}
		else {
			if(row+L-1 >= N) {
				return false;
			}
			
			for(int dis=0; dis<L; dis++) {
				if(map[row][col] != h || visit[row][col]) {	
					return false;
				}
				visit[row++][col] = true;
			}
		}
		
		return true;
	}

	private static boolean checkBackward(int row, int col, int h, boolean direction) {
		if(direction) {	
			if(col-L+1 < 0) {   // 경사가 맵의 범위를 벗어나면
				return false;
			}
			
			for(int dis=0; dis<L; dis++) {
				if(map[row][col] != h || visit[row][col]) {		// 지형 높낮이가 다르거나 이미 경사를 놨던 부분이면
					return false;
				}
				visit[row][col--] = true;
			}
		}
		else {
			if(row-L+1 < 0) {
				return false;
			}
			
			for(int dis=0; dis<L; dis++) {
				if(map[row][col] != h || visit[row][col]) {	
					return false;
				}
				visit[row--][col] = true;
			}
		}
		
		return true;
	}
}
