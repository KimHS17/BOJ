import java.util.Scanner;

public class Main {
    static int cnt = 0;
    static boolean pg = true;

    public static void rec(int n, int r, int c, int y, int x) {
        if(pg) {
            if(r <= y + n && c <= x + n) {
                if(n == 2) {
                    for(int i = y; i < y + n; i++) {
                        for(int j = x; j < x + n; j++) {
                            if(i == r && j == c) {
                                pg = false;
                                return;
                            }
                            cnt++;
                        }
                    }
                }
                else {
                    rec(n / 2, r, c, y, x);
                    rec(n / 2, r, c, y, x + n / 2);
                    rec(n / 2, r, c, y + n / 2, x);
                    rec(n / 2, r, c, y + n / 2, x + n / 2);
                }
            }   
            else
                cnt += n * n;
        }
    }

    public static void main(String[] args) {
        int n, r, c;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        n = (int)Math.pow(2, n);

        rec(n, r, c, 0, 0);
        System.out.println(cnt);
    }
}