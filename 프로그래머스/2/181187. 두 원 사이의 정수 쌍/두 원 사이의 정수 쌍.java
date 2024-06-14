class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        double r1p = Math.pow(r1, 2);
        double r2p = Math.pow(r2, 2);
        
        for(int i = 1; i <= r2; i++) {
            double xp = Math.pow(i, 2);
            double y1 = Math.ceil(Math.sqrt(r1p - xp));
            double y2 = Math.floor(Math.sqrt(r2p - xp));
            if(i > r1)
                y1 = 0;
            answer += y2 - y1 + 1;
        }
        return answer * 4;
    }
}