import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] list = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        HashSet<Integer> plug = new HashSet<>();
        int cnt = 0;

        for(int i = 0; i < k; i++) {
            if(plug.size() < n) {
                plug.add(list[i]);
            } else if(!plug.contains(list[i])) {
                int itNum = 0;
                int itIdx = -1;
                
                for(Integer item: plug) {
                    boolean isRemain = false;

                    for(int j = i + 1; j < k; j++) {
                        if(list[j] == item) {
                            isRemain = true;
                            if(itIdx < j) {
                                itNum = item;
                                itIdx = j;
                            }
                            break;
                        }
                    }

                    if(!isRemain) {
                        itNum = item;
                        break;
                    }
                }
                plug.remove(itNum);
                plug.add(list[i]);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
