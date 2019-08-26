import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		long max = 0;
		
		while(N-- > 0) {
			long n = scan.nextLong();
			
			if(max < n) {
				max = n;
			}
		}
		
		System.out.println(max);
	}
}
