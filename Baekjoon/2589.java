import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int dx[] = {0,0,-1,1};
		int dy[] = {-1,1,0,0};
		
		String info[] = input.readLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int M = Integer.parseInt(info[1]);
		
		char map[][] = new char[N][M];
		boolean visit[][] = new boolean[N][M];
		
		for(int i=0; i<N; i++){
			map[i] = input.readLine().toCharArray();
		}
		
		Queue<Dot> queue = new LinkedList<>();
		int ans = 0;
		
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(map[i][j] == 'L'){
					queue.add(new Dot(i, j));
					visit[i][j] = true;
					int dis = -1;
					
					while(!queue.isEmpty()){
						int size = queue.size();
						dis++;
						
						while(size-- > 0){
							Dot cur = queue.poll();
							
							for(int k=0; k<4; k++){
								int nx = cur.x+dx[k];
								int ny = cur.y+dy[k];
								
								if(nx>-1 && ny>-1 && nx<N && ny<M && !visit[nx][ny] && map[nx][ny] == 'L'){
									visit[nx][ny] = true;
									queue.add(new Dot(nx, ny));
								}
							}
						}
					}
					
					ans = Math.max(ans, dis);
					
					for(int k=0; k<N; k++){
						Arrays.fill(visit[k], false);
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	static class Dot{
		int x;
		int y;
		
		Dot(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
