import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, D, enemy, answer;
	static int map[][], archor[] = new int[3];
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String init[] = input.readLine().split(" ");
		N = Integer.parseInt(init[0]);
		M = Integer.parseInt(init[1]);
		D = Integer.parseInt(init[2]);
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String row[] = input.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(row[j]);
				
				if(map[i][j] == 1) {
					enemy++;
				}
			}
		}
		
		defence(0, 0);
		System.out.println(answer);
	}

	private static void defence(int idx, int st) {
		if(idx == 3) {
			attack();
			return;
		}
		
		for(int i=st; i<M; i++) {
			archor[idx] = i;
			defence(idx+1, i+1);
		}
	}

	private static void attack() {
		int kill = 0;
		int remain = enemy;
		
		int field[][] = new int[N][M];
		copyMap(map, field);
		
		while(remain > 0) {
			ArrayList<int[]> targets = new ArrayList<>();
			
			// 타겟팅
			for(int i=0; i<3; i++) {
				int d = N+M;
				int target[] = new int[2];
				boolean find = false;
				
				for(int r=N-1; r>=0; r--) {
					for(int c=0; c<M; c++) {
						int dis = (Math.abs(archor[i]-c)+N-r);
						if(field[r][c] == 1 && dis <= D) {
							if(!find) {
								find = true;
								target[0] = r;
								target[1] = c;
								d = dis;
							}else {
								if(d > dis) {
									target[0] = r;
									target[1] = c;
									d = dis;
								}else if(d == dis && target[1] > c) {
									target[0] = r;
									target[1] = c;
									d = dis;
								}
							}
						}
					}
				}
				
				if(find) {
					targets.add(target);
				}
			}
			
			// 타겟 제거
			for(int[] t : targets) {
				if(field[t[0]][t[1]] == 1) {
					kill++;
					remain--;
				}
				
				field[t[0]][t[1]] = 0;
			}
			
			// 벽에 있는 적 제거
			for(int i=0; i<M; i++) {
				if(field[N-1][i] == 1) {
					field[N-1][i] = 0;
					remain--;
				}
			}
			
			// 적병 전진
			for(int i=N-1; i>=1; i--) {
				for(int j=0; j<M; j++) {
					field[i][j] = field[i-1][j];
					field[i-1][j] = 0;
				}
			}
		}
		answer = Math.max(answer, kill);
	}

	static void copyMap(int[][] origin, int[][] copy) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j] = origin[i][j];
			}
		}	
	}
}
