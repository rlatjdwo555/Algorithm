import java.io.*;
import java.util.ArrayList;

public class Main {
	
	static int map[][] = new int[10][10];
	static int ans = Integer.MAX_VALUE, dotSize;
	static int useCount[] = new int[5];
	
	static ArrayList<int[]> dots = new ArrayList<>();
	static final int SIZE = 10;
	
	public static void main(String[] args) throws IOException {		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<SIZE; i++) {
			String row[] = input.readLine().split(" ");
			for(int j=0; j<SIZE; j++) {
				map[i][j] = Integer.parseInt(row[j]);
				
				if(map[i][j] == 1) {
					dots.add(new int[] {i, j});
				}
			}
		}
		
		dotSize = dots.size();
		
		simul(0, 0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	static void simul(int d, int cnt) {
		if(d == dotSize) {
			ans = ans < cnt ? ans : cnt;
			return;
		}
		
		if(cnt > ans) {
			return;
		}
			
		int cur[] = dots.get(d);
		int x = cur[0];
		int y = cur[1];
		
		if(map[x][y] == 2) {
			simul(d+1, cnt);
		}
			
		for(int i=0; i<5; i++) {
			if(useCount[i] < 5 && isPossible(cur, i)) {
				useCount[i]++;
				simul(d+1, cnt+1);
				
				paint(x, y, i, false);
				useCount[i]--;
			}
		}	
	}

	static boolean isPossible(int[] cur, int type) {
		int x = cur[0];
		int y = cur[1];
		
		for(int i=x; i<=x+type; i++) {
			for(int j=y; j<=y+type; j++) {
				if(i==SIZE || j==SIZE || map[i][j] != 1) {
					return false;
				}
			}
		}
			
		paint(x, y, type, true);	
		return true;
	}

	static void paint(int x, int y, int range, boolean flag) {
		for(int i=x; i<=x+range; i++) {
			for(int j=y; j<=y+range; j++) {
				map[i][j] = flag ? 2 : 1;
			}
		}
	}
}
