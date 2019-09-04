import java.io.*;
import java.util.LinkedList;

public class Main {	
	
	static LinkedList<Integer>[] wheel = new LinkedList[4];
	static boolean flag[] = new boolean[3];
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<4; i++) {
			wheel[i] = new LinkedList<>();	
			char tc[] = input.readLine().toCharArray();
			
			for(char c : tc) {
				wheel[i].add(c-'0');
			}
		}
		
		int T = Integer.parseInt(input.readLine());
		
		while(T-- > 0) {
			String tc[] = input.readLine().split(" ");
			
			// setFlag
			for(int i=0; i<3; i++) {
				flag[i] = wheel[i].get(2) != wheel[i+1].get(6) ? true : false;
			}
			
			rotate(Integer.parseInt(tc[0])-1, Integer.parseInt(tc[1]) == 1 ? true : false);
		}
		
		int ans = 0;
		
		for(int i=0; i<4; i++) {
			if(wheel[i].get(0) == 1) {
				ans+=Math.pow(2, i);
			}
		}
		
		System.out.println(ans);
	}

	static void rotate(int no, boolean d) {
		// 본인 회전
		if(d) addFirst(no);  // 시계
		else addLast(no);    // 반 시계
		
		boolean left = !d;
		boolean right = !d;
		
		// 좌측 톱니들 회전
		for(int i=no-1; i>=0; i--) {
			int link = i == 0 ? 0 : i;
			
			if(!flag[link]) break;	 // 회전 불가이면 break;
			
			if(left) addFirst(i);
			else addLast(i);
			
			left = !left;
		}
		
		// 우측 톱니들 회전
		for(int i=no+1; i<4; i++) {
			int link = i-1;
			
			if(!flag[link]) break;
			
			if(right) addFirst(i);
			else addLast(i);
			
			right = !right;
		}
	}
	
	static void addFirst(int i) {
		wheel[i].addFirst(wheel[i].pollLast());
	}
	
	static void addLast(int i) {
		wheel[i].addLast(wheel[i].pollFirst());
	}
}
