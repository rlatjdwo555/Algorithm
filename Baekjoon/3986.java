import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String []args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int nCase = Integer.parseInt(input.readLine());
		
		int result = 0;
		
		while(nCase-- > 0){
			String testCase = input.readLine();
			Stack<Character> stack = new Stack<>();
			
			if(testCase.length() % 2 != 0) continue;
			
			for(int i=0; i<testCase.length(); i++){
				char c = testCase.charAt(i);
				
				if(stack.isEmpty()) stack.push(c);
				else if(stack.size() > testCase.length() / 2) break;
				else{
					if(stack.peek() == c) stack.pop();
					else stack.push(c);
				}		
			}
			
            if(stack.isEmpty()) result++;
			stack.clear();
		}
		System.out.println(result);
	}
}
