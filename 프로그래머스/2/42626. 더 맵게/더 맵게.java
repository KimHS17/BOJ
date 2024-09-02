import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int answer = 0, s, s2;
        
        for(int f: scoville) {
            q.add(f);
        }
        
        while(true) {
            s = q.poll();
            if(s >= K) {
                break;
            } else if(q.isEmpty()) {
                answer = -1;
                break;
            }
            s2 = q.poll();
            q.add(s + s2 * 2);
            answer++;
        }
        
        return answer;
    }
}