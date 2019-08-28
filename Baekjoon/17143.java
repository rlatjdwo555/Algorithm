import java.io.*;
import java.util.*;

public class Main {
	
	static LinkedList<int[]> sharks = new LinkedList<>();
	static Shark[][] map;
	static int R, C, M, ans;
	
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String rcm[] = input.readLine().split(" ");
		R = Integer.parseInt(rcm[0]);
		C = Integer.parseInt(rcm[1]);
		M = Integer.parseInt(rcm[2]);
		map = new Shark[R][C];
		
		while(M-- > 0){
			String info[] = input.readLine().split(" ");
			int r = Integer.parseInt(info[0])-1;
			int c = Integer.parseInt(info[1])-1;
			map[r][c] = new Shark(Integer.parseInt(info[2]),
								  Integer.parseInt(info[3]),
								  Integer.parseInt(info[4]));
		}

		for(int i=0; i<C; i++){
			getShark(i);
			sharks.clear();
			
			for(int r=0; r<R; r++){
				for(int c=0; c<C; c++){
					if(map[r][c] != null){
						sharks.add(new int[]{r,c});
					}
				}
			}
			
			moveShark();
		}
		
		System.out.println(ans);
	}

	private static void moveShark() {
		Shark[][] tmp = new Shark[R][C];
				
		for(int[] pos : sharks){
			int r = pos[0], c = pos[1];
			Shark cur = map[r][c];
			
			int range = cur.d < 3 ? cur.s % (R-1 << 1) : cur.s % (C-1 << 1);
			int nextR=0, nextC=0;
			boolean reverse = false;
			
			switch (cur.d){
			case 1 : case 2: 
				nextC = c;
				reverse =  cur.d == 1 ? false : true;
				for(int i=0; i<range; i++){
					if(r == 0) reverse = true;
					else if(r == R-1) reverse = false;
					r += reverse ? 1 : -1;
				}
				nextR = r;
				cur.d = reverse ? 2 : 1;
				break;
			case 3 : case 4 : 
				reverse = cur.d == 3 ? true : false;
				nextR = r;
				for(int i=0; i<range; i++){
					if(c == 0) reverse = true;
					else if(c == C-1) reverse = false;
					c += reverse ? 1 : -1;
				}
				cur.d = reverse ? 3 : 4;
				nextC = c;
				break;
			}
						
			if(tmp[nextR][nextC] == null || tmp[nextR][nextC].z < cur.z){
				tmp[nextR][nextC] = cur;
			}
		}
		
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				map[i][j] = tmp[i][j];
			}
		}
		
	}

	private static void getShark(int col) {
		for(int row=0; row<R; row++){
			if(map[row][col] != null){
				ans += map[row][col].z;
				map[row][col] = null;
				return;
			}
		}
	}
}

class Shark{
	int s;
	int d;
	int z;
	
	Shark(int s, int d, int z){
		this.s = s;
		this.d = d;
		this.z = z;
	}
}
