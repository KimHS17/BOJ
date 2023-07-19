import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        int id = 0, cnt = 0, cntm = 0;

        n = sc.nextInt();
        Integer[] na = new Integer[n];
        for(int i = 0; i < n; i++)
            na[i] = sc.nextInt();
        m = sc.nextInt();
        Integer[] ma = new Integer[m];
        for(int i = 0; i < m; i++)
            ma[i] = sc.nextInt();
        
        Arrays.sort(na, Collections.reverseOrder());
        Arrays.sort(ma, Collections.reverseOrder());

        for(int i = 0; i < m; i++) {
            if(ma[i] > na[0]) {
                cnt = -1;
                break;
            }
            else if(ma[i] <= na[id] && ma[i] != 0) {
                ma[i] = 0;
                id++;
                cntm++;
            }
            if(id == n || i == m - 1) {
                cnt++;
                if(cntm == m)
                    break;
                i = 0;
                id = 0;
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}