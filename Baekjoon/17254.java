import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String tc[] = input.readLine().split(" ");
		int M = Integer.parseInt(tc[1]);
		
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			String info[] = input.readLine().split(" ");
			list.add(new int[] {Integer.parseInt(info[0]),
								Integer.parseInt(info[1]),
							    info[2].charAt(0)});
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] < o2[0] ? -1 : 1;
				}
				return o1[1] < o2[1] ? -1 : 1;
			}		
		});
		
		for(int[] k : list) {
			output.write((char)k[2]);
		}
		
		output.flush();
	}
}