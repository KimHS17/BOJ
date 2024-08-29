import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int AId = A.length - 1, BId = A.length - 1;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        while(AId >= 0 && BId >= 0) {
            if(A[AId] < B[BId]) {
                answer++;
                AId--;
                BId--;
            } else {
                AId--;
            }
        }
        
        return answer;
    }
}