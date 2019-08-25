import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static boolean ans;
	static int map[][] = new int[9][9];
	static ArrayList<Pos> pos = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			StringTokenizer token = new StringTokenizer(input.readLine());
			for(int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
				if(map[i][j] == 0) {
					pos.add(new Pos(i,j));
					N++;
				}
			}
		}
		
		// 숫자 들어갈 수 있는 경우의 수
		for(Pos p : pos) {
			boolean digit[] = new boolean[10];
			
			// 행 검사
			for(int i=0; i<9; i++) {
				if(map[p.x][i] == 0 || digit[map[p.x][i]]) continue;
				digit[map[p.x][i]] = true;
			}
			
			// 열 검사
			for(int i=0; i<9; i++) {
				if(map[i][p.y] == 0 || digit[map[i][p.y]]) continue;
				digit[map[i][p.y]] = true;
			}
			
			// 들어갈 수 있는 숫자 selects
			for(int i=1; i<10; i++) {
				if(!digit[i]) p.ans.add(i);
			}
		}
			
		dfs(0);	
	}
	
	private static void dfs(int d) {
		if(d == N) {
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(map[i][j]+" ");
				}
				sb.append("\n");
			}
			
			System.out.println(sb);
			ans = true;		
			return;
		}
		
		Pos cur = pos.get(d);
		
		for(int n : cur.ans) {
			if(check(cur.x, cur.y, n)) {
				map[cur.x][cur.y] = n;
				dfs(d+1);
				
				if(ans) return;
				map[cur.x][cur.y] = 0; 
			}
		}
	}

	private static boolean check(int x, int y, int n) {
		for(int i=0; i<9; i++) {
			if(y != i && map[x][i] == n) return false;
			if(x != i && map[i][y] == n) return false;
		}
		
		int row = x/3*3;
		int col = y/3*3;
		
		for(int i=row; i<row+3; i++) {
			for(int j=col; j<col+3; j++) {
				if(x!=i && y!=j && map[i][j] == n) return false;
			}
		}
		
		return true;
	}

	static class Pos{
		int x;
		int y;
		ArrayList<Integer> ans = new ArrayList<>();
		
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
  