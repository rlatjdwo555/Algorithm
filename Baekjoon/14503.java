import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, ans = 1;
	static int map[][];
	static boolean visit[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};

	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String mapInfo[] = input.readLine().split(" ");
		N = Integer.parseInt(mapInfo[0]);
		M = Integer.parseInt(mapInfo[1]);
		map = new int[N][M];
		visit = new boolean[N][M];
		
		String robotInfo[] = input.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			String row[] = input.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		simulation(Integer.parseInt(robotInfo[0]),
				   Integer.parseInt(robotInfo[1]),
				   Integer.parseInt(robotInfo[2]));
		
		System.out.println(ans);
	}


	static void simulation(int x, int y, int d) {
		Queue<Robot> queue = new LinkedList<>();
		queue.offer(new Robot(x,y,d));
		visit[x][y] = true;
		
		while(!queue.isEmpty()) {
			Robot cur = queue.poll();
			int flag = exitCheck(cur);	// 종료조건과 왼쪽이 벽인지 탐색
			
			if(flag == 1) break;
			else if(flag == 0) queue.offer(backMove(cur));
			else queue.offer(leftMove(cur));
		}
	}
	
	// 4방향이 벽이 아니면서 청소가 되어있지 않은 경우 true
	static boolean isPossible(int x, int y) {
		return x>0 && y>0 && x<N-1 && y<M-1 && map[x][y] == 0 && !visit[x][y] ? true : false;
	}
	

	// -1:청소가능, 0:후진, 1:종료
	static int exitCheck(Robot cur) {		
		
		for(int i=0; i<4; i++) {
			int nx = cur.x+dx[i];
			int ny = cur.y+dy[i];
			
			if(isPossible(nx, ny)) return -1; // 4진 탐색해서 청소 가능 있으면 return		
		}
		
		if(getLeft(cur) == 1) {		 // 왼쪽이 벽이면
			return getBack(cur) ? 0 : 1;			
		}
		
		if(getBack(cur)) {
			return 0;   // 4방향 청소가 되어있거나 벽인 경우, 뒤로 이동할 수 있는지
		}
	
		return 1;
	}
	
	static Robot backMove(Robot cur) {
		int x = cur.x, y = cur.y;
		Robot next = null;
		
		switch(cur.d) {
		case 0 : 
			if(!visit[x+1][y]) ans++;
			visit[x+1][y] = true;
			next = new Robot(x+1,y,0); 
			break;
		case 1 : 
			if(!visit[x][y-1]) ans++;
			visit[x][y-1] = true;
			next = new Robot(x,y-1,1); 
			break;
		case 2 : 
			if(!visit[x-1][y]) ans++;
			visit[x-1][y] = true;
			next = new Robot(x-1,y,2);
			break;
		case 3 : 
			if(!visit[x][y+1]) ans++;
			visit[x][y+1] = true;
			next = new Robot(x,y+1,3); 
			break;
		}
		
		return next;
	}
	
	// d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽
		static Robot leftMove(Robot cur) {
			int x = cur.x, y = cur.y;
			Robot next = null;
			
			switch(cur.d) {
			case 0 : 
				if(y-1 >= 0 && map[x][y-1] == 0 && !visit[x][y-1]) {
					next = new Robot(x,y-1,3);
					visit[x][y-1] = true;
					ans++;
				}else {
					next = new Robot(x, y, 3); 
				}
				break;
			case 1 : 
				if(x-1 >= 0 && map[x-1][y] == 0 && !visit[x-1][y]) {
					next = new Robot(x-1,y,0);
					visit[x-1][y] = true;
					ans++;
				}else {
					next = new Robot(x, y, 0);
				}
				break;
			case 2 : 
				if(y+1 < M && map[x][y+1] == 0 && !visit[x][y+1]) {
					next = new Robot(x,y+1,1);
					visit[x][y+1] = true;
					ans++;
				}else {
					next = new Robot(x, y, 1);
				}
				break;
			case 3 : 
				if(x+1 < N && map[x+1][y] == 0 && !visit[x+1][y]) {
					next = new Robot(x+1,y,2);
					visit[x+1][y] = true;
					ans++;
				}else {
					next = new Robot(x, y, 2);
				}
				break;
			}
			
			return next;
		}

	
	// 뒤로 이동 가능하면 true
	static boolean getBack(Robot cur) {
		int x = cur.x, y = cur.y;
		
		switch(cur.d) {
		case 0 : return x+1 < N && map[x+1][y] == 0 ? true : false; 
		case 1 : return y-1 >= 0 && map[x][y-1] == 0 ? true : false; 
		case 2 : return x-1 >= 0 && map[x-1][y] == 0 ? true : false; 
		case 3 : return y+1 < M && map[x][y+1] == 0 ? true : false; 
		}
		
		return false;
	}

	// 0: 청소가능, 1: 벽
	static int getLeft(Robot cur) {
		int x = cur.x, y = cur.y;
		
		switch(cur.d) {
		case 0 : return y-1 >= 0 && map[x][y-1] == 0 ? 0 : 1; 
		case 1 : return x-1 >= 0 && map[x-1][y] == 0 ? 0 : 1; 
		case 2 : return y+1 < M && map[x][y+1] == 0 ? 0 : 1; 
		case 3 : return x+1 < N && map[x+1][y] == 0 ? 0 : 1; 
		}
		return 0;
	}

	static class Robot{
		int x;
		int y;
		int d;
		
		Robot(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
