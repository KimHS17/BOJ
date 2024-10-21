class Solution {
    public int solution(int[][] sizes) {
        int lmax = 1, smax = 1;
        
        for(int[] size: sizes) {
            int l = Math.max(size[0], size[1]);
            int s = Math.min(size[0], size[1]);
            
            lmax = Math.max(l, lmax);
            smax = Math.max(s, smax);
        }
        
        return lmax * smax;
    }
}
