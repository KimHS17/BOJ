import java.util.*;

class Solution {
    public int solution(String s) {
        String str = "";
        int[] m = new int[s.length() * 2 + 2];
        int r = -1, c = -1;
        int answer = 0;

        for(int i = 0; i < s.length(); i++) {
            str += "#" + s.charAt(i);
        }
        str += "#";
        
        for(int i = 0; i < str.length(); i++) {
            if(i <= r) {
                m[i] = Math.min(r - i, m[c + (c - i)]);
            }
            
            while(i + m[i] + 1 < str.length() && i - m[i] - 1 >= 0 && str.charAt(i + m[i] + 1) == str.charAt(i - m[i] - 1)) {
                m[i]++;
            }
            
            if(i + m[i] > r) {
                c = i;
                r = i + m[i];
            }
            
            answer = Math.max(answer, m[i]);
        }
        
        return answer;
    }
}