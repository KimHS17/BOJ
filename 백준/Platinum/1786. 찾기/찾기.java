import java.io.*;
import java.util.*;

public class Main {
    static int[] pi;
    static List<Integer> list = new ArrayList<>();
    
    public static void getPi(String p) {
        int j = 0;

        for(int i = 1; i < p.length(); i++) {
            while(j > 0 && p.charAt(j) != p.charAt(i)) {
                j = pi[j - 1];
            }
            if(p.charAt(j) == p.charAt(i))
                pi[i] = ++j;
        } 
    }

    public static void kmp(String t, String p) {
        int j = 0;
        
        for(int i = 0; i < t.length(); i++) {
            while(j > 0 && t.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }

            if(t.charAt(i) == p.charAt(j)) {
                if(j == p.length() - 1) {
                    list.add(i - p.length() + 2);
                    j = pi[j];
                }
                else
                    j++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        String p = br.readLine();

        pi = new int[p.length()];
        getPi(p);
        kmp(t, p);

        System.out.println(list.size());
        for(int idx: list)
            System.out.print(idx + " ");
    }
}
