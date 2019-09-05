import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static HashMap<String, Character> base = new HashMap<>();
	static{
		base.put("0", '0');
		base.put("2", '1');
		base.put("4", '2');
		base.put("8", '3');
		base.put("16", '4');
		base.put("32", '5');
		base.put("64", '6');
		base.put("128", '7');
		base.put("256", '8');
		base.put("512", '9');
		base.put("1024", 'A');
	}

	static int N, answer;
	
	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));	
		N = Integer.parseInt(input.readLine());

		StringBuilder start = new StringBuilder();
		
		for(int i=0; i<N; i++){
			String rows[] = input.readLine().split(" ");
			for(int j=0; j<N; j++){
				char v = base.get(rows[j]);
				start.append(v);
			}
		}
		
		for(int i=0; i<start.length(); i++){
			if(start.charAt(i) != '0') break;
			else if(i == start.length()-1){
				System.out.println(0);
				return;
			}
		}
		
		DFS(0, start.toString());
		System.out.println(answer);
	
	}
	
	static void DFS(int depth, String arrInfo){
 		if(depth == 5){
			char max = arrInfo.charAt(0);
			
			for(int i=1; i<arrInfo.length(); i++){
				max = max < arrInfo.charAt(i) ? arrInfo.charAt(i) : max;
			}
			
			answer = (int)Math.max(answer, Math.pow(2, Integer.parseInt(String.valueOf(max), 16)));
			
		}else{
			Queue<Character> queue = new LinkedList<>();
			StringBuilder next;
			
			for(int k=0; k<4; k++){		
		
				switch(k){				
				//좌측 이동
				case 0:
					next = new StringBuilder(arrInfo);
					
					for(int i=0; i<N*N; i+=N){					
						for(int j=i; j<i+N; j++){
							if(arrInfo.charAt(j) != '0')
								queue.offer(arrInfo.charAt(j));
						}
						
						for(int j=i; j<i+N; j++){
							if(queue.isEmpty()){
								next.setCharAt(j, '0');
							}else{
								char c = queue.poll();
								
								if(!queue.isEmpty() && c == queue.peek()){
									c = queue.poll();
									c = c == '9' ? 'A' : (char)(c+1);
									next.setCharAt(j, c);
									
								}else{
									next.setCharAt(j, c);
								}
							}
						}
					}
					DFS(depth+1, next.toString());
					break;
				
				//우측 이동
				case 1: 
					next = new StringBuilder(arrInfo);
					
					for(int i=N; i<=N*N; i+=N){
						for(int j=i-1; j>=i-N; j--){
							if(arrInfo.charAt(j) != '0')
								queue.offer(arrInfo.charAt(j));
						}
						
						for(int j=i-1; j>=i-N; j--){
							if(queue.isEmpty()){
								next.setCharAt(j, '0');
							}else{
								char c = queue.poll();
								
								if(!queue.isEmpty() && c == queue.peek()){
									c = queue.poll();
									c = c == '9' ? 'A' : (char)(c+1);									
									next.setCharAt(j, c);
									
								}else{
									next.setCharAt(j, c);
								}
							}
						}
					}
					DFS(depth+1, next.toString());
					break;
				
				//상단 이동
				case 2:					
					next = new StringBuilder(arrInfo);

					for(int i=0; i<N; i++){		
						for(int j=i; j<N*N; j+=N){
							if(arrInfo.charAt(j) != '0')
								queue.offer(arrInfo.charAt(j));
						}
						
						for(int j=i; j<N*N; j+=N){
							if(queue.isEmpty()){
								next.setCharAt(j, '0');
							}else{
								char c = queue.poll();
								
								if(!queue.isEmpty() && c == queue.peek()){
									c = queue.poll();
									c = c == '9' ? 'A' : (char)(c+1);
									next.setCharAt(j, c);
									
								}else{
									next.setCharAt(j, c);
								}
							}
						}
					}
					DFS(depth+1, next.toString());
					break;
				
				//하단 이동	
				case 3:
					next = new StringBuilder(arrInfo);
					
					for(int i=N*N; i>N*N-N; i--){					
						for(int j=i-1; j>=0; j-=N){
							if(arrInfo.charAt(j) != '0')
								queue.offer(arrInfo.charAt(j));
						}
						
						for(int j=i-1; j>=0; j-=N){
							if(queue.isEmpty()){
								next.setCharAt(j, '0');
							}else{
								char c = queue.poll();
								
								if(!queue.isEmpty() && c == queue.peek()){
									c = queue.poll();
									c = c == '9' ? 'A' : (char)(c+1);
									next.setCharAt(j, c);
									
								}else{
									next.setCharAt(j, c);
								}
							}
						}
					}
					DFS(depth+1, next.toString());
					break;		
				} // switch
			} // 방향 for
		} // else 분기
	}
}
