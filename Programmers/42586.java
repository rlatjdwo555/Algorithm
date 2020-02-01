import java.util.Arrays;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
		int[] dayOfEnd = new int[100];
		int day = 1;
		
		for(int i=0; i<progresses.length; i++){
            day = 1;
			while(progresses[i] + (day*speeds[i]) < 100){
				day++;
			}
			dayOfEnd[day]++;
		}
		
		return Arrays.stream(dayOfEnd).filter(e -> e != 0).toArray();
    }
}