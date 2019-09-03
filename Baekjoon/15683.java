import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static Character[][] matrix;
	static Dot[] cctv = new Dot[8];
	static int N, M, cctvCount, answer = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String testCase[] = input.readLine().split(" ");
		N = Integer.parseInt(testCase[0]);
		M = Integer.parseInt(testCase[1]);
		matrix = new Character[N][M];
		
		for(int i=0; i<N; i++){
			String row[] = input.readLine().split(" ");
			for(int j=0; j<M; j++){
				char c = row[j].charAt(0);
				matrix[i][j] = c;
				
				if(c != '0' && c != '5' && c != '6'){
					cctv[cctvCount++] = new Dot(i, j, c);
				}
			}
		}
		
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(matrix[i][j] == '5'){
					cctv5(new Dot(i,j,'5'));
				}
			}
		}
		
		DFS(0);
		System.out.println(answer);
	}
	
	
	static void DFS(int depth){
		if(depth == cctvCount){
			getSpace();
		}else{
			Character backup[][] = new Character[N][M];
			copyMatrix(backup, matrix);
			
			for(int i=0; i<4; i++){
				checkRange(depth, i);
				DFS(depth+1);
				copyMatrix(matrix, backup);
			}
		}
	}
	
	static void checkRange(int no, int direct){
		Dot d = cctv[no];
		
		switch(d.no){
		case '1': cctv1(d, direct); break;
		case '2': cctv2(d, direct); break;
		case '3': cctv3(d, direct); break;
		case '4': cctv4(d, direct); break;
		}
	}
	
	static void copyMatrix(Character copy[][], Character origin[][]){
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				copy[i][j] = origin[i][j];
			}
		}
	}
	
	static void getSpace(){
		int space = 0;
		
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(matrix[i][j] == '0') space++;
			}
		}
		
		answer = Math.min(answer, space);
	}
	
	static void paintCCTV(Dot d, int direct){
		// 0:좌, 1:우, 2:상, 3:하
		switch(direct){
		case 0:
			for(int i=d.y-1; i>=0; i--){
				if(matrix[d.x][i] == '6') break;						
				else if(matrix[d.x][i] == '0') matrix[d.x][i] = '#';
			}
			break;
		case 1:
			for(int i=d.y+1; i<M; i++){
				if(matrix[d.x][i] == '6') break;
				else if(matrix[d.x][i] == '0') matrix[d.x][i] = '#';
			}
			break;
		case 2:
			for(int i=d.x-1; i>=0; i--){
				if(matrix[i][d.y] == '6') break;
				else if(matrix[i][d.y] == '0') matrix[i][d.y] = '#';
			}
			break;
		case 3:
			for(int i=d.x+1; i<N; i++){
				if(matrix[i][d.y] == '6') break;
				else if(matrix[i][d.y] == '0') matrix[i][d.y] = '#';
			}
			break;
		}
	}
	
	static void cctv1(Dot d, int direct){
		paintCCTV(d, direct);
	}
	
	static void cctv2(Dot d, int direct){
		if(direct == 0 || direct == 1){
			paintCCTV(d, 0);
			paintCCTV(d, 1);
		}else{
			paintCCTV(d, 2);
			paintCCTV(d, 3);
		}
	}

	static void cctv3(Dot d, int direct){
		switch(direct){
		case 0:
			paintCCTV(d, 2);
			paintCCTV(d, 1);
			break;
		case 1:
			paintCCTV(d, 1);
			paintCCTV(d, 3);
			break;
		case 2:
			paintCCTV(d, 3);
			paintCCTV(d, 0);
			break;
		case 3:
			paintCCTV(d, 0);
			paintCCTV(d, 2);
			break;
		}
	}

	static void cctv4(Dot d, int direct){
		switch(direct){
		case 0:
			paintCCTV(d, 0);
			paintCCTV(d, 1);
			paintCCTV(d, 2);
			break;
		case 1:
			paintCCTV(d, 1);
			paintCCTV(d, 2);
			paintCCTV(d, 3);
			break;
		case 2:
			paintCCTV(d, 0);
			paintCCTV(d, 1);
			paintCCTV(d, 3);
			break;
		case 3:
			paintCCTV(d, 0);
			paintCCTV(d, 2);
			paintCCTV(d, 3);
			break;
		}
	}
	
	static void cctv5(Dot d){
		paintCCTV(d, 0);
		paintCCTV(d, 1);
		paintCCTV(d, 2);
		paintCCTV(d, 3);
	}
}

class Dot{
	int x;
	int y;
	char no;
	
	Dot(int x, int y, char no){
		this.x = x;
		this.y = y;
		this.no = no;
	}
}
