import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();       
        int time = 0, idx = 0, now = 0;
        
        for(int i = 0; i < bridge_length; i++) {
            q.add(0);
        }
        
        while(idx < truck_weights.length) {
            now -= q.poll();
            if(now + truck_weights[idx] <= weight) {
                q.add(truck_weights[idx]);
                now += truck_weights[idx++];
            } else {
                q.add(0);
            }

            time++;
        }
        
        return time + bridge_length;
    }
}