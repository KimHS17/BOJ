class Solution {
    public boolean can(int[] stones, int m, int k) {
        int cnt = 0;
        
        for(int stone: stones) {
            if(stone - (m - 1) <= 0) {
                cnt++;
                if(cnt >= k) {
                    return false;
                }
            } else {
                cnt = 0;
            }
        }
        
        return true;
    }
    
    public int bs(int[] stones, int l, int r, int k) {
        int m = (l + r) / 2;
        
        if(l >= r) {
            return l;
        }
        if(can(stones, m, k)) {
            return bs(stones, m + 1, r, k);
        } else {
            return bs(stones, l, m - 1, k);
        }
    }
    
    public int solution(int[] stones, int k) {
        int answer = bs(stones, 0, 200000001, k);
        answer = can(stones, answer, k) ? answer : answer - 1;
        return answer;
    }
}