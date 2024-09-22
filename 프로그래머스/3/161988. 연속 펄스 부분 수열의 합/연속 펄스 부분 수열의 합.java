class Solution {
    public long solution(int[] sequence) {
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];
        long answer = 0;
        int p = -1;
        
        dp1[0] = sequence[0];
        dp2[0] = sequence[0] * -1;
        for(int i = 1; i < sequence.length; i++) {
            dp1[i] = Math.max(dp1[i - 1] + sequence[i] * p, sequence[i] * p);
            p *= -1;
            dp2[i] = Math.max(dp2[i - 1] + sequence[i] * p, sequence[i] * p);
            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }
        
        if(sequence.length == 1) {
            answer = Math.max(dp1[0], dp2[0]);
        }
        
        return answer;
    }
}