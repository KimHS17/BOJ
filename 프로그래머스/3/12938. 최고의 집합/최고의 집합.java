class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int q, r;
        
        q = s / n;
        r = s % n;
        
        if(q == 0) {
            return new int[]{-1};
        } else {
            for(int i = 0; i < n; i++) {
                answer[i] = q;
                if(i >= n - r) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}