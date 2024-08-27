import java.util.*;

class Solution {    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String[]> q = new LinkedList<>();
        int[] cnt = new int[words.length];
        
        q.add(new String[]{begin, "0"});
        
        while(!q.isEmpty()) {
            String now[] = q.poll();
            
            for(int i = 0; i < words.length; i++) {
                int d = 0;
                
                for(int j = 0; j < begin.length(); j++) {
                    if(now[0].charAt(j) != words[i].charAt(j)) {
                        d++;
                    }
                }
                
                if(d == 1) {
                    int id = Integer.parseInt(now[1]);
                    
                    if(cnt[i] > cnt[id] + 1 || cnt[i] == 0) {
                        cnt[i] = cnt[id] + 1;
                        if(target.equals(words[i]) && (answer > cnt[i] || answer == 0)) {
                            answer = cnt[i];
                        } else {
                            q.add(new String[]{words[i], Integer.toString(i)});   
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}