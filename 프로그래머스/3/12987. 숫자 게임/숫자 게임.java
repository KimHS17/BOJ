import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int id = A.length - 1;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = A.length - 1; i >= 0; i--) {
            if(A[i] < B[id]) {
                answer++;
                id--;
            }
        }
        
        return answer;
    }
}