import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	static int farm[][];
	static int X[] = {-1, 0, 1, 0};
	static int Y[] = {0, -1, 0, 1};
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int nCase = Integer.parseInt(input.readLine());
			
		StringBuilder output = new StringBuilder();
		
		while(nCase --> 0){
			String testCase[] = input.readLine().split(" ");
			N = Integer.parseInt(testCase[0]);
			M = Integer.parseInt(testCase[1]);
			int K = Integer.parseInt(testCase[2]);
			
			farm = new int[N][M];
			
			for(int k=0; k<K; k++){
				String spot[] = input.readLine().split(" ");
				farm[Integer.parseInt(spot[0])][Integer.parseInt(spot[1])] = 1;
			}
			
			int count = 0;
			
			for(int i=0; i<N; i++){
				for(int j=0; j<M; j++){
					if(farm[i][j] == 1){
						dfs(i, j);
						count++;
					}
				}
			}
			
			output.append(count+"\n");
		}
		
		System.out.println(output);
	}
	
	static void dfs(int x, int y){
		farm[x][y] = 0;
		
		for(int i=0; i<4; i++){
			int px = x+X[i];
			int py = y+Y[i];
			
			if(px >= 0 && px < N && py >= 0 && py < M && farm[px][py] == 1){
				dfs(px, py);
			}
		}
	}
}
