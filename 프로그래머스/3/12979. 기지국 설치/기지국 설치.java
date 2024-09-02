class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0, t = 1, w2 = w * 2 + 1, a;

        for(int s: stations) {
            a = s - w - t;
            answer += a / w2;
            if(a % w2 > 0)
                answer++;
            
            t = s + w + 1;
        }
        a = n - t + 1;
        answer += a / w2;
        if(a % w2 > 0)
            answer++;
        
        return answer;
    }
}