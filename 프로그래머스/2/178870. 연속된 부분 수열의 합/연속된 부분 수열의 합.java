class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 0};
        int l = 0, r = 0;
        int sum = sequence[0];

        while(l <= r) {
            if(sum < k) {
                r++;
                if(r >= sequence.length)
                    break;
                sum += sequence[r];
            }
            else if(sum > k) {
                if(l < r) {
                    sum -= sequence[l];
                    l++;
                }
                else {
                    r++;
                    if(r >= sequence.length)
                        break;
                    sum += sequence[r];
                }
            }
            else if(sum == k) {
                if(answer[1] == 0) {
                    answer[0] = l;
                    answer[1] = r;
                }
                else if(answer[1] - answer[0] > r - l) {
                    answer[0] = l;
                    answer[1] = r;
                }
                sum -= sequence[l];
                l++;
            }
        }
        
        return answer;
    }
}