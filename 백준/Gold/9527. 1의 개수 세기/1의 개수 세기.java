import java.util.*;
import java.io.*;

public class Main {
    static long[] dp = new long[55];

    static void initDp() {
        dp[0] = 0;
        for (int i = 1; i < 55; i++) {
            dp[i] = dp[i - 1] * 2 + (1L << (i - 1));
        }
    }

    static long count(long n) {
        if (n <= 0) return 0;

        // n 보다 작은 가장 큰 2의 제곱수
        int i = 54;
        while ((1L << i) > n) {
            i--;
        }
        long pow2 = (1L << i);

        // pow2 이전의 1의 개수
        long countUnderPow2 = dp[i];

        // pow2부터 n까지 수의 맨 앞자리 비트의 1의 수
        long leadingOnes = n - pow2 + 1;

        // pow2부터 n까지 수의 맨 앞 자리 비트를 제외한 1의 수
        long remaining = count(n - pow2);

        return countUnderPow2 + leadingOnes + remaining;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        initDp();

        long ans = count(b) - count(a - 1);
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
