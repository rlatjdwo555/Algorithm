import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K;
	static int robot[][];
	static int power[][];
	static LinkedList<Tree>[][] trees;
	
	static int dx[] = {0,0,-1,1, -1,-1,1,1};
	static int dy[] = {1,-1,0,0, -1,1,-1,1};
		
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String tc[] = input.readLine().split(" ");
		N = Integer.parseInt(tc[0]);
		M = Integer.parseInt(tc[1]);
		K = Integer.parseInt(tc[2]);
		robot = new int[N][N];
		power = new int[N][N];
		trees = new LinkedList[N][N];
		
		for(int i=0; i<N; i++){
			String row[] = input.readLine().split(" ");
			for(int j=0; j<N; j++){
				robot[i][j] = Integer.parseInt(row[j]);
				power[i][j] = 5;
				trees[i][j] = new LinkedList<>();
			}
		}
		
		for(int i=0; i<M; i++){
			String tree[] = input.readLine().split(" ");
			int x = Integer.parseInt(tree[0])-1;
			int y = Integer.parseInt(tree[1])-1;
			int z = Integer.parseInt(tree[2]);
			
			trees[x][y].add(new Tree(x,y,z));
		}
		
		
		while(K-- > 0){
			springAndSummer();
			runFall();
			
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					power[i][j] += robot[i][j];
				}
			}
		}
		
		int ans = 0;
				
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				ans += trees[i][j].size();
			}
		}
		
		System.out.println(ans);
	}

	static void runFall(){
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(trees[i][j].size() > 0){
					LinkedList<Tree> cur = trees[i][j];
					
					int size = cur.size();
					
					while(size-- > 0){
						Tree t = cur.poll();
						
						if(t.age % 5 == 0){
							for(int k=0; k<8; k++){
								int nx = i+dx[k];
								int ny = j+dy[k];
								
								if(nx>=0 && ny>=0 && nx<N && ny<N){
									trees[nx][ny].add(new Tree(nx, ny, 1));
								}
							}
						}
						
						cur.add(t);
					}
				}
			}
		}
	}

	static void springAndSummer() {
		LinkedList<Tree> deadList = new LinkedList<>();
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(trees[i][j].size() > 0){
					LinkedList<Tree> cur = trees[i][j];
					Collections.sort(cur);
					
					int size = cur.size();
					
					while(size-- > 0){
						Tree t = cur.poll();
						int p = power[i][j];
						
						if(t.age > p){
							deadList.add(t);
							continue;
						}
						
						power[i][j] -= t.age;
						t.age++;
						cur.add(t);
					}
				}
			}
		}

		for(Tree t : deadList){
			power[t.x][t.y] += t.age/2;
		}
	}
}

class Tree implements Comparable<Tree>{
	int x;
	int y;
	int age;
	
	Tree(int x, int y, int age){
		this.x = x;
		this.y = y;
		this.age = age;
	}

	public int compareTo(Tree o) {
		if(this.age == o.age){
			if(this.x == o.x){
				return Integer.compare(this.y, o.y);
			}
			return Integer.compare(this.x, o.x);
		}
		return Integer.compare(this.age, o.age);
	}
}
