import java.io.*;
import java.util.*;

public class 카카오2017_1_프렌즈4블록 {
	
	static char map[][];
	static boolean remove[][];
	
	static int dx[] = {0,0,1,1};
	static int dy[] = {0,1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int m = 6;
		int n = 6;
		String arr1[] = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
//		String arr2[] = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		int ans = solution(m, n, arr1);
 		System.out.println(ans);
	}
	
	static public int solution(int m, int n, String[] board) {
		int ans = 0;
		map = new char[m][n];
		remove = new boolean[m][n];
		boolean run = false;
		
		for(int i=0; i<m; i++){
			map[i] = board[i].toCharArray();
		}
		
		while(true){
			run = false;
			for(int i=0; i<m; i++){
				for(int j=0; j<n; j++){
					char c = map[i][j];
					if(c == ' ') continue;
					
					boolean isRemove = true;
					
					for(int k=1; k<4; k++){
						int nx = i+dx[k];
						int ny = j+dy[k];
						
						if(check(nx, ny, m , n, c, map)){
							isRemove = false;
							break;
						}
					}
					
					if(isRemove){
						run = true;
						for(int k=0; k<4; k++){
							int nx = i+dx[k];
							int ny = j+dy[k];
							
							remove[nx][ny] = true;
						}
					}
				}
			}
						
			if(!run) break;
		
			ans += removeBlock(m, n);
		}
		
		return ans;
	}
	
	static int removeBlock(int m, int n) {
		int cnt = 0;
		
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(remove[i][j]){
					map[i][j] = ' ';
					cnt++;
				}
			}
		}
		
		Queue<Character> queue = new LinkedList<>();
		
		for(int i=0; i<n; i++){
			for(int j=m-1; j>=0; j--){
				if(map[j][i] != ' '){
					queue.add(map[j][i]);
					map[j][i] = ' ';
				}
			}
			
			for(int j=m-1; j>=0; j--){
				if(queue.isEmpty()) break;
				map[j][i] = queue.poll();
			}
		}
		
		for(int i=0; i<m; i++){
			Arrays.fill(remove[i], false);
		}
		
		return cnt;
	}

	static boolean check(int x, int y, int m, int n, char c, char map[][]){
		return x < 0 || y < 0 || x >= m || y >= n || map[x][y] != c ? true : false;  
	}
}

