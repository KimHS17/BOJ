import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int t = 1; t <= 10; t++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] pw = new int[8];
            for(int i = 0; i < 8; i++) {
                pw[i] = Integer.parseInt(st.nextToken());
            }

            int idx = 0, m = 1;
            while(true) {
                pw[idx] -= m;
                if(pw[idx] <= 0) {
                    pw[idx++] = 0;
                    break;
                }
                idx = (idx + 1) % 8;
                m = m % 5 + 1;
            }

            System.out.print("#" + t + " ");
            for(int i = 0; i < 8; i++) {
                System.out.print(pw[idx] + " ");
                idx = (idx + 1) % 8;
            }
            System.out.println();
        }
    }
}
