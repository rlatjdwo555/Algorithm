import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        LinkedList<Integer> list = new LinkedList<>();
        
        for(String oper : operations){
            String cmd[] = oper.split(" ");
            char op = cmd[0].charAt(0);
            int n = Integer.parseInt(cmd[1]);
            
            if(op == 'I'){
                list.add(n);
                continue;
            }
            
            if(list.isEmpty()){
                continue;
            }
            
            if(n == -1){
                list.remove(list.indexOf(Collections.min(list)));
            }
            else {
                list.remove(list.indexOf(Collections.max(list)));
            }
        }   
        return list.isEmpty() ? new int[]{0, 0} : new int[]{Collections.max(list), Collections.min(list)};
    }
}