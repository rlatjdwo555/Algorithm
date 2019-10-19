import java.io.*;

public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String tc[] = input.readLine().split(" ");
		
		int N = Integer.parseInt(tc[0]);
		int M = Integer.parseInt(tc[1]);
		int nums[] = new int[N];
		int ans = 0;
		
		String tmp[] = input.readLine().split(" ");
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(tmp[i]);
		}
		
		for(int i=0; i<1<<N; i++) {
			int size = 0;
			int sum = 0;
			for(int j=0; j<N; j++) {
				if((i & 1 << j) == 0) {
					size++;
					sum+=nums[j];
				}
			}
			
			if(size > 0 && M == sum) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
