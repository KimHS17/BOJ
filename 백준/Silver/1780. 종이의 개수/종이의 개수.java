import java.util.Scanner;

public class Main {
    static int[][] arr = new int[2200][2200];
    static int[] cnt = new int[3];

    public static void rec(int n, int y, int x) {
        int first = arr[y][x];
        boolean ck = false;

        for(int i = y; i < y + n; i++) {
            for(int j = x; j < x + n; j++) {
                if(first != arr[i][j]) {
                    ck = true;
                    break;
                }
            }
            if(ck)
                break;
        }

        if(ck) {
            rec(n / 3, y, x);
            rec(n / 3, y, x + n / 3);
            rec(n / 3, y, x + n / 3 * 2);
            rec(n / 3, y + n / 3, x);
            rec(n / 3, y + n / 3, x + n / 3);
            rec(n / 3, y + n / 3, x + n / 3 * 2);
            rec(n / 3, y + n / 3 * 2, x);
            rec(n / 3, y + n / 3 * 2, x + n / 3);
            rec(n / 3, y + n / 3 * 2, x + n / 3 * 2);
        }
        else
            cnt[first + 1]++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        }
        rec(n, 0, 0);
        for(int i = 0; i < 3; i++)
            System.out.println(cnt[i]);
    }
}
