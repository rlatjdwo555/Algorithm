import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static ArrayList<int[]> virus = new ArrayList<>();
	static int N, M, ans=Integer.MAX_VALUE;
	static int map[][];
	static int backupMap[][];
	static int combi[];
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {-1,1,0,0};
	
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        String tc[] = input.readLine().split(" ");
        N = Integer.parseInt(tc[0]);
        M = Integer.parseInt(tc[1]);
        map = new int[N][N];
        backupMap = new int[N][N];
        combi = new int[M];
        
        for(int row=0; row<N; row++) {
        	String values[] = input.readLine().split(" ");
        	
        	for(int col=0; col<N; col++) {
        		int value = Integer.parseInt(values[col]); 
     		
        		map[row][col] = value;
        		
        		if(value == 2) {
        			virus.add(new int[] {row, col});
        			map[row][col] = 0;
        		}
        	}
        }
        
        go(0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

	private static void go(int idx, int start) {
		if(idx == M) {
			Queue<int[]> spread = new LinkedList<>();
			
			backup(map, backupMap);
			
			for(int i=0; i<M; i++) {
				int dot[] = virus.get(combi[i]);
				map[dot[0]][dot[1]] = 2;
				spread.add(dot);
			}
			
			simul(spread);
			backup(backupMap, map);
			return;
		}
		
		for(int i=start; i<virus.size(); i++) {
			combi[idx] = i;
			go(idx+1, i+1);
		}
	}

	private static void backup(int[][] origin, int[][] back) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				back[i][j] = origin[i][j];
			}
		}
	}

	private static void simul(Queue<int[]> spread) {
		int time = -1;
		
		while(!spread.isEmpty()) {
			time++;
			int size = spread.size();
			
			while(size-- > 0) {
				int cur[] = spread.poll();
				
				for(int i=0; i<4; i++) {
					int nx = cur[0]+dx[i];
					int ny = cur[1]+dy[i];
					
					if(rangeCheck(nx, ny)) {
						map[nx][ny] = 2;
						spread.add(new int[] {nx, ny});
					}
				}
			}
			
			if(time > ans) return;
		}
		
		if(isAns()) {
			ans = Math.min(time, ans);
		}
	}

	private static boolean isAns() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}

	private static boolean rangeCheck(int nx, int ny) {
		return nx>-1 && ny>-1 && nx<N && ny<N && map[nx][ny] == 0 ? true : false;
	}
}
