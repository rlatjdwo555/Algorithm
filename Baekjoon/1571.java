import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int X[] = {1,-1,0,0};
	static int Y[] = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		int caseA[][] = new int[N][N];
		int caseB[][] = new int[N][N];
		boolean visitA[][] = new boolean[N][N];
		boolean visitB[][] = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String row = input.readLine();
			for(int j=0; j<N; j++) {
				char c = row.charAt(j);
				
				// R = 0, G = 1, B = 2
				if(c == 'R' || c == 'G') {
					caseB[i][j] = 0;
					caseA[i][j] = c == 'R' ? 0 : 1;
				}else {
					caseA[i][j] = 2;
					caseB[i][j] = 2;
				}
			}
		}
	
		int x = 0;
		int y = 0;

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visitA[i][j]) {
					DFS(i, j, caseA[i][j], caseA, visitA);
					x++;
				}
				
				if(!visitB[i][j]) {
					DFS(i, j, caseB[i][j], caseB, visitB);
					y++;
				}
			}
		}
		
		System.out.println(x+" "+y);
	}

	static void DFS(int x, int y, int key, int matrix[][], boolean visit[][]) {
		visit[x][y] = true;

		for(int i=0; i<4; i++){
			int nx = x + X[i];
			int ny = y + Y[i];

			if (isPossible(nx, ny, key, matrix, visit)){
				DFS(nx, ny, key, matrix, visit);
			}
		}
	}
	
	static boolean isPossible(int x, int y, int key, int matrix[][], boolean visit[][]) {
		return (x>-1 && y>-1 && x<N && y<N) && !visit[x][y] 
				&& matrix[x][y] == key ? true : false;
	}
}
