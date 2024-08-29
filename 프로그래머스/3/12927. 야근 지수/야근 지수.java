import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int id = works.length - 1;
        
        Arrays.sort(works);
        for(int i = 0; i < n; i++) {
            if(works[0] == 0) {
                return 0;
            }
            
            if(id > 0 && works[id] < works[id - 1]) {
                id--;
            }
            while(id < works.length - 1 && works[id + 1] >= works[id]) {
                id++;
            }
            
            if(works[id] > 0) {
                works[id]--;
            }
        }
        
        for(long w: works) {
            System.out.print(w + " ");
            answer += w * w;
        }
        
        return answer;
    }
}