import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
    
        for(int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int r;
            String res = "OFF";

            n = (1 << n) - 1;
            r = m & n;
            if(r == n) {
                res = "ON";
            }

            System.out.println("#" + t + " " + res);
        }
	}
}