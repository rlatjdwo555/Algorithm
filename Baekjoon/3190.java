import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	
	static LinkedList<Dot> snake = new LinkedList<>();
	static int matrix[][];
	static int N, K, nx = 0, ny = 0;
	static int time = 0;
	static char curDirect = 'R';
	
	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));	
		N = Integer.parseInt(input.readLine());
		K = Integer.parseInt(input.readLine());
		
		matrix = new int[N][N];
		matrix[0][0] = 1;
		snake.add(new Dot(0,0));
		
		while(K-- > 0){
			String dot[] = input.readLine().split(" ");
			matrix[Integer.parseInt(dot[0])-1][Integer.parseInt(dot[1])-1] = 2;
		}
		
		int L = Integer.parseInt(input.readLine());
		
		while(L-- > 0){
			String command[] = input.readLine().split(" ");
			int t = Integer.parseInt(command[0]);
			char direct = command[1].charAt(0);

			if(!moveSnake(t-time, direct)) break;
			
			if(L == 0){
				while(moveSnake(1000001 - time, direct)){}
			}
		}

		System.out.println(time);
	}
	
	static boolean moveSnake(int t, char direct){
		for(int i=0; i<t; i++){
			time++;			
			if(getNextDot(direct)){		
				if(matrix[nx][ny] == 2){
					snake.addFirst(new Dot(nx, ny));
					matrix[nx][ny] = 1;
				
				}else if(matrix[nx][ny] == 1){
					 time++;
					 return false;
				}else{
					Dot next = new Dot(nx, ny);
					Dot pre = new Dot(snake.peek().x, snake.peek().y);
					matrix[snake.peekLast().x][snake.peekLast().y] = 0;
					matrix[nx][ny] = 1;
					
					for(Dot d : snake){
						pre.x = d.x;
						pre.y = d.y;
						d.x = next.x;
						d.y = next.y;
						next.x = pre.x;
						next.y = pre.y;
					}
				}		
			}else{
				return false;
			}
		}
		
		switch(curDirect){
		case 'R': curDirect = direct == 'L' ? 'U' : 'D'; break;
		case 'L': curDirect = direct == 'L' ? 'D' : 'U'; break;
		case 'D': curDirect = direct == 'L' ? 'R' : 'L'; break;			
		case 'U': curDirect = direct == 'L' ? 'L' : 'R'; break;
		}

		return true;	
	}
	
	static boolean isRightRange(int x, int y){
		return (x>-1 && y>-1 && x<N && y<N) ? true : false;
	}
	
	static boolean getNextDot(char direct){
		switch(curDirect){
		case 'R':
			if(isRightRange(nx, ny+1) && matrix[nx][ny+1] != 1) {
				ny++;
				return true;
			}
			break;
			
		case 'L':
			if(isRightRange(nx, ny-1) && matrix[nx][ny-1] != 1){
				ny--; 
				return true;
			}
			break;
			
		case 'D' :
			if(isRightRange(nx+1, ny) && matrix[nx+1][ny] != 1){
				nx++; 
				return true;
			}
			break;
			
		case 'U':
			if(isRightRange(nx-1, ny) && matrix[nx-1][ny] != 1) {
				nx--;
				return true;		
			}
			break;
		}
		
		return false;
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