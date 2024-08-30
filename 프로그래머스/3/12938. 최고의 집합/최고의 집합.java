import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int q, r;
        
        q = s / n;
        r = s % n;
        
        if(q == 0) {
            return new int[]{-1};
        }
        Arrays.fill(answer, q);
        for(int i = n - r; i < n; i++) {
            answer[i]++;
        }
        
        return answer;
    }
}