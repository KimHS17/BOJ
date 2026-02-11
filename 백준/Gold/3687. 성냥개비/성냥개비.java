import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] number = new ArrayList[8];

        for(int i = 0; i < 8; i++) {
            number[i] = new ArrayList<>();
        }

        number[2].add(1);
        number[3].add(7);
        number[4].add(4);
        number[5].add(2);
        number[5].add(3);
        number[5].add(5);
        number[6].add(0);
        number[6].add(6);
        number[6].add(9);
        number[7].add(8);
        
        for(int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());

            int minCnt = n;
            StringBuilder min = new StringBuilder();

            while(minCnt > 0) {
                for(int i = 7; i > 1; i--) {
                    if(minCnt >= i && minCnt - i != 1) {
                        minCnt -= i;
                        if(minCnt == 0 && i == 6) {
                            min.insert(0, 6);
                        } else {
                            min.insert(0, number[i].get(0));
                        }
                        break;
                    }
                }
            }
            if(min.toString().equals("78")) {
                min.replace(0, 2, "22");
            }
            if(min.length() > 1 && min.substring(0, 2).equals("48")) {
                min.replace(0, 2, "20");
            }
            if(min.length() > 2 && min.substring(0, 3).equals("788")) {
                min.replace(0, 3, "200");
            }
            
            int maxCnt = n;
            StringBuilder max = new StringBuilder();

            while(maxCnt > 0) {
                for(int i = 2; i < 8; i++) {
                    if(maxCnt >= i && maxCnt - i != 1) {
                        maxCnt -= i;
                        max.insert(0, number[i].get(number[i].size() - 1));
                        break;
                    }
                }
            }

            bw.write(String.valueOf(min));
            bw.write(" ");
            bw.write(String.valueOf(max));
            bw.write("\n");
            bw.flush();
        }
    }
}
