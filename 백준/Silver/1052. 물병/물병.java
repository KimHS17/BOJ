import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k, cnt, t, res;

        n = sc.nextInt();
        k = sc.nextInt();
        for(res = 0; ; res++) {
            cnt = 0;
            t = n;

            while(t != 0) {
                if(t % 2 != 0)
                    cnt++;
                t /= 2;
            }
            if(cnt <= k)
                break;
            n++;
        }
        System.out.println(res);
        sc.close();
    }
}