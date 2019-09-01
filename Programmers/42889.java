import java.io.*;
import java.util.*;

public class 카카오2018_1_실패율 {
		
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	static public int[] solution(int N, int[] stages) {
		int result[] = new int[N];
		Integer resultIndex[] = new Integer[N];
		double failArr[] = new double[N];
		int count[] = new int[N];
		
		for(int i=0; i<N; i++){
			resultIndex[i] = i;
		}
		
		for(int n : stages){	
			if(n > N) continue;
			
			count[n-1]++;
		}
		
		int total = stages.length;
		
		for(int i=0; i<N; i++){
			if(total == 0) break;
			
			failArr[i] = (double)count[i] / total;
			total-=count[i];
		}
		
		Arrays.sort(resultIndex, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				if(failArr[o1] == failArr[o2]){
					return o1 < o2 ? -1 : 1;
				}
				return failArr[o1] > failArr[o2] ? -1 : 1;
			}
		});
		
		for(int i=0; i<N; i++){
			result[i] = resultIndex[i]+1;
		}
		
		return result;
	}
}

