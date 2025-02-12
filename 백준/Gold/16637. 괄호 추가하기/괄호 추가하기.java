import java.io.*;

public class Main {
    static StringBuilder math;
    static int n, max = Integer.MIN_VALUE;

    static int cal(int n1, int n2, int m) {
        int res = 0;
        
        switch (m) {
            case '+':
                res = n1 + n2;
                break;
            case '-':
                res = n1 - n2;
                break;
            case '*':
                res = n1 * n2;
                break;
            default:
                break;
        }

        return res;
    }

    static void bf(int idx, int res) {
        if(idx >= n) {
            max = Math.max(max, res);
            return;
        }

        if(idx < n - 2) {
            int n1 = math.charAt(idx) - '0';
            int n2 = math.charAt(idx + 2) - '0';
            char m = math.charAt(idx + 1);
            char m2 = math.charAt(idx - 1);

            int t = cal(n1, n2, m);
            bf(idx + 4, cal(res, t, m2));
        }

        int n1 = math.charAt(idx) - '0';
        char m = math.charAt(idx - 1);
        bf(idx + 2, cal(res, n1, m));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        math = new StringBuilder(br.readLine());

        bf(2, math.charAt(0) - '0');

        System.out.println(max);
    }
}
