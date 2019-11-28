import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] testCase = input.readLine().split(" ");
		
		int N = Integer.parseInt(testCase[0]);
		int M = Integer.parseInt(testCase[1]);
		int INF = Integer.MAX_VALUE;
		
		int[][] matrix = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++){
			Arrays.fill(matrix[i], INF);
		}
		
		for(int k=0; k<M; k++){
			String[] spot = input.readLine().split(" ");
			int x = Integer.parseInt(spot[0]);
			int y = Integer.parseInt(spot[1]);
			matrix[x][y] = 1;
			matrix[y][x] = 1;
		}
		
		for(int k=1; k<=N; k++){
			for(int i=1; i<=N; i++){
				if(matrix[i][k] == INF) continue;
				for(int j=1; j<=N; j++){
					if(matrix[k][j] == INF) continue;
					else{
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
					}
				}
			}
		}
		
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				matrix[i][j] += matrix[i][j-1];
			}
		}
		
		int answer = 0;
		int minValue = INF;
	
		for(int i=1; i<=N; i++){
			if(matrix[i][N] < minValue){
				answer = i;
				minValue = matrix[i][N];
			}
		}
		
		System.out.println(answer);
	}
}
