import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long mid, cal, l = 0, r = times[times.length - 1] * (long)n;
        
        while(l <= r) {
            mid = (l + r) / 2;
            cal = 0;
            for(int time: times) {
                cal += mid / time;
            }
            if(cal < n) {
                l = mid + 1;
            } else {
                r = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}