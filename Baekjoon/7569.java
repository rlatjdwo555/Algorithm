import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Queue<Dot> queue = new LinkedList<>(); 
		
		int[] X = {0,-1,0,1};
		int[] Y = {-1,0,1,0};
		int[] Z = {1,-1};
		
		String[] mapSize = input.readLine().split(" ");
		
		int R = Integer.parseInt(mapSize[1]);
		int C = Integer.parseInt(mapSize[0]);
		int H = Integer.parseInt(mapSize[2]);	
		int[][][] matrix = new int[H][R][C];
		
		for(int h=0; h<H; h++){
			for(int i=0; i<R; i++){
				String rows[] = input.readLine().split(" ");
				for(int j=0; j<C; j++){
					int state = Integer.parseInt(rows[j]);
					if(state == 1) queue.offer(new Dot(i,j,h));
					matrix[h][i][j] = state;
				}
			}
		}
		
		while(!queue.isEmpty()){
			Dot cur = queue.poll();
			
			for(int i=0; i<4; i++){
				int nx = cur.x+X[i];
				int ny = cur.y+Y[i];
				
				if(nx>-1 && nx<R && ny>-1 && ny<C && matrix[cur.z][nx][ny] == 0){
					matrix[cur.z][nx][ny] = matrix[cur.z][cur.x][cur.y] + 1;
					queue.offer(new Dot(nx, ny, cur.z));
				}
			}
			
			for(int i=0; i<2; i++){
				int nz = cur.z+Z[i];
				
				if(nz>-1 && nz<H && matrix[nz][cur.x][cur.y] == 0){
					matrix[nz][cur.x][cur.y] = matrix[cur.z][cur.x][cur.y] + 1;
					queue.offer(new Dot(cur.x, cur.y, nz));
				}
			}
		}
		
		int answer = 0;
		
		for(int h=0; h<H; h++){
			for(int i=0; i<R; i++){
				for(int j=0; j<C; j++){
					if(matrix[h][i][j] == 0){
						System.out.println(-1);
						return;
					}
					answer = Math.max(answer, matrix[h][i][j]);
				}
			}
		}
		
		System.out.println(answer-1);
	}
}

class Dot{
	int x;
	int y;
	int z;
	
	Dot(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
