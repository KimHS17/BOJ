class Solution {
    public long solution(int[] sequence) {
        long[] sum1 = new long[sequence.length];
        long[] sum2 = new long[sequence.length];
        long answer = 0;
        int p = -1;
        
        sum1[0] = sequence[0];
        sum2[0] = sequence[0] * -1;
        for(int i = 1; i < squence.length; i++) {
            sum1[i] = sum1[i - 1] + squence[i] * p;
            p *= -1;
            sum2[i] = sum2[i - 1] + squence[i] * p;
        }
        
        
        return answer;
    }
}