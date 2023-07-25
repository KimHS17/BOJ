import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k, sum = 0;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] h = new int[n];
        int[] s = new int[n - 1];

        for(int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            if(i > 0)
                s[i - 1] = h[i] - h[i - 1];
        }
        Arrays.sort(s);
        for(int i = 0; i < n - k; i++)
            sum += s[i];
        System.out.println(sum);
    }
}