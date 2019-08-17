import java.io.*;
import java.util.LinkedList;

public class Main {
	
	static int N, M, K, ans = Integer.MAX_VALUE;
	static int map[][];
	static int tmp[];
	static boolean visit[];
	static LinkedList<int[]> centers = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String tc[] = input.readLine().split(" ");
		N = Integer.parseInt(tc[0]);
		M = Integer.parseInt(tc[1]);
		K = Integer.parseInt(tc[2]);
		map = new int[N][M];
		tmp = new int[K];
		visit = new boolean[K];
		
		for(int i=0; i<N; i++) {
			String row[] = input.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		for(int i=0; i<K; i++) {
			String pos[] = input.readLine().split(" ");
			centers.add(new int[] {Integer.parseInt(pos[0])-1,
								   Integer.parseInt(pos[1])-1,
								   Integer.parseInt(pos[2])});
		}
			
		combi(0);
		System.out.println(ans);
	}
	
	static void combi(int idx) {
		if(idx == K) {
			int copy[][] = new int[N][M];
			copyMap(map, copy);
			
			for(int i=0; i<K; i++) {
				int cur[] = centers.get(tmp[i]);
				rotate(cur[0], cur[1], cur[2]);
			}
			
			for(int i=0; i<N; i++) {
				int sum = 0;
				for(int j=0; j<M; j++) {
					sum += map[i][j];
				}
				ans = Math.min(ans, sum);
			}
			
			copyMap(copy, map);
			return;
		}
		
		for(int i=0; i<K; i++) {
			if(!visit[i]) {
				tmp[idx] = i;
				visit[i] = true;
				combi(idx+1);
				visit[i] = false;
			}
		}
	}

	static void copyMap(int[][] origin, int[][] copy) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j] = origin[i][j];
			}
		}
	}

	static void rotate(int row, int col, int area) {
		LinkedList<Integer> values = new LinkedList<>();
		
		for(int k=1; k<=area; k++) {
			// 좌상단 >
			for(int y=col-k; y<=col+k; y++) {
				values.add(map[row-k][y]);
			}
			
			// 우상단 v
			for(int x=row-k+1; x<=row+k; x++) {
				values.add(map[x][col+k]);
			}
			
			// 우하단 <
			for(int y=col+k-1; y>=col-k; y--) {
				values.add(map[row+k][y]);
			}
			
			// 우하단 ^
			for(int x=row+k-1; x>row-k; x--) {
				values.add(map[x][col-k]);
			}
			
			values.addFirst(values.pollLast());
			
			// 좌상단 >
			for(int y=col-k; y<=col+k; y++) {
				map[row-k][y] = values.pollFirst();
			}
			
			// 우상단 v
			for(int x=row-k+1; x<=row+k; x++) {
				map[x][col+k] = values.pollFirst();
			}
			
			// 우하단 <
			for(int y=col+k-1; y>=col-k; y--) {
				map[row+k][y] = values.pollFirst();
			}
			
			// 우하단 ^
			for(int x=row+k-1; x>row-k; x--) {
				map[x][col-k] = values.pollFirst();
			}
		}
	}
}
