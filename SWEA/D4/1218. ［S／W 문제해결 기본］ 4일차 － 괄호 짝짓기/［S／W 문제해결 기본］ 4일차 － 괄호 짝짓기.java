import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder str = new StringBuilder(br.readLine());

            for(int i = 1; i < str.length(); i++) {
                if(i > 0) {
                    int m = str.charAt(i) - str.charAt(i - 1);
                    if(m <= 2 && m >= 1) {
                        str.delete(i - 1, i + 1);
                        i -= 2;
                    }
                }
            }

            int ans = str.length() == 0 ? 1 : 0;
            System.out.println("#" + t + " " + ans);
        }
    }
}
