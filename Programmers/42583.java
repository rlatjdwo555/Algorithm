import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int truckIndex = 0;
        int curWeight = 0;
        
        LinkedList<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<bridge_length; i++) {
        	queue.add(0);
        }
        
        while(true) {
        	time++;
        	curWeight-=queue.poll();
        	
        	if(curWeight + truck_weights[truckIndex] <= weight) {
        		curWeight += truck_weights[truckIndex];
        		queue.add(truck_weights[truckIndex++]);
        		
        		if(truckIndex == truck_weights.length) {
        			time+=bridge_length;
        			break;
        		}
        	}
        	else {
        		queue.add(0);
        	}
        }
        
        return time;
    }
}