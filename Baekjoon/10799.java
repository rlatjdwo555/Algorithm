import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char test_case[] = br.readLine().toCharArray();
		int top = 0;
		int count = 0;
		
		for(int i=0; i<test_case.length; i++){
			char c = test_case[i];
			
			if(c == '('){
				top++;
			}
			else{
				if(test_case[i-1] == '('){
					count += --top;
				}
				else{
					count++;
					top--;
				}
			}
		}
		System.out.println(count);
	}
}