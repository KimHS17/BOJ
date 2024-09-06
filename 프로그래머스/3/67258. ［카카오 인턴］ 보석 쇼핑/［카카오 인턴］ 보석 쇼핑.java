import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashMap<String, Integer> map = new HashMap<>();
        int k, r = 0, l = 0;
        int[] answer = {0, 100001};
        
        for(String g: gems) {
            map.putIfAbsent(g, 0);
        }
        k = map.size();
        map.clear();
        map.put(gems[r], 1);
        
        while(l <= r) {
            if(map.size() == k) {
                if(answer[1] - answer[0] > r - l) {
                    answer = new int[]{l + 1, r + 1};
                }
                if(map.get(gems[l]) == 1) {
                    map.remove(gems[l]);
                } else {
                    map.put(gems[l], map.get(gems[l]) - 1);
                }
                l++;
            } else if(map.size() < k) {
                r++;
                if(r == gems.length) {
                    break;
                }
                map.put(gems[r], map.getOrDefault(gems[r], 0) + 1);
            }
        }
        
        return answer;
    }
}