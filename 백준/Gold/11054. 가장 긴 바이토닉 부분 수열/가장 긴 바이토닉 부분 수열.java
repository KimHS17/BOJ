import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dpU = new int[n];
        int[] dpD = new int[n];
        int max = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            dpU[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dpU[i] < dpU[j] + 1) {
                    dpU[i] = dpU[j] + 1;
                }
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            dpD[i] = 1;
            for(int j = n - 1; j > i; j--) {
                if(arr[j] < arr[i] && dpD[i] < dpD[j] + 1) {
                    dpD[i] = dpD[j] + 1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            max = Math.max(max, dpU[i] + dpD[i]);
        }

        System.out.println(max - 1);
    }
}