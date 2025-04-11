import java.io.*;

public class Main {
    static int max = 0;

    public static void getPi(String p) {
        int m = p.length();
        int[] pi = new int[m];
        int j = 0;

        for(int i = 1; i < m; i++) {
            while(j > 0 && p.charAt(j) != p.charAt(i)) {
                j = pi[j - 1];
            }
            if(p.charAt(j) == p.charAt(i)) {
                pi[i] = ++j;
                max = Math.max(max, pi[i]);
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            String subStr = str.substring(i, str.length());
            getPi(subStr);
        }

        System.out.println(max);
    }
}
