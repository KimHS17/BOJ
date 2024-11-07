import java.util.*;

class Solution {
    public int solution(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = -1;
        
        for(int num: a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int key : map.keySet()) {
            int cnt = 0;
            
            if(map.get(key) <= answer)
                continue;

            for(int i = 0; i < a.length - 1; i++) {
                if(a[i] != key && a[i+1] != key)
                    continue;
                
                if(a[i] == a[i+1])
                    continue;
                
                cnt++;
                i++;
            }
            
            answer = Math.max(answer, cnt);
        }

        return answer * 2;
    }
}