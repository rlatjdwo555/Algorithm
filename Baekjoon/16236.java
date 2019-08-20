import java.io.*;
import java.util.*;

public class Main {
	
	static int N, ans;
	static int map[][];
	static boolean visit[][];
	
	static int[] babyShark = {0, 0, 2, 0};  // x, y, size, eat
	static LinkedList<int[]> fish = new LinkedList<>();
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int r=0; r<N; r++){
			String row[] = input.readLine().split(" ");
			for(int c=0; c<N; c++){
				map[r][c] = Integer.parseInt(row[c]);
				
				if(map[r][c] == 9){
					babyShark[0] = r;
					babyShark[1] = c;
				}
				else if(map[r][c] > 0 && map[r][c] <= 6){
					fish.add(new int[]{r,c,map[r][c]}); // {x, y, size}
				}

			}
		}
		
		Collections.sort(fish, new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]){
					return o1[1] > o2[1] ? -1 : 1;
				}
				return o1[0] > o2[0] ? -1 : 1;
			}	
		});
			
		hunt();
		System.out.println(ans);
	}


	private static void hunt() {
		int time = 0;
		
		while(true){	
			int[] target = search(babyShark[2]);
			
			if(target == null){
				break;
			}
			
			time+=target[2];
			map[babyShark[0]][babyShark[1]] = 0;
			map[target[0]][target[1]] = 9;
			
			babyShark[0] = target[0]; 
			babyShark[1] = target[1];
			babyShark[3]++;
			
			if(babyShark[3] == babyShark[2]){
				babyShark[2]++;
				babyShark[3]=0;
			}
		}
		
		ans = time;
	}

	private static int[] search(int size) {
		int[] target = null;
		int[] result = null;
		
		int minDis = N*N;
		
		for(int[] pos : fish){	
			if(pos[2] >= size){
				continue;
			}
			
			int dis = bfs(pos, size, minDis);
					
			for(int j=0; j<N; j++){
				Arrays.fill(visit[j], false);
			}
					
			if(dis > 0 && minDis >= dis){
				minDis = dis;
				target = pos;
			}
		}
		
		if(target != null){
			result = new int[]{target[0], target[1], minDis};
			fish.remove(target);
		}
		
		return result;
	}


	private static int bfs(int[] pos, int size, int minDis) {
		int dis = 0;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{babyShark[0], babyShark[1], 0});  // x, y, dis
		visit[babyShark[0]][babyShark[1]] = true;
		
		while(!queue.isEmpty()){
			int qsize = queue.size();
			
			while(qsize-- > 0){
				int cur[] = queue.poll();
								
				for(int i=0; i<4; i++){
					int nx = cur[0]+dx[i];
					int ny = cur[1]+dy[i];
					
					if(nx>-1 && ny>-1 && nx<N && ny<N && !visit[nx][ny] && map[nx][ny] <= size){
						if(nx == pos[0] && ny == pos[1]){
							return cur[2]+1;
						}
						
						if(cur[2]+1 < minDis){
							queue.add(new int[]{nx, ny, cur[2]+1});
							visit[nx][ny] = true;
						}
					}
				}
			}
		}
		
		return dis;
	}	
}
