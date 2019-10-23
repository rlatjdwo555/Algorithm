import java.io.*;
import java.util.*;

public class Main {
    
	static int N, M, K;
	static LinkedList<LinkedList<Integer>> disks = new LinkedList<>();
	
    public static void main(String args[]) throws Exception{
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	String tc[] = input.readLine().split(" ");
    	N = Integer.parseInt(tc[0]);
    	M = Integer.parseInt(tc[1]);
    	K = Integer.parseInt(tc[2]);
    	
    	for(int i=0; i<N; i++){
    		disks.add(new LinkedList<>());
    		String nums[] = input.readLine().split(" ");
    		
    		for(int j=0; j<M; j++){
    			disks.get(i).add(Integer.parseInt(nums[j]));
    		}
    	}
    	
    	while(K-- > 0){
    		String cmd[] = input.readLine().split(" ");
    		int mul = Integer.parseInt(cmd[0]);
    		int dir = Integer.parseInt(cmd[1]);
    		int cnt = Integer.parseInt(cmd[2]);
    		
    		for(int idx=mul; idx<=N; idx+=mul){
    			rotate(disks.get(idx-1), dir, cnt);
    		}
    		
    		if(dupleCheck()){
    			System.out.println(0);
    			return;
    		}
    	}
    	
    	int ans = 0;
    	
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				int num = disks.get(i).get(j);

				if(num > 0){
					ans += num;
				}
			}
		}
    	
    	System.out.println(ans);
    }

	static boolean dupleCheck() {
		boolean inner[][] = new boolean[N][M];
		boolean outer[][] = new boolean[N][M];
		boolean isRemove = false;
		
		for(int part=0; part<M; part++){
			for(int i=0; i<N-1; i++){
				int cur = disks.get(i).get(part);
				boolean find = false;
				
				if(cur == 0 || outer[i][part]) continue;
				
				for(int j=i+1; j<N; j++){
					if(cur != disks.get(j).get(part)){
						break;
					}
					
					find = true;
					outer[j][part] = true;
				}
				
				if(find){
					isRemove = true;
					outer[i][part] = true;
				}
			}
		}
		
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				int cur = disks.get(i).get(j);
				boolean find = false;
				
				if(cur == 0 || inner[i][j]) continue;
				
				for(int k=j+1; k<j+M; k++){
					int idx = k%M;
					
					if(cur != disks.get(i).get(idx)){
						break;
					}
					
					find = true;
					inner[i][idx] = true;
				}
				
				if(find){
					isRemove = true;
					inner[i][j] = true;
				}
			}
		}
		
		if(isRemove){
			for(int i=0; i<N; i++){
				for(int j=0; j<M; j++){
					if(inner[i][j] || outer[i][j]){
						disks.get(i).set(j, 0);
					}
				}
			}
			return false;
		}
		
		ArrayList<int[]> pos = new ArrayList<>();
		double sum = 0;
		int cnt = 0;
		
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				int num = disks.get(i).get(j);
				
				if(num > 0){
					pos.add(new int[]{i, j});
					sum += num;
					cnt++;
				}
			}
		}
		
		if(cnt == 0) return true;
		
		double avg = sum / cnt;
		
		for(int[] p : pos){
			int num = disks.get(p[0]).get(p[1]);
			
			if(num > avg){
				disks.get(p[0]).set(p[1], num-1);
			}else if(num < avg){
				disks.get(p[0]).set(p[1], num+1);
			}
		}
		
		return false;
	}

	static void rotate(LinkedList<Integer> disk, int dir, int cnt) {
		if(dir == 0){
			while(cnt-- > 0){
				disk.addFirst(disk.pollLast());
			}
			return;
		}
		
		while(cnt-- > 0){
			disk.add(disk.poll());
		}
	}
}
