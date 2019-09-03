import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static Dot[] store;
	static Dot[] house;
	static int comp[];
	static int N, M, answer = Integer.MAX_VALUE;
	static int storeSize, houseSize;
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String size[] = input.readLine().split(" ");
		N = Integer.parseInt(size[0]);
		M = Integer.parseInt(size[1]);
		comp = new int[M];
		store = new Dot[13];
		house = new Dot[N*N];
		
		for(int i=1; i<=N; i++){
			String row[] = input.readLine().split(" ");
			for(int j=1; j<=N; j++){
				char c = row[j-1].charAt(0);
				if(c == '1') house[houseSize++] = new Dot(i,j);
				else if(c == '2') store[storeSize++] = new Dot(i,j);
			}
		}
		
		DFS(0, 0);
		System.out.println(answer);
	}
	
	static void DFS(int no, int depth){
		if(depth == M){
			getDistance();
		}else{
			for(int i=no; i<=storeSize-(M-depth); i++){
				comp[depth] = i;
				DFS(i+1, depth+1);
			}
		}
	}
	
	static void getDistance(){
		int totalDistance = 0;
		
		for(int i=0; i<houseSize; i++){
			Dot ho = house[i];
			int distance = Integer.MAX_VALUE;
			
			for(int j=0; j<M; j++){
				Dot st = store[comp[j]];
				distance = Math.min(distance, Math.abs(st.x-ho.x)+Math.abs(st.y-ho.y));
			}
			totalDistance += distance;
		}
		
		answer = Math.min(answer, totalDistance);
	}
}

class Dot{
	int x;
	int y;
	
	Dot(int x, int y){
		this.x = x;
		this.y = y;
	}
}
