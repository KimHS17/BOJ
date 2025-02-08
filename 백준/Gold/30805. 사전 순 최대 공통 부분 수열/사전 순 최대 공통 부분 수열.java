import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        int aIdx = 0;
        int bIdx = 0;
        List<Integer> num = new ArrayList<>();

        while(max != 0) {
            max = 0;

            for(int i = aIdx; i < n; i++) {
                for(int j = bIdx; j < m; j++) {
                    if(a[i] == b[j]) {
                        max = Math.max(max, a[i]);
                    }
                }
            }

            if(max != 0) {
                num.add(max);
                for(int i = aIdx; i < n; i++) {
                    if(a[i] == max) {
                        aIdx = i + 1;
                        break;
                    }
                }
                for(int i = bIdx; i < n; i++) {
                    if(b[i] == max) {
                        bIdx = i + 1;
                        break;
                    }
                }
            }
        }

        System.out.println(num.size());
        if(num.size() != 0) {
            for(int d: num) {
                System.out.print(d + " ");
            }
        }
    }
}