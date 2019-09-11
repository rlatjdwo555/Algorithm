import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int matrix[][];
	static int team[], no[], link[], start[];
	static int N;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		
		matrix = new int[N][N];
		start = new int[N/2];
		link = new int[N/2];
		team = new int[N];
		no = new int[N];
		
		for(int i=0; i<N; i++){
			no[i] = i;
		}
		team[0] = 1;
		
		for(int i=0; i<N; i++){
			String rows[] = input.readLine().split(" ");
			for(int j=0; j<N; j++){
				matrix[i][j] = Integer.parseInt(rows[j]);
			}
		}
		
		DFS(1, 1); 
		System.out.println(answer);
	}
	
	static void DFS(int no, int depth){
		if(depth == N/2){
			getScore();
		}else{
			for(int i=no; i<=N-(N/2-depth); i++){
				team[i] = 1;
				DFS(i+1, depth+1);
				team[i] = 0;
			}
		}
	}
	
	static void getScore(){
		int idx = 0;
		int idx2 = 0;
		int scoreA = 0;
		int scoreB = 0;
		
		for(int i=0; i<N; i++){
			if(team[i] == 1) link[idx++] = no[i];
			else start[idx2++] = no[i];
		}
		
		for(int i=0; i<link.length-1; i++){
			for(int j=i+1; j<link.length; j++){
				scoreA += matrix[link[i]][link[j]] + matrix[link[j]][link[i]]; 
				scoreB += matrix[start[i]][start[j]] + matrix[start[j]][start[i]]; 
			}
		}
        
		answer = Math.min(answer, Math.abs(scoreA-scoreB));
	}
}
