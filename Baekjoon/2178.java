import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int map[][];
	static boolean visited[][];
	static Queue<Point> queue;
	static int N;
	static int M;
	
	static int dx[] = {0,-1,0,1};
	static int dy[] = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++){
			String row = input.readLine();
			
			for(int j=0; j<M; j++){
				map[i][j] = row.charAt(j)-'0';
				visited[i][j] = false;
			}
		}
		
		queue = new LinkedList<Point>();
		find(0,0);
		
		System.out.println(map[N-1][M-1]);
	}
	
	static void find(int x, int y){
		queue.add(new Point(x,y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()){
			Point p = queue.poll();
			
			for(int i=0; i<4; i++){
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M){
					continue;
				}
				
				if(visited[nextX][nextY] || map[nextX][nextY] == 0){
					continue;
				}
				
				queue.add(new Point(nextX, nextY));
				map[nextX][nextY] = map[p.x][p.y] + 1;
				visited[nextX][nextY] = true;
			}
		}
		
	}
}

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
