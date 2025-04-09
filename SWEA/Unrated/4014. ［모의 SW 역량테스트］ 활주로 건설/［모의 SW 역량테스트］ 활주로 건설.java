import java.io.*;
import java.util.*;

public class Solution {
    public static int airstrip(int n, int x, int[][] map, boolean isHorizontal) {
        int cntAs = 0;
        
        for(int i = 0; i < n; i++) {
            boolean pos = true;
            boolean flag = false;
            int cntCell = 1, idx = 0;

            for(int j = 1; j < n; j++) {
                int diff;
                if(isHorizontal)
                    diff = map[i][j - 1] - map[i][j];
                else
                    diff = map[j - 1][i] - map[j][i];

                if(Math.abs(diff) > 1) {
                    pos = false;
                    break;
                }

                if(diff == 0) {
                    cntCell++;
                } else if(diff == -1) {
                    if(cntCell < x) {
                        pos = false;
                        break;
                    }
                    cntCell = 1;
                } else if(diff == 1 && flag == false) {
                    flag = true;
                    cntCell = 1;
                    idx = j;
                }

                if(flag) {
                    if(j - idx + 1 == x) {
                        if(cntCell != x) {
                            pos = false;
                            break;
                        } else {
                            flag = false;
                            cntCell = 0;
                        }
                    }
                }
            }

            if(pos && !flag)
                cntAs++;
        }

        return cntAs;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int ans = airstrip(n, x, map, true) + airstrip(n, x, map, false);
            System.out.println("#" + t + " " + ans);
        }
    }
}
