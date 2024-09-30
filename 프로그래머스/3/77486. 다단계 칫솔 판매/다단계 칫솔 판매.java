import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> er = new HashMap<>();
        Map<String, Integer> profit = new HashMap<>();
        int[] answer = new int[enroll.length];
        
        for(int i = 0; i < enroll.length; i++) {
            er.put(enroll[i], referral[i]);
            profit.put(enroll[i], 0);
        }
        
        for(int i = 0;i < seller.length; i++) {
            String enr = seller[i];
            int m = amount[i] * 100;
            
            while(!enr.equals("-") && m > 0) {
                int t = m / 10;
                profit.put(enr, profit.get(enr) + m - t);
                enr = er.get(enr);
                m = t;
            }
        }
        
        for(int i = 0; i < enroll.length; i++) {
            answer[i] = profit.get(enroll[i]);
        }
        
        return answer;
    }
}