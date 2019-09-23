import java.io.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static char map[][];
	static int N;
			
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		
		map= new char[N][N];
		
		for(int i=0; i<N; i++) {
			map[i] = input.readLine().toCharArray();
		}
		
		int cmd = Integer.parseInt(input.readLine());
		
		switch(cmd) {
		case 1 : show1(); break;
		case 2 : show2(); break;
		case 3 : show3(); break;
		}
		
		System.out.println(sb);
	}
	
	static void show3() {
		for(int i=N-1; i>=0; i--) {
			sb.append(String.valueOf(map[i])+"\n");
		}	
	}

	static void show2() {
		for(int i=0; i<N; i++) {
			for(int j=N-1; j>=0; j--) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
	}

	static void show1() {
		for(int i=0; i<N; i++) {
			sb.append(String.valueOf(map[i])+"\n");
		}
	}
}
