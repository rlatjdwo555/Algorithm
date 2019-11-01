import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	
	static HashSet<Integer> hs = new HashSet<>();
	static int N;
	static int[][] matrix;
	static boolean[][] visited;
	static int answer = 1;
	
	static int[] X = {0, -1, 0, 1};
	static int[] Y = {-1, 0, 1, 0};
	
	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(input.readLine());
		matrix = new int[N][N];
		visited = new boolean[N][N];
		int count = 0;
		
		for(int i=0; i<N; i++){
			String rows[] = input.readLine().split(" ");
			for(int j=0; j<N; j++){
				matrix[i][j] = Integer.parseInt(rows[j]);
				hs.add(Integer.parseInt(rows[j]));
			}
		}
		
		for(int height : hs){
			for(int k=0; k<N; k++){
				Arrays.fill(visited[k], false);
			}
			count = 0;
			
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(matrix[i][j] > height && !visited[i][j]){
						count++;
						DFS(i, j, height);
					}
				}
			}	
			answer = Math.max(answer, count);
		}
		
		System.out.println(answer);
	}
	
	static void DFS(int x, int y, int h){
		visited[x][y] = true;
		
		for(int i=0; i<4; i++){
			int nx = x+X[i];
			int ny = y+Y[i];
			
			if(nx>-1 && nx<N && ny>-1 && ny<N && matrix[nx][ny] > h && !visited[nx][ny]){
				DFS(nx, ny, h);
			}
		}
	}
}
