import java.io.*;

public class Main {
	
	static int R, C;
	static char map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String rc[] = input.readLine().split(" ");
		R = Integer.parseInt(rc[0]);
		C = Integer.parseInt(rc[1]);
		
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			map[i] = input.readLine().toCharArray();
		}
		
		boolean find = false;
		int pos[] = new int[2];
		char ans = '.';
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == '.') {
					char result = ansCheck(i, j);
					
					if(result != 'X') {
						ans = result;
						pos[0] = i+1;
						pos[1] = j+1;
						find = true;
						break;
					}
				}
			}	
			if(find) break;
		}

		System.out.printf("%d %d %c\n", pos[0], pos[1], ans);
	}
	
	// 상하좌우로 이동 가능 여부를 체크
	private static char ansCheck(int r, int c) {
		boolean top = r-1 > -1 && (map[r-1][c] == '|' 
				|| map[r-1][c] == '+'
				|| map[r-1][c] == '1'
				|| map[r-1][c] == '4') ? true : false;
		
		boolean bottom = r+1 < R && (map[r+1][c] == '|'
				|| map[r+1][c] == '+'
				|| map[r+1][c] == '2'
				|| map[r+1][c] == '3') ? true : false;
				
		boolean left = c-1 > -1 && (map[r][c-1] == '-' 
				|| map[r][c-1] == '+'
				|| map[r][c-1] == '1'
				|| map[r][c-1] == '2') ? true : false;
		
		boolean right = c+1 < C && (map[r][c+1] == '-'
				|| map[r][c+1] == '+'
				|| map[r][c+1] == '3'
				|| map[r][c+1] == '4') ? true : false;
				
		
		if(top && bottom && left && right) return '+';
		else if(top && bottom) return '|';
		else if(left && right) return '-';
		else if(right && bottom) return '1';
		else if(top && right) return '2';
		else if(top && left) return '3';
		else if(left && bottom) return '4';
		
		return 'X';
	}
}
