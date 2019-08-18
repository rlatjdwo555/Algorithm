import java.io.*;

public class Main {

	static int R, C;
	static int answer = Integer.MIN_VALUE;
	
	static int map[][];
	static int block[][][][] = new int[][][][] {
											{	// 작대기 모양
											{{0,0},{0,1},{0,2},{0,3}},
											{{0,0},{1,0},{2,0},{3,0}},
											},
											{	// ㄱㄴ 모양
											{{0,0},{0,1},{1,1},{1,2}},
											{{0,0},{-1,0},{-1,1},{-2,1}},
											},
											{	// ㄱㄴ 대칭 모양
											{{0,0},{0,-1},{1,-1},{1,-2}},
											{{0,0},{1,0},{1,1},{2,1}},
											},
											{	// ㄱ 모양
											{{0,0},{0,1},{0,2},{1,2}},
											{{0,0},{1,0},{2,0},{0,1}},
											{{0,0},{1,0},{1,1},{1,2}},
											{{0,0},{0,1},{-1,1},{-2,1}},
											},
											{	// ㄴ 모양
											{{0,0},{0,1},{0,2},{1,0}},
											{{0,0},{-1,0},{-2,0},{0,1}},
											{{0,0},{0,1},{0,2},{-1,2}},
											{{0,0},{0,1},{1,1},{2,1}},
											},
											{	// ㅜ 모양
											{{0,0},{0,1},{0,2},{1,1}},
											{{0,0},{0,1},{0,2},{-1,1}},
											{{0,0},{1,0},{2,0},{1,-1}},
											{{0,0},{1,0},{2,0},{1,1}},
											},
											{	// ㅁ 모양
											{{0,0},{0,1},{1,0},{1,1}}
											}
											};
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String mapSize[] = input.readLine().split(" ");
		R = Integer.parseInt(mapSize[0]);
		C = Integer.parseInt(mapSize[1]);
		
		map = new int[R][C];
		
		for(int r=0; r<R; r++) {
			String row[] = input.readLine().split(" ");
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(row[c]);
			}
		}
					
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				setBlock(r, c);
			}
		}
		
		System.out.println(answer);
	}

	private static void setBlock(int r, int c) {
		int totalBlock = block.length;
		
		for(int type=0; type<totalBlock; type++) {
			for(int direction=0; direction<block[type].length; direction++) {
				boolean isPossible = true;
				int score = 0;
				
				for(int pos=0; pos<block[type][direction].length; pos++) {
					int dot[] = block[type][direction][pos];
					
					int nx = r+dot[0];
					int ny = c+dot[1];
					
					if(!rangeCheck(nx, ny)) {
						isPossible = false;
						break;
					}
					
					score+=map[nx][ny];
				}
				
				if(isPossible) {
					answer = Math.max(answer, score);
				}
			}
		}
	}

	private static boolean rangeCheck(int x, int y) {
		return x>=0 && y>=0 && x<R && y<C ? true : false;
	}	
}