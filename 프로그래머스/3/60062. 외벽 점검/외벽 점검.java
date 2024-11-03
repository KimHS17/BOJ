import java.util.*;

class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        int weaks = weak.length;
        int[] w = new int[weaks * 2];
        int answer = Integer.MAX_VALUE;
        
        Arrays.sort(dist);
        for(int i = 0; i < weaks; i++) {
            w[i] = weak[i];
            w[i + weaks] = weak[i] + n;
        }
        
        for(int i = 0; i < weaks; i++) {
            int cntFri = 0, cntWeak = 0, idx = i;
            boolean[] used = new boolean[dist.length];
            
            while(idx < i + weaks) {
                int prevDist = 0, cntWeak2 = 0, idxWeak = 0, tmpWeak = idx;
                
                for(int j = 0; j < dist.length; j++) {
                    int cntWeak3 = 0;
                    
                    if(!used[j]) {
                        int d = w[idx] + dist[j];
                        
                        for(int k = idx; k < i + weaks; k++) {
                            if(w[k] >= w[idx] && w[k] <= d) {
                                cntWeak3++;
                                tmpWeak = k + 1;
                            }
                        }
                    }
                    if(cntWeak2 < cntWeak3) {
                        if(cntWeak2 != 0) {
                            used[prevDist] = false;
                        }
                        cntWeak2 = cntWeak3;
                        used[j] = true;
                        prevDist = j;
                        idxWeak = tmpWeak;
                    }
                }
                cntFri++;
                cntWeak += cntWeak2;
                if(cntWeak == weaks) { // 모든 취약점 탐색 완료
                    answer = answer < cntFri ? answer : cntFri;
                    break;
                } else if(tmpWeak == idx) { // 모든 취약점 탐색 불가능
                    break;
                }
                idx = idxWeak;
            }
        }
        
        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        
        return answer;
    }
}