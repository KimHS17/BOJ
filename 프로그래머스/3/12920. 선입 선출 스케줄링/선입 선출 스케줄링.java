import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        int low = 1, high = 10000 * n, time = 0, work = 0;
        
        if(n <= cores.length)
            return n;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            int cnt = cores.length;
            
            for(int core: cores) {
                cnt += mid / core;
            }
            
            if(cnt >= n) {
                high = mid - 1;
                time = mid;
                work = cnt;
            } else {
                low = mid + 1;
            }
            
        }
        
        work -= n;
        for(int i = cores.length - 1; i >= 0; i--) {
            if(time % cores[i] == 0) {
                if(work == 0){
                    answer = i + 1;
                    break;
                }
                work--;
            }
        }
        
        return answer;
    }
}