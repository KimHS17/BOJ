class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length};
        int l = 0, r = 0;
        int sum = sequence[0];

        while(l <= r) {
            if(sum < k) {
                if(++r >= sequence.length)
                    break;
                sum += sequence[r];
            }
            else if(sum > k) {
                    sum -= sequence[l++];
            }
            else if(sum == k) {
                if(answer[1] - answer[0] > r - l) {
                    answer[0] = l;
                    answer[1] = r;
                }
                sum -= sequence[l++];
            }
        }
        
        return answer;
    }
}