import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int set[] = {1,1,2,2,2,8};
		int have[] = new int[6];
		
		String tc[] = input.readLine().split(" ");
		
		for(int i=0; i<6; i++) {
			have[i] = Integer.parseInt(tc[i]);
			int n = 0;
			
			if(have[i] != set[i]) {
				n = Math.abs(have[i]-set[i]);
				
				if(have[i] > set[i]) {
					n *= -1;
				}
			}
			
			output.write(n+" ");
		}
		
		output.flush();
	}
}