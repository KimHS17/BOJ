import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;

        t = sc.nextInt();
        while(t > 0) {
            t--;
            String p, num, tmp = "";
            int n;
            boolean fw = true, print = true;

            p = sc.next();
            n = sc.nextInt();
            num = sc.next();
            int s = 0, e = num.length() - 1;
            for(int i = 0; i < p.length(); i++) {
                if(p.charAt(i) == 'R')
                    fw = !fw;
                else if(n == 0) {
                    print  = false;
                    System.out.println("error");
                    break;
                }
                else {
                    if(fw) {
                        do {
                            s++;
                        } while(num.charAt(s) >= 48 && num.charAt(s) <= 57);
                    }
                    else {
                        do {
                            e--;
                        } while(num.charAt(e) >= 48 && num.charAt(e) <= 57);
                    }
                    n--;
                }
            }

            if(print) {
                System.out.print('[');
                if(n != 0) {
                    if(fw)
                        System.out.print(num.substring(s + 1, e));
                    else {
                        for(int i = e - 1; i > s; i--) {
                            if(num.charAt(i) >= 48 && num.charAt(i) <= 57)
                                tmp = num.charAt(i) + tmp;
                            else if(num.charAt(i) == ',') {
                                System.out.print(tmp);
                                System.out.print(',');
                                tmp = "";
                            }
                            if(i == s + 1) {
                                System.out.print(tmp);
                                tmp = "";
                            }
                        }
                    }
                }
                System.out.println(']');
            }
        }
    }
}