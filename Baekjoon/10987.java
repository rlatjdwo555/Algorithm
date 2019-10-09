import java.io.*;

public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int alpha[] = {1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0};
		int ans = 0;
		
		String str = input.readLine();
		for(int i=0; i<str.length(); i++) {
			if(alpha[str.charAt(i)-'a']==1) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
