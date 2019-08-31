import java.io.*;
import java.util.*;

public class 카카오2017_1_비밀지도 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		
		String[] ans = solution(n, arr1, arr2);
 		System.out.println(Arrays.toString(ans));
	}
	
	static public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] ans = new String[n];
		
		for(int i=0; i<n; i++){
			int[] binA = convert(arr1[i], n);
			int[] binB = convert(arr2[i], n);
			
			StringBuilder row = new StringBuilder();
			for(int j=0; j<n; j++){
				row.append(binA[j] == 0 && binB[j] == 0 ? " " : "#");
			}
			
			ans[i] = row.toString();
		}
		
		return ans;
	}

	static int[] convert(int n, int len) {
		int binary[] = new int[len];
		
		while(n > 0){
			binary[--len] = n%2;
			n /= 2;
		}
				
		return binary;
	}
}

