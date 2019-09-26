import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static boolean visited[][];
	static int map[][];
	static Queue<Dot> Q;
	static int Size;
	
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		Size = Integer.parseInt(input.readLine());
		
		map = new int[Size][Size];
		visited = new boolean[Size][Size];
		
		for(int i=0; i<Size; i++){
			String rowInfo = input.readLine();
			
			for(int j=0; j<Size; j++){
				map[i][j] = rowInfo.charAt(j)-'0';
				visited[i][j] = false;
			}
		}
		
		Q = new LinkedList<Dot>();
		ArrayList<Integer> nHome = new ArrayList<>();
		
		for(int i=0; i<Size; i++){
			for(int j=0; j<Size; j++){
				if(map[i][j] == 1){
					nHome.add(findHome(i, j));
				}
			}
		}
	
		System.out.println(nHome.size());
		Collections.sort(nHome);
	
		for(int size : nHome){
			System.out.println(size);
		}
	}
	
	static int findHome(int x, int y){
		int size = 1;
		
		Q.add(new Dot(x, y));
		visited[x][y] = true;
		
		while(!Q.isEmpty()){
			Dot d = Q.poll();
			
			for(int i=0; i<4; i++){
				int nextX = d.x + dx[i];
				int nextY = d.y + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= Size || nextY >= Size){
					continue;
				}
				else if(visited[nextX][nextY] || map[nextX][nextY] == 0){
					continue;
				}
				else{
					Q.add(new Dot(nextX, nextY));
					visited[nextX][nextY] = true;
					map[nextX][nextY] = 0;
					size++;
				}
			}
		}
		return size;
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
