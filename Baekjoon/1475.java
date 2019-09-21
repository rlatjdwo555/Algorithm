import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
		char nums[] = input.readLine().toCharArray();
		int cards[] = new int[10];
		
		for(char c : nums) {
			cards[c-'0']++;
		}
		
		int ans = (int)Math.ceil((double)(cards[6]+cards[9])/2);
		
		for(int i=0; i<10; i++) {
			if(i==6 || i==9) continue;
			
			if(ans < cards[i]) {
				ans = cards[i];
			}
		}

		System.out.println(ans);
	}
}
