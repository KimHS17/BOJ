import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 1;
        int min = Arrays.stream(a).min().getAsInt();
        int l = 0, r = a.length - 1;
        int lMin = a[0], rMin = a[a.length - 1];
        
        while(!(a[l] == min && a[r] == min)) {
            if(a[l] != min && a[l] <= lMin) {
                lMin = a[l];
                answer++;
            }
            if(a[r] != min && a[r] <= rMin) {
                rMin = a[r];
                answer++;
            }
            if(a[l] != min) {
                l++;
            }
            if(a[r] != min) {
                r--;
            }
        }
        
        return answer;
    }
}