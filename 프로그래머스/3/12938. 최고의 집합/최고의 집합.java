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
        Arrays.fill(answer, 0, n - r, q);
        Arrays.fill(answer, n - r, n, q + 1);
        
        return answer;
    }
}