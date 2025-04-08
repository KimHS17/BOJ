import java.io.*;
import java.util.*;

public class Solution {
    public static void rtt(int n, int d) {
        arrow[n] -= d;
        if(arrow[n] < 0)
            arrow[n] += 8;
        arrow[n] %= 8;
    }

    public static void rotate(int n, int d) {
        int d1 = d * -1, d2 = d * -1;
        
        rtt(n, d);
        for(int i = n - 1; i >= 0; i--) {
            int idx1 = (arrow[i + 1] - d1 + 6) % 8;
            int idx2 = (arrow[i] + 2) % 8;

            if(magnetic[i][idx2] == magnetic[i + 1][idx1])
                break;
            
            rtt(i, d1);
            d1 *= -1;
        }

        for(int i = n + 1; i < 4; i++) {
            int idx1 = (arrow[i - 1] - d2 + 2) % 8;
            int idx2 = (arrow[i] + 6) % 8;

            if(magnetic[i][idx2] == magnetic[i - 1][idx1])
                break;
            
            rtt(i, d2);
            d2 *= -1;
        }
    }

    static int[][] magnetic;
    static int[] arrow;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            int k = Integer.parseInt(br.readLine());
            magnetic = new int[4][8];
            StringTokenizer st;
            for(int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 8; j++) {
                    magnetic[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            arrow = new int[4];

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                rotate(n - 1, d);
            }

            int ans = 0, score = 1;
            for(int i = 0; i < 4; i++) {
                if(magnetic[i][arrow[i]] == 1)
                    ans += score;
                score *= 2;
            }

            System.out.println("#" + t + " " + ans);
        }
    }
}
