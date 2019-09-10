import java.io.*;
import java.util.LinkedList;

public class Main {	
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> link = new LinkedList<>();
		
		String nk[] = input.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		int a[] = new int[n];
		int idx = 0;
		
		for(int i=1; i<=n; i++) {
			link.add(i);
		}
		
		int pos = k-1;
		
		while(link.size() > 1){
			int x = link.get(pos);
			link.remove(pos);
			a[idx++] = x;
			pos = (pos+k-1)%link.size();
		}
		
		if(!link.isEmpty()) a[idx] = link.poll();
		
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        
        for (int i = 0; ; i++) {
            sb.append(String.valueOf(a[i]));
           
            if (i == n-1) {
                sb.append('>').toString();
                break;
            }
            
            sb.append(", ");
        }
        
        System.out.println(sb);
	}
}
