import java.util.Scanner;

public class Main {
    static public int[] Nleap = new int[50];
    static public int[] num = new int[50];

    public static void dfs(int d, int n) {
        if(num[d] != -1)
            Nleap[num[d]]--;
        num[d] = -5;
        for(int i = 0; i < n; i++) {
            if(num[i] == d)
                dfs(i, n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, e, cnt = 0;

        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            if(num[i] != -1)
                Nleap[num[i]]++;
        }
        e = sc.nextInt();
        
        dfs(e, n);
        for(int i = 0; i < n; i++) {
            if(Nleap[i] == 0 && num[i] != -5)
                cnt++;
        }
        System.out.println(cnt);
        sc.close();
    }    
}
