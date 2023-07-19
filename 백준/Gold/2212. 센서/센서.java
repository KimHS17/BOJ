import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, sum = 0;

        n = sc.nextInt();
        m = sc.nextInt();
        Integer[] na = new Integer[n];
        Integer[] sub = new Integer[n - 1];
        for(int i = 0; i < n; i++)
            na[i] = sc.nextInt();
        Arrays.sort(na);

        for(int i = 0; i < n - 1; i++)
            sub[i] = na[i + 1] - na[i];
        Arrays.sort(sub);

        for(int i = 0; i < n - m; i++)
            sum += sub[i];
        
        System.out.println(sum);
        sc.close();
    }
}