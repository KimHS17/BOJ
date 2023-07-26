import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, c = 0, sum = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        int[] book = new int[n + 1];
        for(int i = 0; i < n; i++)
            book[i] = sc.nextInt();

        Arrays.sort(book);
        for(int i = 0; i <= n; i++) {
            if(book[i] == 0) {
                c = i;
                break;
            }
        }

        for(int i = 0; i < c; i += m)
            sum += book[i] * 2 * -1;
        for(int i = n; i > c; i -= m)
            sum += book[i] * 2;
        sum -= book[0] * -1 > book[n] ? book[0] * -1 : book[n];

        System.out.println(sum);
        sc.close();
    }
}